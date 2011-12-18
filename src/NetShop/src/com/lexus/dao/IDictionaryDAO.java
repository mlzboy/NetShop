package com.lexus.dao;

import java.util.List;

import com.lexus.bean.Dictionary;

public interface IDictionaryDAO extends IBaseDictionaryDAO {
	public List findByAll();
	public void saveOrUpdate(Dictionary transientInstance);
}
