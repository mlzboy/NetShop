package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.DictionaryLib;
import com.lexus.dao.IDictionaryLibDAO;
import com.lexus.service.IBaseDictionaryLibService;

public abstract class BaseDictionaryLibServiceImpl implements IBaseDictionaryLibService {
	private IDictionaryLibDAO dictionaryLibDAO;
	public void attachClean(DictionaryLib instance) {
		// TODO 自动生成方法存根

	}

	public void attachDirty(DictionaryLib instance) {
		// TODO 自动生成方法存根

	}

	public void delete(DictionaryLib persistentInstance) {
		this.dictionaryLibDAO.delete(persistentInstance);
	}

	public List findByDepth(Object depth) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByDescription(Object description) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByExample(DictionaryLib instance) {
		return this.dictionaryLibDAO.findByExample(instance);
	}

	public DictionaryLib findById(Integer id) {
		return this.dictionaryLibDAO.findById(id);
	}

	public List findByName(Object name) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		return this.dictionaryLibDAO.findByProperty(propertyName, value);
	}

	public List findBySequence(Object sequence) {
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

	public DictionaryLib merge(DictionaryLib detachedInstance) {
		// TODO 自动生成方法存根
		return null;
	}

	public void save(DictionaryLib transientInstance) {
		this.dictionaryLibDAO.save(transientInstance);
	}

	/**
	 * @return dictionaryLibDAO
	 */
	public IDictionaryLibDAO getDictionaryLibDAO() {
		return dictionaryLibDAO;
	}

	/**
	 * @param dictionaryLibDAO 要设置的 dictionaryLibDAO
	 */
	public void setDictionaryLibDAO(IDictionaryLibDAO dictionaryLibDAO) {
		this.dictionaryLibDAO = dictionaryLibDAO;
	}

	/**
	 * 
	 */
	public BaseDictionaryLibServiceImpl() {
		// TODO 自动生成构造函数存根
	}

}
