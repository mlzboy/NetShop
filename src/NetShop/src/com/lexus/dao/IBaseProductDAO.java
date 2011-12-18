package com.lexus.dao;

import java.util.List;

import com.lexus.bean.Product;

public interface IBaseProductDAO {

	public void save(Product transientInstance);

	public void delete(Product persistentInstance);

	public Product findById(java.lang.Integer id);

	public List findByExample(Product instance);

	public List findByProperty(String propertyName, Object value);

	public List findByProductName(Object productName);

	public List findByProductDescription(Object productDescription);

	public List findByProductCategories(Object productCategories);

	public List findByProductAttachments(Object productAttachments);

	public List findByVersion(Object version);

	public List findByStatus(Object status);

	public Product merge(Product detachedInstance);

	public void attachDirty(Product instance);

	public void attachClean(Product instance);

}