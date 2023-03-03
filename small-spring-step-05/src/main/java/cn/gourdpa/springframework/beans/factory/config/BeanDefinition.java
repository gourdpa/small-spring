package cn.gourdpa.springframework.beans.factory.config;

import cn.gourdpa.springframework.beans.ProperValues;

public class BeanDefinition {
    private Class beanClass;
    private ProperValues properValues;


    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition(Class beanClass, ProperValues properValues) {
        this.beanClass = beanClass;
        this.properValues = properValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public ProperValues getProperValues() {
        return properValues;
    }

    public void setProperValues(ProperValues properValues) {
        this.properValues = properValues;
    }
}
