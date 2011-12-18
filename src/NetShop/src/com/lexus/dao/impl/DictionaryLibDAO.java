package com.lexus.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.lexus.bean.Dictionary;
import com.lexus.bean.DictionaryLib;
import com.lexus.dao.IDictionaryLibDAO;

public class DictionaryLibDAO extends BaseDictionaryLibDAO implements
		IDictionaryLibDAO {

	public List findByParentIdAndDictionaryId(int parentId, int dictionaryId) {
		log.debug("finding all dictionaryLib instance");
//		List list=this.getHibernateTemplate().find("from DictionaryLib");
		DictionaryLib parentDictionaryLib=new DictionaryLib();
		if(parentId!=0)
		{
//			if(this.getHibernateTemplate().get(DictionaryLibDAO.class, parentId)!=null)
//			{
//				if(log.isInfoEnabled())
//				{
//					log.info("设置parentId值");
//				}
//				parentDictionaryLib.setPkDictionaryLibId(parentId);
//			}
		}
		Dictionary dictionary=new Dictionary();
		dictionary.setPkDictionaryId(dictionaryId);
		
		DictionaryLib dictionaryLib=new DictionaryLib();
		dictionaryLib.setDictionary(dictionary);
		dictionaryLib.setDictionaryLib(parentDictionaryLib);
		
//		Example ex=Example.create(dictionaryLib).excludeNone().excludeProperty("pkDictionaryLibId");
		Example ex=Example.create(dictionaryLib);

//		return this.getSessionFactory().getCurrentSession().createCriteria(DictionaryLib.class).add(ex).list();
		String sql;
		if(parentId==0)
		{
			sql="select {d.*} from dictionary_lib d where d.fk_dictionary_lib_parent_id is null and d.fk_dictionary_id="+String.valueOf(dictionaryId);
		}
		else
		{
			sql="select {d.*} from dictionary_lib d where d.fk_dictionary_lib_parent_id="+String.valueOf(parentId)+" and d.fk_dictionary_id="+String.valueOf(dictionaryId);
		}
		return this.getSessionFactory().getCurrentSession()
//		.createSQLQuery("select {d.*} from DictionaryLib {d} where {fk_dictionary_lib_parent_id})
		.createSQLQuery(sql)
		.addEntity("d", DictionaryLib.class)
		.list();
//		return null;
	}

	public void saveOrUpdate(DictionaryLib transientInstance) {
        log.debug("saving or updating DictionaryLib instance");
        log.info("save or update");
        try {
            getHibernateTemplate().saveOrUpdate(transientInstance);
            log.debug("save or update successful");
        } catch (RuntimeException re) {
            log.error("save or update failed", re);
            throw re;
        }		
	}

	public int findByDictionaryIdAndParentId(final int dictionaryId,final int parentId) {
		return this.getHibernateTemplate().executeFind(
		new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException,SQLException 
			{
				String 	sql="select {d.*} from dictionary_lib d where d.fk_dictionary_lib_parent_id is null and d.fk_dictionary_id="+String.valueOf(dictionaryId);
				Query query=session.createSQLQuery(sql)
				.addEntity("d", DictionaryLib.class);
				List list=query.list();
				return list;
			}
		}		
		).size();
	}



	
}
