package cn.gourdpa.springframework.bean.factory.config;

/**
 * @ClassName: BeanDefinition
 * @Description: TODO
 * @author: hx
 * @date: 2023-02-16 10:52
 * @Version: 1.0
 **/
public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
