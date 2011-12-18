package com.lexus.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lexus.bean.UserDetail;
import com.lexus.dao.IBaseUserDetailDAO;

/**
 * Data access object (DAO) for domain model class UserDetail.
 * @see com.lexus.bean.UserDetail
 * @author MyEclipse - Hibernate Tools
 */
public abstract class BaseUserDetailDAO extends HibernateDaoSupport implements IBaseUserDetailDAO {

    protected static final Log log = LogFactory.getLog(BaseUserDetailDAO.class);

	//property constants
	public static final String REAL_NAME = "realName";
	public static final String GENDER = "gender";
	public static final String QQ = "qq";
	public static final String HOMEPAGE = "homepage";
	public static final String MOBILE_PHONE = "mobilePhone";
	public static final String PHONE = "phone";
	public static final String ADDRESS = "address";
	public static final String ZIP_CODE = "zipCode";
	public static final String INTEREST = "interest";
	public static final String OCCUPATION = "occupation";
	public static final String HOW_KNOW = "howKnow";
	public static final String IS_SUBSCRIBE = "isSubscribe";
	public static final String REMARK = "remark";

	protected void initDao() {
		//do nothing
	}
    
    public void save(UserDetail transientInstance) {
        log.debug("saving UserDetail instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserDetail persistentInstance) {
        log.debug("deleting UserDetail instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserDetail findById( java.lang.Integer id) {
        log.debug("getting UserDetail instance with id: " + id);
        try {
            UserDetail instance = (UserDetail) getHibernateTemplate()
                    .get("com.lexus.bean.UserDetail", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserDetail instance) {
        log.debug("finding UserDetail instance by example");
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
      log.debug("finding UserDetail instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserDetail as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByRealName(Object realName) {
		return findByProperty(REAL_NAME, realName);
	}
	
	public List findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}
	
	public List findByQq(Object qq) {
		return findByProperty(QQ, qq);
	}
	
	public List findByHomepage(Object homepage) {
		return findByProperty(HOMEPAGE, homepage);
	}
	
	public List findByMobilePhone(Object mobilePhone) {
		return findByProperty(MOBILE_PHONE, mobilePhone);
	}
	
	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}
	
	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}
	
	public List findByZipCode(Object zipCode) {
		return findByProperty(ZIP_CODE, zipCode);
	}
	
	public List findByInterest(Object interest) {
		return findByProperty(INTEREST, interest);
	}
	
	public List findByOccupation(Object occupation) {
		return findByProperty(OCCUPATION, occupation);
	}
	
	public List findByHowKnow(Object howKnow) {
		return findByProperty(HOW_KNOW, howKnow);
	}
	
	public List findByIsSubscribe(Object isSubscribe) {
		return findByProperty(IS_SUBSCRIBE, isSubscribe);
	}
	
	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}
	
    public UserDetail merge(UserDetail detachedInstance) {
        log.debug("merging UserDetail instance");
        try {
            UserDetail result = (UserDetail) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserDetail instance) {
        log.debug("attaching dirty UserDetail instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserDetail instance) {
        log.debug("attaching clean UserDetail instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IBaseUserDetailDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IBaseUserDetailDAO) ctx.getBean("BaseUserDetailDAO");
	}
}