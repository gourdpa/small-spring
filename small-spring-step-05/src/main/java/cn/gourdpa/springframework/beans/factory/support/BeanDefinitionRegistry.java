package cn.gourdpa.springframework.beans.factory.support;

import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;

/**
 * bean注册接口
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
