import bean.UserService;
import org.junit.Test;

/**
 * @ClassName: ApiTest
 * @Description: TODO
 * @author: hx
 * @date: 2022-12-16 15:31
 * @Version: 1.0
 **/

public class ApiTest {
    @Test
    public void test_BeanFactory(){
        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
