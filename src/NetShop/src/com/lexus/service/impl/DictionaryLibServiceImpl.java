package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.DictionaryLib;
import com.lexus.service.IDictionaryLibService;

public class DictionaryLibServiceImpl extends BaseDictionaryLibServiceImpl
		implements IDictionaryLibService {
	
	public List findByParentIdAndDictionaryId(int parentId, int dictionaryId) {
		return this.getDictionaryLibDAO().findByParentIdAndDictionaryId(parentId, dictionaryId);
	}

	public void saveOrUpdate(DictionaryLib transientInstance) {
		this.getDictionaryLibDAO().saveOrUpdate(transientInstance);
	}

	public int findByDictionaryIdAndParentId(final int dictionaryId, final int parentId) {
		return this.getDictionaryLibDAO().findByDictionaryIdAndParentId(dictionaryId, parentId);
	}

}
