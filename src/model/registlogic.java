package model;

import dao.RegistUserDao;

public class RegistLogic {
	public boolean execute(User user) {
		RegistUserDao rdao = new RegistUserDao();
		boolean canRegist = rdao.newRegist(user);
		return canRegist;
	}
}
