package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.User;
import com.lexus.dao.IUserDAO;
import com.lexus.service.IBaseUserService;

public abstract class BaseUserServiceImpl implements IBaseUserService {
	private IUserDAO userDAO;
	public BaseUserServiceImpl() {
		// TODO 自动生成构造函数存根
	}

	public void attachClean(User instance) {
		// TODO 自动生成方法存根

	}

	public void attachDirty(User instance) {
		// TODO 自动生成方法存根

	}

	public void delete(User persistentInstance) {
		// TODO 自动生成方法存根
		this.userDAO.delete(persistentInstance);

	}

	public List findByAnswer(Object answer) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByEmail(Object email) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByExample(User instance) {
		// TODO 自动生成方法存根
		return null;
	}

	public User findById(Integer id) {
		// TODO 自动生成方法存根
		return this.userDAO.findById(id);
	}

	public List findByLastLoginIp(Object lastLoginIp) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByNickName(Object nickName) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByPassword(Object password) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByQuestion(Object question) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByStatus(Object status) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByUsername(Object username) {
		return this.userDAO.findByUsername(username);
	}

	public List findByVersion(Object version) {
		// TODO 自动生成方法存根
		return null;
	}

	public User merge(User detachedInstance) {
		// TODO 自动生成方法存根
		return null;
	}

	public void save(User transientInstance) {
		this.userDAO.save(transientInstance);
	}

	/**
	 * @return userDAO
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO 要设置的 userDAO
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}



}
