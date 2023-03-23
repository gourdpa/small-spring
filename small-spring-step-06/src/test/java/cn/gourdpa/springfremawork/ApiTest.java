package cn.gourdpa.springfremawork;

import cn.gourdpa.springfremawork.beans.PropertyValue;
import cn.gourdpa.springfremawork.beans.PropertyValues;
import cn.gourdpa.springfremawork.beans.factory.config.BeanDefinition;
import cn.gourdpa.springfremawork.beans.factory.config.BeanReference;
import cn.gourdpa.springfremawork.beans.factory.support.DefaultListableBeanFactory;
import cn.gourdpa.springfremawork.dao.UserDao;
import cn.gourdpa.springfremawork.service.UserService;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test_createbean(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
