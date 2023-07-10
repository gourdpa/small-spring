package cn.gourdpa.springframework.context;

import cn.gourdpa.springframework.beans.factory.HierarchicaBeanFactory;
import cn.gourdpa.springframework.beans.factory.ListableBeanFactory;
import cn.gourdpa.springframework.context.event.ApplicationEventMulticaster;
import cn.gourdpa.springframework.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicaBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
