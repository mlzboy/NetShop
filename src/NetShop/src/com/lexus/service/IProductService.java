package com.lexus.service;

import java.util.List;

import com.lexus.bean.DictionaryLib;
import com.lexus.bean.Product;
import com.lexus.util.Page;
import com.lexus.util.PageResult;

public interface IProductService extends IBaseProductService {
	public PageResult findByPagination(Page page);
	public PageResult findByPagination(Page page,int categoryId);
	public void saveOrUpdate(Product transientInstance);
	public PageResult doSearch(Page page,String fieldName,String keyword);
	public void batchDelete(DictionaryLib[] arrDictionaryLibs);
	public List findAll();
}
