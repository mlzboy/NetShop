package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.ProductDetail;
import com.lexus.dao.IProductDetailDAO;
import com.lexus.service.IBaseProductDetailService;

public abstract class BaseProductDetailServiceImpl implements IBaseProductDetailService {
	private IProductDetailDAO productDetailDAO;
	public void attachClean(ProductDetail instance) {
		// TODO 自动生成方法存根

	}

	public void attachDirty(ProductDetail instance) {
		// TODO 自动生成方法存根

	}

	public void delete(ProductDetail persistentInstance) {
		// TODO 自动生成方法存根

	}

	public List findByExample(ProductDetail instance) {
		// TODO 自动生成方法存根
		return null;
	}

	public ProductDetail findById(Integer id) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByProductHabitat(Object productHabitat) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByProductPrice(Object productPrice) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO 自动生成方法存根
		return null;
	}

	public ProductDetail merge(ProductDetail detachedInstance) {
		// TODO 自动生成方法存根
		return null;
	}

	public void save(ProductDetail transientInstance) {
		// TODO 自动生成方法存根

	}

	/**
	 * @return productDetailDAO
	 */
	public IProductDetailDAO getProductDetailDAO() {
		return productDetailDAO;
	}

	/**
	 * @param productDetailDAO 要设置的 productDetailDAO
	 */
	public void setProductDetailDAO(IProductDetailDAO productDetailDAO) {
		this.productDetailDAO = productDetailDAO;
	}

}
