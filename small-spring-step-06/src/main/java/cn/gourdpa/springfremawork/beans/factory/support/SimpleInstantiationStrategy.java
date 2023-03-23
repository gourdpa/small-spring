package cn.gourdpa.springfremawork.beans.factory.support;

import cn.gourdpa.springfremawork.beans.BeansException;
import cn.gourdpa.springfremawork.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 利用反射 实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor constructor, Object[] args) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        Object bean;
        try {
            if (constructor != null) {
                bean = beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                bean = beanClass.getDeclaredConstructor().newInstance();
            }
        }catch (NoSuchMethodException| InvocationTargetException| InstantiationException| IllegalAccessException e){
            throw new BeansException("Faild to instantiate [" + beanClass.getName()+ "]",e);
        }
        return bean;
    }
}
