package cn.gourdpa.springframework.test;

import cn.gourdpa.springframework.beans.factory.BeanFactory;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;
import cn.gourdpa.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.gourdpa.springframework.test.dao.UserDao;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test_beanfactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册userDao
        beanFactory.registryBeanDefinition("userDao",new BeanDefinition(UserDao.class));
        
    }
}
