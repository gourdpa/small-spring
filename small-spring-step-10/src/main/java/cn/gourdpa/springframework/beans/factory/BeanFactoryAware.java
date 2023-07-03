package cn.gourdpa.springframework.beans.factory;

import cn.gourdpa.springframework.beans.BeansException;

public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
