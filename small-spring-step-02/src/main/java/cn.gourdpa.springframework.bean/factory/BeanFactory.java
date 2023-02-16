package cn.gourdpa.springframework.bean.factory;

/**
 * @ClassName: BeanFatory
 * @Description: Bean工厂
 * @author: hx
 * @date: 2023-02-16 10:50
 * @Version: 1.0
 **/
public interface BeanFactory {
    public Object getBean(String beanName);
}
