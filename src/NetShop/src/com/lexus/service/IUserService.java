package com.lexus.service;

import java.util.List;

import com.lexus.bean.User;

public interface IUserService extends IBaseUserService {
	public boolean loginValidate(String username,String password);
	public List findByAll();
	public void saveOrUpdate(User user);
}
