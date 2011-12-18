package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.TableName;
import com.lexus.dao.ITableNameDAO;
import com.lexus.service.IBaseTableNameService;

public abstract class BaseTableNameServiceImpl implements IBaseTableNameService {
	private ITableNameDAO tableNameDAO;
	/**
	 * 
	 */
	public BaseTableNameServiceImpl() {
		// TODO 自动生成构造函数存根
	}


	public void attachClean(TableName instance) {
		// TODO 自动生成方法存根

	}

	public void attachDirty(TableName instance) {
		// TODO 自动生成方法存根

	}

	public void delete(TableName persistentInstance) {
		// TODO 自动生成方法存根

	}

	public List findByDescription(Object description) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByExample(TableName instance) {
		// TODO 自动生成方法存根
		return null;
	}

	public TableName findById(Integer id) {
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

	public List findByTableName(Object tableName) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByVersion(Object version) {
		// TODO 自动生成方法存根
		return null;
	}

	public TableName merge(TableName detachedInstance) {
		// TODO 自动生成方法存根
		return null;
	}

	public void save(TableName transientInstance) {
		// TODO 自动生成方法存根

	}

	/**
	 * @return tableNameDAO
	 */
	public ITableNameDAO getTableNameDAO() {
		return tableNameDAO;
	}

	/**
	 * @param tableNameDAO 要设置的 tableNameDAO
	 */
	public void setTableNameDAO(ITableNameDAO tableNameDAO) {
		this.tableNameDAO = tableNameDAO;
	}

}
