package model;

import DAO.registuserdao;

public class registlogic {
	public boolean execute(User user) {
		registuserdao rdao = new registuserdao();
		boolean canRegist = rdao.NewRegist(user);
		return canRegist;
	}
}
