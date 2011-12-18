package com.lexus.dao.impl;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lexus.bean.Log;
import com.lexus.dao.IBaseLogDAO;

/**
 * Data access object (DAO) for domain model class Log.
 * @see com.lexus.bean.Log
 * @author MyEclipse - Hibernate Tools
 */
public abstract class BaseLogDAO extends HibernateDaoSupport implements IBaseLogDAO {

    protected static final org.apache.commons.logging.Log log = LogFactory.getLog(BaseLogDAO.class);

	//property constants
	public static final String OPERATE_DESCRIPTION = "operateDescription";
	public static final String OPERATER_IP = "operaterIp";
	public static final String STATUS = "status";

	protected void initDao() {
		//do nothing
	}
    
    public void save(Log transientInstance) {
        log.debug("saving Log instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Log persistentInstance) {
        log.debug("deleting Log instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Log findById( java.lang.Integer id) {
        log.debug("getting Log instance with id: " + id);
        try {
            Log instance = (Log) getHibernateTemplate()
                    .get("com.lexus.bean.Log", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Log instance) {
        log.debug("finding Log instance by example");
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
      log.debug("finding Log instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Log as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByOperateDescription(Object operateDescription) {
		return findByProperty(OPERATE_DESCRIPTION, operateDescription);
	}
	
	public List findByOperaterIp(Object operaterIp) {
		return findByProperty(OPERATER_IP, operaterIp);
	}
	
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}
	
    public Log merge(Log detachedInstance) {
        log.debug("merging Log instance");
        try {
            Log result = (Log) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Log instance) {
        log.debug("attaching dirty Log instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Log instance) {
        log.debug("attaching clean Log instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IBaseLogDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IBaseLogDAO) ctx.getBean("BaseLogDAO");
	}
}