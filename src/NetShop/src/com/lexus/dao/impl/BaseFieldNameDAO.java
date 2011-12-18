package com.lexus.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lexus.bean.FieldName;
import com.lexus.dao.IBaseFieldNameDAO;

/**
 * Data access object (DAO) for domain model class FieldName.
 * @see com.lexus.bean.FieldName
 * @author MyEclipse - Hibernate Tools
 */
public abstract class BaseFieldNameDAO extends HibernateDaoSupport implements IBaseFieldNameDAO {

	protected static final Log log = LogFactory.getLog(BaseFieldNameDAO.class);

	//property constants
	public static final String FIELD_NAME = "fieldName";
	public static final String FIELD_TYPE = "fieldType";
	public static final String FIELD_DEFAULT = "fieldDefault";
	public static final String FIELD_DESCRIPTION = "fieldDescription";
	public static final String VERSION = "version";
	public static final String STATUS = "status";

	protected void initDao() {
		//do nothing
	}
    
    public void save(FieldName transientInstance) {
        log.debug("saving FieldName instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(FieldName persistentInstance) {
        log.debug("deleting FieldName instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public FieldName findById( java.lang.Integer id) {
        log.debug("getting FieldName instance with id: " + id);
        try {
            FieldName instance = (FieldName) getHibernateTemplate()
                    .get("com.lexus.bean.FieldName", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(FieldName instance) {
        log.debug("finding FieldName instance by example");
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
      log.debug("finding FieldName instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from FieldName as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByFieldName(Object fieldName) {
		return findByProperty(FIELD_NAME, fieldName);
	}
	
	public List findByFieldType(Object fieldType) {
		return findByProperty(FIELD_TYPE, fieldType);
	}
	
	public List findByFieldDefault(Object fieldDefault) {
		return findByProperty(FIELD_DEFAULT, fieldDefault);
	}
	
	public List findByFieldDescription(Object fieldDescription) {
		return findByProperty(FIELD_DESCRIPTION, fieldDescription);
	}
	
	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}
	
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}
	
    public FieldName merge(FieldName detachedInstance) {
        log.debug("merging FieldName instance");
        try {
            FieldName result = (FieldName) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(FieldName instance) {
        log.debug("attaching dirty FieldName instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(FieldName instance) {
        log.debug("attaching clean FieldName instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IBaseFieldNameDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IBaseFieldNameDAO) ctx.getBean("BaseFieldNameDAO");
	}
}