package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.FieldName;
import com.lexus.dao.IFieldNameDAO;
import com.lexus.service.IBaseFieldNameService;

public abstract class BaseFieldNameServiceImpl implements IBaseFieldNameService {
	private IFieldNameDAO fieldNameDAO;
	public void attachClean(FieldName instance) {
		// TODO 自动生成方法存根

	}

	public void attachDirty(FieldName instance) {
		// TODO 自动生成方法存根

	}

	public void delete(FieldName persistentInstance) {
		// TODO 自动生成方法存根

	}

	public List findByExample(FieldName instance) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByFieldDefault(Object fieldDefault) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByFieldDescription(Object fieldDescription) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByFieldName(Object fieldName) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByFieldType(Object fieldType) {
		// TODO 自动生成方法存根
		return null;
	}

	public FieldName findById(Integer id) {
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

	public FieldName merge(FieldName detachedInstance) {
		// TODO 自动生成方法存根
		return null;
	}

	public void save(FieldName transientInstance) {
		// TODO 自动生成方法存根

	}

	/**
	 * @return fieldNameDAO
	 */
	public IFieldNameDAO getFieldNameDAO() {
		return fieldNameDAO;
	}

	/**
	 * @param fieldNameDAO 要设置的 fieldNameDAO
	 */
	public void setFieldNameDAO(IFieldNameDAO fieldNameDAO) {
		this.fieldNameDAO = fieldNameDAO;
	}

}
