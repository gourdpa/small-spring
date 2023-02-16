package cn.gourdpa.springframework.bean.factory.config;

/**
 * @ClassName: SingletonBeanRegistry
 * @Description: 单例注册接口
 * @author: hx
 * @date: 2023-02-16 10:53
 * @Version: 1.0
 **/
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
