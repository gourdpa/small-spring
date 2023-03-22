package cn.gourdpa.springframework.test;

import cn.gourdpa.springframework.beans.PropertyValue;
import cn.gourdpa.springframework.beans.PropertyValues;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;
import cn.gourdpa.springframework.beans.factory.config.BeanReference;
import cn.gourdpa.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.gourdpa.springframework.beans.factory.xml.Dom4jXmlBeanDefinitionReader;
import cn.gourdpa.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.gourdpa.springframework.core.io.DefaultResourceLoader;
import cn.gourdpa.springframework.core.io.Resource;
import cn.gourdpa.springframework.test.dao.UserDao;
import cn.gourdpa.springframework.test.service.UserService;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.XmlUtil;
import org.dom4j.DocumentException;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;

public class ApiTest {

    private DefaultResourceLoader resourceLoader;
    @Before
    public void init(){
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:spring.xml");
        InputStream inputStream = resource.getInputStream();
        Document document = XmlUtil.readXML(inputStream);
        Element documentElement = document.getDocumentElement();
        String nodeName = documentElement.getNodeName();
        String nodeValue = documentElement.getNodeValue();
        System.out.println(documentElement);
        System.out.println(nodeName);
        System.out.println(nodeValue);

    }
    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();


    }

    @Test
    public void test_dom4jXML() throws IOException, DocumentException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        Dom4jXmlBeanDefinitionReader reader = new Dom4jXmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }

    @Test
    public void test_beanfactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册userDao
        beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));


        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService =(UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
