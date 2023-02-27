package cn.gourdpa.springframework.test.bean;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @author: hx
 * @date: 2023-02-20 15:01
 * @Version: 1.0
 **/
public class UserService {
    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
