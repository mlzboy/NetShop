package com.lexus.service;

import java.util.List;

import com.lexus.bean.Log;

public interface IBaseLogService {

	public void save(Log transientInstance);

	public void delete(Log persistentInstance);

	public Log findById(java.lang.Integer id);

	public List findByExample(Log instance);

	public List findByProperty(String propertyName, Object value);

	public List findByOperateDescription(Object operateDescription);

	public List findByOperaterIp(Object operaterIp);

	public List findByStatus(Object status);

	public Log merge(Log detachedInstance);

	public void attachDirty(Log instance);

	public void attachClean(Log instance);

}