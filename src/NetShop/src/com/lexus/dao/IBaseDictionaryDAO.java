package com.lexus.dao;

import java.util.List;

import com.lexus.bean.Dictionary;

public interface IBaseDictionaryDAO {

	public static final String VERSION = "version";

	public void save(Dictionary transientInstance);

	public void delete(Dictionary persistentInstance);

	public Dictionary findById(java.lang.Integer id);

	public List findByExample(Dictionary instance);

	public List findByProperty(String propertyName, Object value);

	public List findByDictionaryName(Object dictionaryName);

	public List findByIsMultinest(Object isMultinest);

	public List findByVersion(Object version);

	public List findByStatus(Object status);

	public Dictionary merge(Dictionary detachedInstance);

	public void attachDirty(Dictionary instance);

	public void attachClean(Dictionary instance);

}