package com.lexus.service;

import java.util.List;

import com.lexus.bean.DictionaryLib;

public interface IBaseDictionaryLibService {

	public void save(DictionaryLib transientInstance);

	public void delete(DictionaryLib persistentInstance);

	public DictionaryLib findById(java.lang.Integer id);

	public List findByExample(DictionaryLib instance);

	public List findByProperty(String propertyName, Object value);

	public List findByName(Object name);

	public List findByDescription(Object description);

	public List findBySequence(Object sequence);

	public List findByDepth(Object depth);

	public List findByVersion(Object version);

	public List findByStatus(Object status);

	public DictionaryLib merge(DictionaryLib detachedInstance);

	public void attachDirty(DictionaryLib instance);

	public void attachClean(DictionaryLib instance);

}