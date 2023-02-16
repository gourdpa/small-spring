package cn.gourdpa.springframework.test;

import cn.gourdpa.springframework.bean.factory.config.BeanDefinition;
import cn.gourdpa.springframework.bean.factory.support.DefaultListableBeanFactory;
import cn.gourdpa.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @ClassName: ApiTest
 * @Description: TODO
 * @author: hx
 * @date: 2023-02-16 11:30
 * @Version: 1.0
 **/
public class ApiTest {
    @Test
    public void test_BeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryUserInfo();
    }
}
