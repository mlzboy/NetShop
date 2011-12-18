package com.lexus.dao;

import java.util.List;

import com.lexus.bean.TableFieldDictMapping;

public interface IBaseTableFieldDictMappingDAO {

	public void save(TableFieldDictMapping transientInstance);

	public void delete(TableFieldDictMapping persistentInstance);

	public TableFieldDictMapping findById(
			com.lexus.bean.TableFieldDictMappingId id);

	public List findByExample(TableFieldDictMapping instance);

	public List findByProperty(String propertyName, Object value);

	public List findByTableName_1(Object tableName_1);

	public List findByFieldName_1(Object fieldName_1);

	public TableFieldDictMapping merge(TableFieldDictMapping detachedInstance);

	public void attachDirty(TableFieldDictMapping instance);

	public void attachClean(TableFieldDictMapping instance);

}