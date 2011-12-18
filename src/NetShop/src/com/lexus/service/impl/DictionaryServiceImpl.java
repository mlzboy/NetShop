package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.Dictionary;
import com.lexus.service.IDictionaryService;

public class DictionaryServiceImpl extends BaseDictionaryServiceImpl implements
		IDictionaryService {

	public List findByAll() {
		return this.getDictionaryDAO().findByAll();
	}

	public void saveOrUpdate(Dictionary transientInstance) {
		this.getDictionaryDAO().saveOrUpdate(transientInstance);
		
	}

}
