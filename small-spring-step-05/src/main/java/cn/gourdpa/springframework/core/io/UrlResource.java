package cn.gourdpa.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 读取网络路径下文件
 */
public class UrlResource implements Resource{
    private final URL url;

    public UrlResource(URL url) {
        Assert.isNull(url,"URL must be not null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection conn = this.url.openConnection();
        try {
            return conn.getInputStream();
        }catch (IOException e){
            if (conn instanceof HttpURLConnection){
                ((HttpURLConnection) conn).disconnect();
            }
            throw e;
        }
    }
}
