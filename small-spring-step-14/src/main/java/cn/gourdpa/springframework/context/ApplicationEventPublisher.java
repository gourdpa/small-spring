package cn.gourdpa.springframework.context;

public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
