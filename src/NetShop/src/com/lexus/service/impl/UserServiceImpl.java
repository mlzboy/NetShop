package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.User;
import com.lexus.service.IUserService;

public class UserServiceImpl extends BaseUserServiceImpl implements
		IUserService {
	// private IUserDAO userDAO;
	public boolean loginValidate(String username, String password) {
		return this.getUserDAO().validateLogin(username, password);
	}

	// /**
	// * @return userDAO
	// */
	// public IUserDAO getUserDAO() {
	// return userDAO;
	// }
	// /**
	// * @param userDAO 要设置的 userDAO
	// */
	// public void setUserDAO(IUserDAO userDAO) {
	// this.userDAO = userDAO;
	// }

	public List findByAll() {
		return this.getUserDAO().findByAll();
	}

	public void saveOrUpdate(User user) {
		this.getUserDAO().saveOrUpdate(user);
	}

}
