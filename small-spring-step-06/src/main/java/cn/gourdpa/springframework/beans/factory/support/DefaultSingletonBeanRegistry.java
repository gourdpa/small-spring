package cn.gourdpa.springframework.beans.factory.support;

import cn.gourdpa.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 缺省实现单例获取及存储
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object object) {
        this.singletonObjects.put(beanName, object);
    }
}
