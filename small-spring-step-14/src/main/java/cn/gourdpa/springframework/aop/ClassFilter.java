package cn.gourdpa.springframework.aop;

public interface ClassFilter {
    boolean matches(Class<?> clazz);
}
