package cn.gourdpa.springframework.beans.factory.support;

import cn.gourdpa.springframework.beans.BeansException;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) {
        Class clazz = beanDefinition.getBeanClass();
        Object bean = null;
        try {
            if (null != constructor) {
                bean = clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                bean = clazz.newInstance();
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new BeansException("Faild to instantiate [" + clazz.getName() + "]", e);
        }
        return bean;

    }
}
