package com.lexus.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lexus.bean.Dictionary;
import com.lexus.dao.IBaseDictionaryDAO;

/**
 * Data access object (DAO) for domain model class Dictionary.
 * @see com.lexus.bean.Dictionary
 * @author MyEclipse - Hibernate Tools
 */
public abstract class BaseDictionaryDAO extends HibernateDaoSupport implements IBaseDictionaryDAO {

    protected static final Log log = LogFactory.getLog(BaseDictionaryDAO.class);

	//property constants
	public static final String DICTIONARY_NAME = "dictionaryName";
	public static final String IS_MULTINEST = "isMultinest";
	public static final String STATUS = "status";

	protected void initDao() {
		//do nothing
	}
    
    public void save(Dictionary transientInstance) {
        log.debug("saving Dictionary instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Dictionary persistentInstance) {
        log.debug("deleting Dictionary instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Dictionary findById( java.lang.Integer id) {
        log.debug("getting Dictionary instance with id: " + id);
        try {
            Dictionary instance = (Dictionary) getHibernateTemplate()
                    .get("com.lexus.bean.Dictionary", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Dictionary instance) {
        log.debug("finding Dictionary instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Dictionary instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Dictionary as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDictionaryName(Object dictionaryName) {
		return findByProperty(DICTIONARY_NAME, dictionaryName);
	}
	
	public List findByIsMultinest(Object isMultinest) {
		return findByProperty(IS_MULTINEST, isMultinest);
	}
	
	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}
	
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}
	
    public Dictionary merge(Dictionary detachedInstance) {
        log.debug("merging Dictionary instance");
        try {
            Dictionary result = (Dictionary) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Dictionary instance) {
        log.debug("attaching dirty Dictionary instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Dictionary instance) {
        log.debug("attaching clean Dictionary instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IBaseDictionaryDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IBaseDictionaryDAO) ctx.getBean("BaseDictionaryDAO");
	}
}