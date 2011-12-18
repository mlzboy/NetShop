package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.TableFieldDictMapping;
import com.lexus.bean.TableFieldDictMappingId;
import com.lexus.dao.ITableFieldDictMappingDAO;
import com.lexus.service.IBaseTableFieldDictMappingService;

public abstract class BaseTableFieldDictMappingServiceImpl implements
		IBaseTableFieldDictMappingService {
	private ITableFieldDictMappingDAO tableFieldDictMappingDAO;
	public void attachClean(TableFieldDictMapping instance) {
		// TODO 自动生成方法存根

	}

	public void attachDirty(TableFieldDictMapping instance) {
		// TODO 自动生成方法存根

	}

	public void delete(TableFieldDictMapping persistentInstance) {
		// TODO 自动生成方法存根

	}

	public List findByExample(TableFieldDictMapping instance) {
		return this.tableFieldDictMappingDAO.findByExample(instance);
	}

	public List findByFieldName_1(Object fieldName_1) {
		// TODO 自动生成方法存根
		return null;
	}

	public TableFieldDictMapping findById(TableFieldDictMappingId id) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByTableName_1(Object tableName_1) {
		// TODO 自动生成方法存根
		return null;
	}

	public TableFieldDictMapping merge(TableFieldDictMapping detachedInstance) {
		// TODO 自动生成方法存根
		return null;
	}

	public void save(TableFieldDictMapping transientInstance) {
		// TODO 自动生成方法存根

	}

	/**
	 * @return tableFieldDictMappingDAO
	 */
	public ITableFieldDictMappingDAO getTableFieldDictMappingDAO() {
		return tableFieldDictMappingDAO;
	}

	/**
	 * @param tableFieldDictMappingDAO 要设置的 tableFieldDictMappingDAO
	 */
	public void setTableFieldDictMappingDAO(
			ITableFieldDictMappingDAO tableFieldDictMappingDAO) {
		this.tableFieldDictMappingDAO = tableFieldDictMappingDAO;
	}

}
