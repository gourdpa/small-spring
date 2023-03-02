package cn.gourdpa.springframework.test.service;

import cn.gourdpa.springframework.test.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public String queryUserName(String uId) {
        return userDao.queryUserName(uId);
    }
}
