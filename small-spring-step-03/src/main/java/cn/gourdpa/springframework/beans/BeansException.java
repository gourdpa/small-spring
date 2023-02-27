package cn.gourdpa.springframework.beans;

/**
 * @ClassName: BeanException
 * @Description: TODO
 * @author: hx
 * @date: 2023-02-20 11:08
 * @Version: 1.0
 **/
public class BeansException extends Exception {
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
