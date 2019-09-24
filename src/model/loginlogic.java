package model;

import DAO.userdao;

public class loginlogic {

	public User execute(User user) {
		userdao udao = new userdao();
		User loginuser = udao.logincheck(user);
		if(loginuser !=null) {
			return loginuser;
		}
		return null;
	}
}
