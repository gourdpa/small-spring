package cn.gourdpa.springframework.beans.factory.config;


import cn.gourdpa.springframework.beans.BeansException;
import cn.gourdpa.springframework.beans.factory.ConfigurableListableBeanFactory;

import javax.security.auth.login.Configuration;
import java.beans.Beans;

public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
