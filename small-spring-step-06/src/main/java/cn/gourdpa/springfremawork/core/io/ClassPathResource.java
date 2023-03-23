package cn.gourdpa.springfremawork.core.io;

import cn.gourdpa.springfremawork.utils.ClassUtils;
import cn.hutool.core.lang.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource {
    private String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = this.classLoader.getResourceAsStream(path);
        if (inputStream == null){
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
            return inputStream;
    }
}
