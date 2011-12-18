package com.lexus.service;

import java.util.List;

import com.lexus.bean.ProductDetail;

public interface IBaseProductDetailService {

	public void save(ProductDetail transientInstance);

	public void delete(ProductDetail persistentInstance);

	public ProductDetail findById(java.lang.Integer id);

	public List findByExample(ProductDetail instance);

	public List findByProperty(String propertyName, Object value);

	public List findByProductPrice(Object productPrice);

	public List findByProductHabitat(Object productHabitat);

	public ProductDetail merge(ProductDetail detachedInstance);

	public void attachDirty(ProductDetail instance);

	public void attachClean(ProductDetail instance);

}