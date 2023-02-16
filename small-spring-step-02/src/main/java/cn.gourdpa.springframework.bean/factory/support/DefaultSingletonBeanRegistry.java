package cn.gourdpa.springframework.bean.factory.support;

import cn.gourdpa.springframework.bean.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DefaultSingletonBeanRegistry
 * @Description: 缺省单例类注册接口实现
 * @author: hx
 * @date: 2023-02-16 10:54
 * @Version: 1.0
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
