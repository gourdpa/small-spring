package cn.gourdpa.springframework.beans.factory.support;

import cn.gourdpa.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例注册表
 */
public class DefaultSingletonRegistry implements SingletonBeanRegistry {
    private final Map<String, Object> singletonObjects = new HashMap<>();
    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }

    public void addSingleton(String beanName, Object bean) {
        this.singletonObjects.put(beanName, bean);
    }
}
