package cn.gourdpa.springframework.bean.factory.support;

import cn.gourdpa.springframework.bean.BeansException;
import cn.gourdpa.springframework.bean.factory.config.BeanDefinition;

/**
 * @ClassName: AbstractAutowireCapableBeanFactory
 * @Description: TODO
 * @author: hx
 * @date: 2023-02-16 11:04
 * @Version: 1.0
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        }
        catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
