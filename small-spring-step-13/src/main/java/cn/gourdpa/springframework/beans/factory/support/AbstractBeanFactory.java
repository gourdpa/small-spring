package cn.gourdpa.springframework.beans.factory.support;

import cn.gourdpa.springframework.beans.BeansException;
import cn.gourdpa.springframework.beans.factory.FactoryBean;
import cn.gourdpa.springframework.beans.factory.config.BeanDefinition;
import cn.gourdpa.springframework.beans.factory.config.BeanPostProcessor;
import cn.gourdpa.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.gourdpa.springframework.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
        return (T) getBean(beanName);
    }

    protected <T> T doGetBean(String beanName, Object[] args) {
        Object singleton = getSingleton(beanName);
        if (singleton != null) {
            return (T) getObjectForBeanInstance(singleton,beanName);
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        singleton = createBean(beanName, beanDefinition, args);
        return (T) singleton;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCachedObjectForFactoryBean(beanName);
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }
}
