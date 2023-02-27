package cn.gourdpa.springframework.test;

import cn.gourdpa.springframework.beans.BeansException;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;
import cn.gourdpa.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.gourdpa.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @ClassName: ApiTest
 * @Description: TODO
 * @author: hx
 * @date: 2023-02-20 15:00
 * @Version: 1.0
 **/
public class ApiTest {
    @Test
    public void test_BeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registryBeanDefinition("userService",beanDefinition);

        //获取
        UserService userService = (UserService) beanFactory.getBean("userService","猜猜我是谁");
        userService.queryUserInfo();

    }
}
