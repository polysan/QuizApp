package model;

import dao.UserDao;

public class LoginLogic {

  public User execute(User user) {
    UserDao udao = new UserDao();
    User loginuser = udao.loginCheck(user);
    if(loginuser !=null) {
      return loginuser;
    }
    return null;
  }
}
