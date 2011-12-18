package com.lexus.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lexus.bean.TableFieldDictMapping;
import com.lexus.dao.IBaseTableFieldDictMappingDAO;

/**
 * Data access object (DAO) for domain model class TableFieldDictMapping.
 * @see com.lexus.bean.TableFieldDictMapping
 * @author MyEclipse - Hibernate Tools
 */
public abstract class BaseTableFieldDictMappingDAO extends HibernateDaoSupport implements IBaseTableFieldDictMappingDAO {

	protected static final Log log = LogFactory.getLog(BaseTableFieldDictMappingDAO.class);

	//property constants
	public static final String TABLE_NAME_1 = "tableName_1";
	public static final String FIELD_NAME_1 = "fieldName_1";

	protected void initDao() {
		//do nothing
	}
    
    public void save(TableFieldDictMapping transientInstance) {
        log.debug("saving TableFieldDictMapping instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TableFieldDictMapping persistentInstance) {
        log.debug("deleting TableFieldDictMapping instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TableFieldDictMapping findById( com.lexus.bean.TableFieldDictMappingId id) {
        log.debug("getting TableFieldDictMapping instance with id: " + id);
        try {
            TableFieldDictMapping instance = (TableFieldDictMapping) getHibernateTemplate()
                    .get("com.lexus.bean.TableFieldDictMapping", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TableFieldDictMapping instance) {
        log.debug("finding TableFieldDictMapping instance by example");
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
      log.debug("finding TableFieldDictMapping instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TableFieldDictMapping as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTableName_1(Object tableName_1) {
		return findByProperty(TABLE_NAME_1, tableName_1);
	}
	
	public List findByFieldName_1(Object fieldName_1) {
		return findByProperty(FIELD_NAME_1, fieldName_1);
	}
	
    public TableFieldDictMapping merge(TableFieldDictMapping detachedInstance) {
        log.debug("merging TableFieldDictMapping instance");
        try {
            TableFieldDictMapping result = (TableFieldDictMapping) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TableFieldDictMapping instance) {
        log.debug("attaching dirty TableFieldDictMapping instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TableFieldDictMapping instance) {
        log.debug("attaching clean TableFieldDictMapping instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IBaseTableFieldDictMappingDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IBaseTableFieldDictMappingDAO) ctx.getBean("BaseTableFieldDictMappingDAO");
	}
}