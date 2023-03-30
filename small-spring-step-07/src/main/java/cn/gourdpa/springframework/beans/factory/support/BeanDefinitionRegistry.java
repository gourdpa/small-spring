package cn.gourdpa.springframework.beans.factory.support;

import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;

/**
 * Bean注册
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册bean
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 通过beanName获取注册信息
     * @param beanName
     * @return
     */
    BeanDefinition getBeanDefinition(String beanName);

    /**
     * 判断是否存在注册信息
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 查询所有已注册bean名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
