package cn.gourdpa.springframework.bean;

/**
 * @ClassName: BeanException
 * @Description: 异常
 * @author: hx
 * @date: 2023-02-16 11:06
 * @Version: 1.0
 **/
public class BeansException extends RuntimeException{
    public BeansException() {
        super();
    }

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
