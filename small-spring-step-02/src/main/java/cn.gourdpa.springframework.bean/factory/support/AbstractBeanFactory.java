package cn.gourdpa.springframework.bean.factory.support;

import cn.gourdpa.springframework.bean.BeansException;
import cn.gourdpa.springframework.bean.factory.BeanFactory;
import cn.gourdpa.springframework.bean.factory.config.BeanDefinition;

/**
 * @ClassName: AbstractBeanFactory
 * @Description: 抽象工厂类实现模板模式
 * @author: hx
 * @date: 2023-02-16 10:57
 * @Version: 1.0
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName,beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
