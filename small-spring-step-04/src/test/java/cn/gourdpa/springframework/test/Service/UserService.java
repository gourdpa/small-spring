package cn.gourdpa.springframework.test.Service;

import cn.gourdpa.springframework.test.dao.UserDao;

public class UserService {

    private String uId;
    private UserDao userDao;
    public void queryUserInfo(){
        System.out.println(userDao.queryUserName(uId));
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
}
