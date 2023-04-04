package cn.gourdpa.springframework.beans.factory.config;

import cn.gourdpa.springframework.beans.factory.HierarchicaBeanFactory;

public interface ConfigurableBeanFactory extends HierarchicaBeanFactory,SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
