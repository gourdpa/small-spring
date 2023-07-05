package cn.gourdpa.springframework.context.event;

import cn.gourdpa.springframework.beans.factory.BeanFactory;
import cn.gourdpa.springframework.context.ApplicationEvent;
import cn.gourdpa.springframework.context.ApplicationListener;

public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }
    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
