package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.Dictionary;
import com.lexus.dao.IDictionaryDAO;
import com.lexus.service.IBaseDictionaryService;

public abstract class BaseDictionaryServiceImpl implements IBaseDictionaryService {

	private IDictionaryDAO dictionaryDAO;	/**
	 * 
	 */
	public BaseDictionaryServiceImpl() {
		// TODO 自动生成构造函数存根
	}

	public void attachClean(Dictionary instance) {
		// TODO 自动生成方法存根

	}

	public void attachDirty(Dictionary instance) {
		// TODO 自动生成方法存根

	}

	public void delete(Dictionary persistentInstance) {
		this.dictionaryDAO.delete(persistentInstance);
	}

	public List findByDictionaryName(Object dictionaryName) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByExample(Dictionary instance) {
		// TODO 自动生成方法存根
		return null;
	}

	public Dictionary findById(Integer id) {
		return this.dictionaryDAO.findById(id);
	}

	public List findByIsMultinest(Object isMultinest) {
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

	public List findByVersion(Object version) {
		// TODO 自动生成方法存根
		return null;
	}

	public Dictionary merge(Dictionary detachedInstance) {
		// TODO 自动生成方法存根
		return null;
	}

	public void save(Dictionary transientInstance) {
		this.dictionaryDAO.save(transientInstance);
	}

	/**
	 * @return dictionaryDAO
	 */
	public IDictionaryDAO getDictionaryDAO() {
		return dictionaryDAO;
	}

	/**
	 * @param dictionaryDAO 要设置的 dictionaryDAO
	 */
	public void setDictionaryDAO(IDictionaryDAO dictionaryDAO) {
		this.dictionaryDAO = dictionaryDAO;
	}

}
