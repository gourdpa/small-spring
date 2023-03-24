package cn.gourdpa.springframework.beans.factory.support;

import cn.gourdpa.springframework.beans.BeansException;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化接口   策略模式
 */
public interface InstantiationStrategy {
    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor constructor, Object[] args) throws BeansException;
}
