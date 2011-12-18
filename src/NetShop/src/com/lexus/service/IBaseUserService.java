package com.lexus.service;

import java.util.List;

import com.lexus.bean.User;

public interface IBaseUserService {

	public void save(User transientInstance);

	public void delete(User persistentInstance);

	public User findById(java.lang.Integer id);

	public List findByExample(User instance);

	public List findByProperty(String propertyName, Object value);

	public List findByUsername(Object username);

	public List findByPassword(Object password);

	public List findByEmail(Object email);

	public List findByNickName(Object nickName);

	public List findByQuestion(Object question);

	public List findByAnswer(Object answer);

	public List findByLastLoginIp(Object lastLoginIp);

	public List findByVersion(Object version);

	public List findByStatus(Object status);

	public User merge(User detachedInstance);

	public void attachDirty(User instance);

	public void attachClean(User instance);

}