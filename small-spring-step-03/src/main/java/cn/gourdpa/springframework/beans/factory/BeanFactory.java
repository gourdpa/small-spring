package cn.gourdpa.springframework.beans.factory;

import cn.gourdpa.springframework.beans.BeansException;

/**
 * @ClassName: BeanFactory
 * @Description: TODO
 * @author: hx
 * @date: 2023-02-20 11:09
 * @Version: 1.0
 **/
public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;
}
