package cn.gourdpa.springframework.beans.factory.config;

/**
 * @ClassName: BeanDefinition
 * @Description: TODO
 * @author: hx
 * @date: 2023-02-20 11:16
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
