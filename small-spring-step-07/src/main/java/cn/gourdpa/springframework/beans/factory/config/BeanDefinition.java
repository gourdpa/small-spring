package cn.gourdpa.springframework.beans.factory.config;

import cn.gourdpa.springframework.beans.PropertyValues;

/**
 * bean定义
 */
public class BeanDefinition {
    private Class clazz;
    private PropertyValues propertyValues;

    public BeanDefinition(Class clazz) {
        this.clazz = clazz;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class clazz, PropertyValues propertyValues) {
        this.clazz = clazz;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
