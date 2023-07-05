package cn.gourdpa.springframework.context.event;

import cn.gourdpa.springframework.context.ApplicationEvent;
import cn.gourdpa.springframework.context.ApplicationListener;

public interface ApplicationEventMulticaster {
    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
