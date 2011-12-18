package com.lexus.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lexus.bean.TableName;
import com.lexus.dao.IBaseTableNameDAO;

/**
 * Data access object (DAO) for domain model class TableName.
 * @see com.lexus.bean.TableName
 * @author MyEclipse - Hibernate Tools
 */
public abstract class BaseTableNameDAO extends HibernateDaoSupport implements IBaseTableNameDAO {

	protected static final Log log = LogFactory.getLog(BaseTableNameDAO.class);

	//property constants
	public static final String TABLE_NAME = "tableName";
	public static final String DESCRIPTION = "description";
	public static final String VERSION = "version";
	public static final String STATUS = "status";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TableName transientInstance) {
        log.debug("saving TableName instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TableName persistentInstance) {
        log.debug("deleting TableName instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TableName findById( java.lang.Integer id) {
        log.debug("getting TableName instance with id: " + id);
        try {
            TableName instance = (TableName) getHibernateTemplate()
                    .get("com.lexus.bean.TableName", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TableName instance) {
        log.debug("finding TableName instance by example");
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
      log.debug("finding TableName instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TableName as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTableName(Object tableName) {
		return findByProperty(TABLE_NAME, tableName);
	}
	
	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}
	
	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}
	
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}
	
    public TableName merge(TableName detachedInstance) {
        log.debug("merging TableName instance");
        try {
            TableName result = (TableName) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TableName instance) {
        log.debug("attaching dirty TableName instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TableName instance) {
        log.debug("attaching clean TableName instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IBaseTableNameDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IBaseTableNameDAO) ctx.getBean("BaseTableNameDAO");
	}
}