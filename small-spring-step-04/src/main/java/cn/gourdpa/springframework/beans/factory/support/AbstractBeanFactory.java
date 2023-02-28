package cn.gourdpa.springframework.beans.factory.support;

import cn.gourdpa.springframework.beans.BeansException;
import cn.gourdpa.springframework.beans.factory.BeanFactory;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) {
        Object bean = getSingleton(beanName);
        if (null != bean){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);

        return createBean(beanName,beanDefinition,null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        Object bean = getSingleton(beanName);
        if (null != bean){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);

        return createBean(beanName,beanDefinition,args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args);


}
