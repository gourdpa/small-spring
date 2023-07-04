package cn.gourdpa.springframework.test;


import cn.gourdpa.springframework.aop.AdvisedSupport;
import cn.gourdpa.springframework.aop.TargetSource;
import cn.gourdpa.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.gourdpa.springframework.aop.framework.Cglib2AopProxy;
import cn.gourdpa.springframework.aop.framework.JdkDynamicAopProxy;
import cn.gourdpa.springframework.test.bean.IUserService;
import cn.gourdpa.springframework.test.bean.UserService;
import cn.gourdpa.springframework.test.bean.UserServiceInterceptor;
import org.junit.Test;

import java.lang.reflect.Method;

public class ApiTest {

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* cn.gourdpa.springframework"
                + ".test.bean.UserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method,clazz));
    }

    @Test
    public void test_dynamic() {
        IUserService userService = new UserService();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.gourdpa.springframework.test"
                + ".bean.IUserService.queryUserInfo())"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));


    }


}
