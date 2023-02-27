package cn.gourdpa.springframework.beans.factory.config;

/**
 * @ClassName: SingletonBeanRegistry
 * @Description: TODO
 * @author: hx
 * @date: 2023-02-20 13:56
 * @Version: 1.0
 **/
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
