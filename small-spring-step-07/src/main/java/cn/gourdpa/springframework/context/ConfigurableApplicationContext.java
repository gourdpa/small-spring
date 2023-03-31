package cn.gourdpa.springframework.context;

import cn.gourdpa.springframework.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext{
    void refresh() throws BeansException;
}
