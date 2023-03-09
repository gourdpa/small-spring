package cn.gourdpa.springframework.test;

import cn.gourdpa.springframework.beans.PropertyValue;
import cn.gourdpa.springframework.beans.PropertyValues;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;
import cn.gourdpa.springframework.beans.factory.config.BeanReference;
import cn.gourdpa.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.gourdpa.springframework.test.dao.UserDao;
import cn.gourdpa.springframework.test.service.UserService;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test_beanfactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册userDao
        beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));


        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addProperValue(new PropertyValue("uId","10001"));
        propertyValues.addProperValue(new PropertyValue("userDao",new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService =(UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
