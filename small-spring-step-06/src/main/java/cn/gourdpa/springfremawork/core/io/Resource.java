package cn.gourdpa.springfremawork.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源加载接口
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
