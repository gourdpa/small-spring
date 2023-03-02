package cn.gourdpa.springframework.core.io;

/**
 * 资源获取接口
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
