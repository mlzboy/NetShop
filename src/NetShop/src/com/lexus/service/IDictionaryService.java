package com.lexus.service;

import java.util.List;

import com.lexus.bean.Dictionary;

public interface IDictionaryService extends IBaseDictionaryService {
	public List findByAll();
	public void saveOrUpdate(Dictionary transientInstance);
}
