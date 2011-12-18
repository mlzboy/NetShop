package com.lexus.dao;

import java.util.List;

import com.lexus.bean.DictionaryLib;

public interface IDictionaryLibDAO extends IBaseDictionaryLibDAO {
	public List findByParentIdAndDictionaryId(int parentId,int dictionaryId);
	public void saveOrUpdate(DictionaryLib transientInstance);
	public int findByDictionaryIdAndParentId(final int dictionaryId,final int parentId);
}
