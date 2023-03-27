package cn.gourdpa.springframework.beans.factory;


import cn.gourdpa.springframework.beans.BeansException;

public interface BeanFactory {
    Object getBean(String beanName);

    Object getBean(String beanName, Object... args);

    <T> T getBean(String beanName, Class<T> requiredType) throws BeansException;
}
