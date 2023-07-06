package cn.gourdpa.springframework.beans.factory.support;

import cn.gourdpa.springframework.beans.BeansException;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        Object bean;
        try {
            if (null != ctor) {
                bean = clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                bean = clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]");
        }
        return bean;
    }
}
