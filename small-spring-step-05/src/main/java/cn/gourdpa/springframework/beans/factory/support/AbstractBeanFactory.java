package cn.gourdpa.springframework.beans.factory.support;

import cn.gourdpa.springframework.beans.factory.BeanFactory;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;


public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) {

        Object singleton = getSingleton(beanName);
        if (null != singleton) {
            return singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        singleton = createBean(beanName, beanDefinition, null);
        return singleton;
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        Object singleton = getSingleton(beanName);
        if (null != singleton) {
            return singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        singleton = createBean(beanName, beanDefinition, args);
        return singleton;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);


}
