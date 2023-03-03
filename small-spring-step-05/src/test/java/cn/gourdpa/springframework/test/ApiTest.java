package cn.gourdpa.springframework.test;

import cn.gourdpa.springframework.beans.ProperValue;
import cn.gourdpa.springframework.beans.ProperValues;
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
        beanFactory.registryBeanDefinition("userDao",new BeanDefinition(UserDao.class));


        ProperValues properValues = new ProperValues();
        properValues.addProperValue(new ProperValue("uId","10001"));
        properValues.addProperValue(new ProperValue("userDao",new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, properValues);
        beanFactory.registryBeanDefinition("userService",beanDefinition);

        UserService userService =(UserService) beanFactory.getBean("userService");
        System.out.println(userService.queryUserName());
    }
}
