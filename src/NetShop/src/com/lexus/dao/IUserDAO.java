package com.lexus.dao;

import java.util.List;

import com.lexus.bean.User;

public interface IUserDAO extends IBaseUserDAO {
	public boolean validateLogin(String username,String password);
	public List findByAll();
	public void saveOrUpdate(User user);
}
