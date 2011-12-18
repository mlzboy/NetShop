package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.UserDetail;
import com.lexus.dao.IUserDetailDAO;
import com.lexus.service.IBaseUserDetailService;

public abstract class BaseUserDetailServiceImpl implements IBaseUserDetailService {
	private IUserDetailDAO userDetailDAO;
	public BaseUserDetailServiceImpl() {
		// TODO 自动生成构造函数存根
	}

	public void attachClean(UserDetail instance) {
		// TODO 自动生成方法存根

	}

	public void attachDirty(UserDetail instance) {
		// TODO 自动生成方法存根

	}

	public void delete(UserDetail persistentInstance) {
		// TODO 自动生成方法存根

	}

	public List findByAddress(Object address) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByExample(UserDetail instance) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByGender(Object gender) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByHomepage(Object homepage) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByHowKnow(Object howKnow) {
		// TODO 自动生成方法存根
		return null;
	}

	public UserDetail findById(Integer id) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByInterest(Object interest) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByIsSubscribe(Object isSubscribe) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByMobilePhone(Object mobilePhone) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByOccupation(Object occupation) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByPhone(Object phone) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByQq(Object qq) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByRealName(Object realName) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByRemark(Object remark) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByZipCode(Object zipCode) {
		// TODO 自动生成方法存根
		return null;
	}

	public UserDetail merge(UserDetail detachedInstance) {
		// TODO 自动生成方法存根
		return null;
	}

	public void save(UserDetail transientInstance) {
		// TODO 自动生成方法存根

	}

	/**
	 * @return userDetailDAO
	 */
	public IUserDetailDAO getUserDetailDAO() {
		return userDetailDAO;
	}

	/**
	 * @param userDetailDAO 要设置的 userDetailDAO
	 */
	public void setUserDetailDAO(IUserDetailDAO userDetailDAO) {
		this.userDetailDAO = userDetailDAO;
	}

}
