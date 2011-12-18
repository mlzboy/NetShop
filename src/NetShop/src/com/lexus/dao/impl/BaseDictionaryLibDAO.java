package com.lexus.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lexus.bean.DictionaryLib;
import com.lexus.dao.IBaseDictionaryLibDAO;

/**
 * Data access object (DAO) for domain model class DictionaryLib.
 * @see com.lexus.bean.DictionaryLib
 * @author MyEclipse - Hibernate Tools
 */
public abstract class BaseDictionaryLibDAO extends HibernateDaoSupport implements IBaseDictionaryLibDAO {

	protected static final Log log = LogFactory.getLog(DictionaryLibDAO.class);

	//property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String SEQUENCE = "sequence";
	public static final String DEPTH = "depth";
	public static final String VERSION = "version";
	public static final String STATUS = "status";

	protected void initDao() {
		//do nothing
	}
    
    public void save(DictionaryLib transientInstance) {
        log.debug("saving DictionaryLib instance");
        log.info("save");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(DictionaryLib persistentInstance) {
        log.debug("deleting DictionaryLib instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public DictionaryLib findById( java.lang.Integer id) {
        log.debug("getting DictionaryLib instance with id: " + id);
        try {
            DictionaryLib instance = (DictionaryLib) getHibernateTemplate()
                    .get("com.lexus.bean.DictionaryLib", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(DictionaryLib instance) {
        log.debug("finding DictionaryLib instance by example");
        if(log.isInfoEnabled()){
        log.info("执行findByExample方法");}
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            if(results.isEmpty())
            {
            	log.info("结果为空");
            }
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    	
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding DictionaryLib instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from DictionaryLib as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}
	
	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}
	
	public List findBySequence(Object sequence) {
		return findByProperty(SEQUENCE, sequence);
	}
	
	public List findByDepth(Object depth) {
		return findByProperty(DEPTH, depth);
	}
	
	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}
	
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}
	
    public DictionaryLib merge(DictionaryLib detachedInstance) {
        log.debug("merging DictionaryLib instance");
        try {
            DictionaryLib result = (DictionaryLib) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(DictionaryLib instance) {
        log.debug("attaching dirty DictionaryLib instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(DictionaryLib instance) {
        log.debug("attaching clean DictionaryLib instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IBaseDictionaryLibDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IBaseDictionaryLibDAO) ctx.getBean("BaseDictionaryLibDAO");
	}
}