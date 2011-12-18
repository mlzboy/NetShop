package com.lexus.service;

import java.util.List;

import com.lexus.bean.FieldName;

public interface IBaseFieldNameService {

	public void save(FieldName transientInstance);

	public void delete(FieldName persistentInstance);

	public FieldName findById(java.lang.Integer id);

	public List findByExample(FieldName instance);

	public List findByProperty(String propertyName, Object value);

	public List findByFieldName(Object fieldName);

	public List findByFieldType(Object fieldType);

	public List findByFieldDefault(Object fieldDefault);

	public List findByFieldDescription(Object fieldDescription);

	public List findByVersion(Object version);

	public List findByStatus(Object status);

	public FieldName merge(FieldName detachedInstance);

	public void attachDirty(FieldName instance);

	public void attachClean(FieldName instance);

}