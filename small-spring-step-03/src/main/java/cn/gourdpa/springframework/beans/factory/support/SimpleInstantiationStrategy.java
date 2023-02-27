package cn.gourdpa.springframework.beans.factory.support;

import cn.gourdpa.springframework.beans.BeansException;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName: SimpleInstantiationStrategy
 * @Description: TODO
 * @author: hx
 * @date: 2023-02-20 11:21
 * @Version: 1.0
 **/
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,
                              Object[] args) throws BeansException {
        Class beanClazz = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                return beanClazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance();
            } else {
                return beanClazz.getDeclaredConstructor().newInstance();
            }
        }
        catch (InvocationTargetException|InstantiationException|IllegalAccessException|NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + beanClazz.getName() + "]", e);
        }
    }
}
