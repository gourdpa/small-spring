package cn.gourdpa.springframework.utils;

public class ClassUtils {
    public static ClassLoader getDefaultClassLoader(){
        ClassLoader cl = null;
        try {
            cl=Thread.currentThread().getContextClassLoader();
        }catch (Throwable e){

        }
        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }

}
