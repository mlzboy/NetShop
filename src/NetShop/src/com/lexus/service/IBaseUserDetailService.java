package com.lexus.service;

import java.util.List;

import com.lexus.bean.UserDetail;

public interface IBaseUserDetailService {

	public void save(UserDetail transientInstance);

	public void delete(UserDetail persistentInstance);

	public UserDetail findById(java.lang.Integer id);

	public List findByExample(UserDetail instance);

	public List findByProperty(String propertyName, Object value);

	public List findByRealName(Object realName);

	public List findByGender(Object gender);

	public List findByQq(Object qq);

	public List findByHomepage(Object homepage);

	public List findByMobilePhone(Object mobilePhone);

	public List findByPhone(Object phone);

	public List findByAddress(Object address);

	public List findByZipCode(Object zipCode);

	public List findByInterest(Object interest);

	public List findByOccupation(Object occupation);

	public List findByHowKnow(Object howKnow);

	public List findByIsSubscribe(Object isSubscribe);

	public List findByRemark(Object remark);

	public UserDetail merge(UserDetail detachedInstance);

	public void attachDirty(UserDetail instance);

	public void attachClean(UserDetail instance);

}