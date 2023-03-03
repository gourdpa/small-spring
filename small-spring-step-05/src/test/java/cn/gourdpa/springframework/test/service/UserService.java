package cn.gourdpa.springframework.test.service;

import cn.gourdpa.springframework.test.dao.UserDao;

public class UserService {
    private String uId;
    private UserDao userDao;

    public UserService(String uId, UserDao userDao) {
        this.uId = uId;
        this.userDao = userDao;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String queryUserName() {
        return userDao.queryUserName(this.uId);
    }


}
