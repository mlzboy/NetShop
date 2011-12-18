package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.Log;
import com.lexus.dao.ILogDAO;
import com.lexus.service.IBaseLogService;

public abstract class BaseLogServiceImpl implements IBaseLogService {
	private ILogDAO logDAO;
	public BaseLogServiceImpl() {
		// TODO 自动生成构造函数存根
	}

	public void attachClean(Log instance) {
		// TODO 自动生成方法存根

	}

	public void attachDirty(Log instance) {
		// TODO 自动生成方法存根

	}

	public void delete(Log persistentInstance) {
		// TODO 自动生成方法存根

	}

	public List findByExample(Log instance) {
		// TODO 自动生成方法存根
		return null;
	}

	public Log findById(Integer id) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByOperateDescription(Object operateDescription) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByOperaterIp(Object operaterIp) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByStatus(Object status) {
		// TODO 自动生成方法存根
		return null;
	}

	public Log merge(Log detachedInstance) {
		// TODO 自动生成方法存根
		return null;
	}

	public void save(Log transientInstance) {
		// TODO 自动生成方法存根

	}

	/**
	 * @return logDAO
	 */
	public ILogDAO getLogDAO() {
		return logDAO;
	}

	/**
	 * @param logDAO 要设置的 logDAO
	 */
	public void setLogDAO(ILogDAO logDAO) {
		this.logDAO = logDAO;
	}

}
