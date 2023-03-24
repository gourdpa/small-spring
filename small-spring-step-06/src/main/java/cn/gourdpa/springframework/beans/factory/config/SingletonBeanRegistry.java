package cn.gourdpa.springframework.beans.factory.config;

/**
 * 单例获取接口
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
