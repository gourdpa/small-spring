package cn.gourdpa.springframework.test.event;

import cn.gourdpa.springframework.context.ApplicationListener;
import cn.gourdpa.springframework.context.event.ContextClosedEvent;

public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
