package com.lexus.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lexus.bean.Product;
import com.lexus.dao.IBaseProductDAO;

/**
 * Data access object (DAO) for domain model class Product.
 * @see com.lexus.bean.Product
 * @author MyEclipse - Hibernate Tools
 */
public abstract class BaseProductDAO extends HibernateDaoSupport implements IBaseProductDAO {

	protected static final Log log = LogFactory.getLog(BaseProductDAO.class);

	//property constants
	public static final String PRODUCT_NAME = "productName";
	public static final String PRODUCT_DESCRIPTION = "productDescription";
	public static final String PRODUCT_CATEGORIES = "productCategories";
	public static final String PRODUCT_ATTACHMENTS = "productAttachments";
	public static final String VERSION = "version";
	public static final String STATUS = "status";

	protected void initDao() {
		//do nothing
	}
    
    public void save(Product transientInstance) {
        log.debug("saving Product instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Product persistentInstance) {
        log.debug("deleting Product instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Product findById( java.lang.Integer id) {
        log.debug("getting Product instance with id: " + id);
        try {
            Product instance = (Product) getHibernateTemplate()
                    .get("com.lexus.bean.Product", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Product instance) {
        log.debug("finding Product instance by example");
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
      log.debug("finding Product instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Product as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByProductName(Object productName) {
		return findByProperty(PRODUCT_NAME, productName);
	}
	
	public List findByProductDescription(Object productDescription) {
		return findByProperty(PRODUCT_DESCRIPTION, productDescription);
	}
	
	public List findByProductCategories(Object productCategories) {
		return findByProperty(PRODUCT_CATEGORIES, productCategories);
	}
	
	public List findByProductAttachments(Object productAttachments) {
		return findByProperty(PRODUCT_ATTACHMENTS, productAttachments);
	}
	
	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}
	
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}
	
    public Product merge(Product detachedInstance) {
        log.debug("merging Product instance");
        try {
            Product result = (Product) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Product instance) {
        log.debug("attaching dirty Product instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Product instance) {
        log.debug("attaching clean Product instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IBaseProductDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IBaseProductDAO) ctx.getBean("BaseProductDAO");
	}
}