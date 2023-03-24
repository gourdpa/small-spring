package cn.gourdpa.springframework.beans.factory.support;

import cn.gourdpa.springframework.beans.BeansException;
import cn.gourdpa.springframework.beans.factory.BeanFactory;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory  {
    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName,args);
    }

    private Object doGetBean(String beanName, Object[] args) {
        Object singleton = this.getSingleton(beanName);
        if (null == singleton) {
            //注册bean
            BeanDefinition beanDefinition = getBeanDefinition(beanName);
            //创建bean
            singleton = createBean(beanName, beanDefinition, args);
        }

        return singleton;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);


}
