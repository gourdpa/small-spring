package cn.gourdpa.springframework.test.dao;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "first");
        hashMap.put("10002", "second");
        hashMap.put("10003", "third");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }



}
