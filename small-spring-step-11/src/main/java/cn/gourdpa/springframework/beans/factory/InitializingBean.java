package cn.gourdpa.springframework.beans.factory;

public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
