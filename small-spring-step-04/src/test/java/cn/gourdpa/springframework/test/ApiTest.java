package cn.gourdpa.springframework.test;

import cn.gourdpa.springframework.beans.PropertyValue;
import cn.gourdpa.springframework.beans.PropertyValues;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;
import cn.gourdpa.springframework.beans.factory.config.BeanReference;
import cn.gourdpa.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.gourdpa.springframework.test.Service.UserService;
import cn.gourdpa.springframework.test.dao.UserDao;
import org.junit.Test;

public class ApiTest {
    @Test
    public void fTest(){
        //初始化factory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //UserDao注册
        beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));

        //设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        //UserService注册
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registerBeanDefinition("userService" ,beanDefinition);

        //获取
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
}
