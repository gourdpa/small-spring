package cn.gourdpa.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemResource implements Resource{
    private File file;
    private String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }
    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

    public String getPath() {
        return path;
    }
}
