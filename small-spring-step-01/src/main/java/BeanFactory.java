import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: BeanFactory
 * @Description: TODO
 * @author: hx
 * @date: 2022-12-16 15:31
 * @Version: 1.0
 **/
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name, beanDefinition);
    }
}
