package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.Product;
import com.lexus.dao.IDictionaryLibDAO;
import com.lexus.dao.IProductDAO;
import com.lexus.service.IBaseProductService;

public abstract class BaseProductServiceImpl implements IBaseProductService {
	private IProductDAO productDAO;
	private IDictionaryLibDAO dictionaryLibDAO;


	public void attachClean(Product instance) {
		// TODO 自动生成方法存根

	}

	public void attachDirty(Product instance) {
		// TODO 自动生成方法存根

	}

	public void delete(Product persistentInstance) {
		this.productDAO.delete(persistentInstance);
	}

	public List findByExample(Product instance) {
		// TODO 自动生成方法存根
		return null;
	}

	public Product findById(Integer id) {
		return this.productDAO.findById(id);
	}

	public List findByProductAttachments(Object productAttachments) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByProductCategories(Object productCategories) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByProductDescription(Object productDescription) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByProductName(Object productName) {
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

	public Product merge(Product detachedInstance) {
		// TODO 自动生成方法存根
		return null;
	}

	public void save(Product transientInstance) {
		this.productDAO.save(transientInstance);
	}

	/**
	 * @return productDAO
	 */
	public IProductDAO getProductDAO() {
		return productDAO;
	}

	/**
	 * @param productDAO 要设置的 productDAO
	 */
	public void setProductDAO(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	/**
	 * @param dictionaryLibDAO 要设置的 dictionaryLibDAO
	 */
	public void setDictionaryLibDAO(IDictionaryLibDAO dictionaryLibDAO) {
		this.dictionaryLibDAO = dictionaryLibDAO;
	}

	/**
	 * @return dictionaryLibDAO
	 */
	public IDictionaryLibDAO getDictionaryLibDAO() {
		return dictionaryLibDAO;
	}

}
