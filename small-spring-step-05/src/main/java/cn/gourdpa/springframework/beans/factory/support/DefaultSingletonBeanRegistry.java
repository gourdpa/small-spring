package cn.gourdpa.springframework.beans.factory.support;

import cn.gourdpa.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.HashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjects = new HashMap<>();
    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        this.singletonObjects.put(beanName, singletonObject);
    }
}
