package com.lexus.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lexus.bean.ProductDetail;
import com.lexus.dao.IBaseProductDetailDAO;

/**
 * Data access object (DAO) for domain model class ProductDetail.
 * @see com.lexus.bean.ProductDetail
 * @author MyEclipse - Hibernate Tools
 */
public abstract class BaseProductDetailDAO extends HibernateDaoSupport implements IBaseProductDetailDAO {

	protected static final Log log = LogFactory.getLog(BaseProductDetailDAO.class);

	//property constants
	public static final String PRODUCT_PRICE = "productPrice";
	public static final String PRODUCT_HABITAT = "productHabitat";

	protected void initDao() {
		//do nothing
	}
    
    public void save(ProductDetail transientInstance) {
        log.debug("saving ProductDetail instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ProductDetail persistentInstance) {
        log.debug("deleting ProductDetail instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ProductDetail findById( java.lang.Integer id) {
        log.debug("getting ProductDetail instance with id: " + id);
        try {
            ProductDetail instance = (ProductDetail) getHibernateTemplate()
                    .get("com.lexus.bean.ProductDetail", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ProductDetail instance) {
        log.debug("finding ProductDetail instance by example");
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
      log.debug("finding ProductDetail instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ProductDetail as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByProductPrice(Object productPrice) {
		return findByProperty(PRODUCT_PRICE, productPrice);
	}
	
	public List findByProductHabitat(Object productHabitat) {
		return findByProperty(PRODUCT_HABITAT, productHabitat);
	}
	
    public ProductDetail merge(ProductDetail detachedInstance) {
        log.debug("merging ProductDetail instance");
        try {
            ProductDetail result = (ProductDetail) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ProductDetail instance) {
        log.debug("attaching dirty ProductDetail instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ProductDetail instance) {
        log.debug("attaching clean ProductDetail instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IBaseProductDetailDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IBaseProductDetailDAO) ctx.getBean("BaseProductDetailDAO");
	}
}