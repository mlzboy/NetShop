package com.lexus.dao.impl;

import java.util.List;

import com.lexus.bean.Dictionary;
import com.lexus.dao.IDictionaryDAO;

public class DictionaryDAO extends BaseDictionaryDAO implements
		IDictionaryDAO {

	public List findByAll() {
		log.debug("finding all dictionary instance");
		List list=this.getHibernateTemplate().find("from Dictionary");
		return list;
	}

	public void saveOrUpdate(Dictionary transientInstance) {
        log.debug("saving or updating Dictionary instance");
        try {
            getHibernateTemplate().saveOrUpdate(transientInstance);
            log.debug("save or update successful");
        } catch (RuntimeException re) {
            log.error("save or update failed", re);
            throw re;
        }		
	}

}
