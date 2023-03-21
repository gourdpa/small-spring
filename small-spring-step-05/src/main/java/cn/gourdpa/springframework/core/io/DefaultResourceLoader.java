package cn.gourdpa.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location,"Location must be not null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)){
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else {
            // TODO 这里将逻辑处理放在catch中是否合适？
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }

        }
    }
}
