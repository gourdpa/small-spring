package cn.gourdpa.springframework.beans.factory.config;

import cn.gourdpa.springframework.beans.BeansException;

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{
    Object postProcessBeforeInstantiation(Class<?> beanClass,String beanName)throws BeansException;
}
