package com.lexus.dao;

import java.util.List;

import com.lexus.bean.DictionaryLib;
import com.lexus.bean.Product;
import com.lexus.util.Page;

public interface IProductDAO extends IBaseProductDAO {
	public List findByPagination(Page page);
	public int getCount();
	public void saveOrUpdate(Product transientInstance);
	public int getSearchResultCount(String fieldName,String keyword);
	public List doSearch(Page page,String fieldName,String keyword);
	public void batchDelete(DictionaryLib[] arrDictionaryLibs);
	public List findAll();
}
