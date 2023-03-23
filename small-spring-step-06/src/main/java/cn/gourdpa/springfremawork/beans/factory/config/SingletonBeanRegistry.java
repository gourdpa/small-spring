package cn.gourdpa.springfremawork.beans.factory.config;

/**
 * 单例获取接口
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
