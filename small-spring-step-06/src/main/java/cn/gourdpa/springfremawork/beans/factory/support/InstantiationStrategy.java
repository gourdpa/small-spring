package cn.gourdpa.springfremawork.beans.factory.support;

import cn.gourdpa.springfremawork.beans.BeansException;
import cn.gourdpa.springfremawork.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化接口   策略模式
 */
public interface InstantiationStrategy {
    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor constructor, Object[] args) throws BeansException;
}
