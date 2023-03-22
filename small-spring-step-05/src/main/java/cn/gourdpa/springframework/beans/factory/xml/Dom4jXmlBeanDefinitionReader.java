package cn.gourdpa.springframework.beans.factory.xml;

import cn.gourdpa.springframework.beans.BeansException;
import cn.gourdpa.springframework.beans.PropertyValue;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;
import cn.gourdpa.springframework.beans.factory.config.BeanReference;
import cn.gourdpa.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import cn.gourdpa.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.gourdpa.springframework.core.io.Resource;
import cn.gourdpa.springframework.core.io.ResourceLoader;
import cn.hutool.core.util.StrUtil;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Dom4jXmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public Dom4jXmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public Dom4jXmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        }catch (IOException | DocumentException | ClassNotFoundException e){
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws DocumentException, ClassNotFoundException {
        SAXReader aDefault = SAXReader.createDefault();
        Document doc = aDefault.read(inputStream);


        Element root = doc.getRootElement();
        List<Element> elements = root.elements();

        for (int i = 0; i <elements.size() ; i++) {
            Element element = elements.get(i);
            //判断元素
            //if (elements.get(i) instanceof Element) continue;
            //判断对象
            if (!"bean".equals(elements.get(i).getName())) continue;

            //解析标签
            Element bean = elements.get(i);
            String id = bean.attributeValue("id");
            String name = bean.attributeValue("name");
            String className = bean.attributeValue("class");

            //获取class 方便获取类中的名称
            Class<?> clazz = Class.forName(className);

            //优先id
            String beanName = StrUtil.isNotEmpty(id) ? id:name;
            if (StrUtil.isEmpty(beanName)){
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            //定义bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            //读取属性并填充
            for (int j = 0; j < bean.elements().size(); j++) {
                //if (!(bean.attribute(j) instanceof Element)) continue;
                if (!"property".equals(bean.elements().get(j).getName())) continue;

                //解析property标签
                Element property = bean.elements().get(j);
                String attrName = property.attributeValue("name");
                String attrValue = property.attributeValue("value");
                String attrRef = property.attributeValue("ref");

                //获取属性值：引入对象、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }

            if (getRegistry().containsBeanDefinition(beanName)){
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }

            getRegistry().registerBeanDefinition(beanName,beanDefinition);
        }
    }
}
