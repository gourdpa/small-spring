package cn.gourdpa.springfremawork.beans.factory.support;

import cn.gourdpa.springfremawork.beans.BeansException;
import cn.gourdpa.springfremawork.beans.PropertyValue;
import cn.gourdpa.springfremawork.beans.PropertyValues;
import cn.gourdpa.springfremawork.beans.factory.config.BeanDefinition;
import cn.gourdpa.springfremawork.beans.factory.config.BeanReference;
import cn.hutool.core.bean.BeanUtil;
import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object object;
        try {
            //实例化
            object = createBeanInstance(beanName, beanDefinition, args);
            applyPropertyValues(beanName, object, beanDefinition);
            //填充属性
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        //添加存储
        addSingleton(beanName,object);
        return object;
    }

    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyvalue: propertyValues.getPropertyValueList()) {
                String name = propertyvalue.getName();
                Object value = propertyvalue.getValue();

                if (value instanceof BeanReference){
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean,name,value);
            }
        }catch (BeansException e){
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Constructor constructorToUse = null;
        Class beanClass = beanDefinition.getBeanClass();
        for (Constructor constructor : beanClass.getDeclaredConstructors()) {
            if (null != args && constructor.getParameterTypes().length == args.length) {
                constructorToUse = constructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanName, beanDefinition, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
