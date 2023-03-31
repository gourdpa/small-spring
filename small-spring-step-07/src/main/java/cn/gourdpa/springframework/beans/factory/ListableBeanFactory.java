package cn.gourdpa.springframework.beans.factory;

import cn.gourdpa.springframework.beans.BeansException;

import java.util.Map;
public interface ListableBeanFactory extends BeanFactory{
    /**
     *按照类型返回bean
     * @param type
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回所有bean名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
