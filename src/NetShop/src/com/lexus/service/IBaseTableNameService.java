package com.lexus.service;

import java.util.List;

import com.lexus.bean.TableName;

public interface IBaseTableNameService {

	public void save(TableName transientInstance);

	public void delete(TableName persistentInstance);

	public TableName findById(java.lang.Integer id);

	public List findByExample(TableName instance);

	public List findByProperty(String propertyName, Object value);

	public List findByTableName(Object tableName);

	public List findByDescription(Object description);

	public List findByVersion(Object version);

	public List findByStatus(Object status);

	public TableName merge(TableName detachedInstance);

	public void attachDirty(TableName instance);

	public void attachClean(TableName instance);

}