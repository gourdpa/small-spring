package cn.gourdpa.springframework.beans.factory;

import cn.gourdpa.springframework.beans.BeansException;

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;
}
