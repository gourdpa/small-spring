package cn.gourdpa.springframework.bean.factory.support;

import cn.gourdpa.springframework.bean.factory.config.BeanDefinition;

/**
 * @ClassName: BeanDefinitionRegistry
 * @Description: 类注册接口
 * @author: hx
 * @date: 2023-02-16 11:13
 * @Version: 1.0
 **/
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
