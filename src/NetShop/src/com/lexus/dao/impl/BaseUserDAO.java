package com.lexus.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lexus.bean.User;
import com.lexus.dao.IBaseUserDAO;

/**
 * Data access object (DAO) for domain model class User.
 * @see com.lexus.bean.User
 * @author MyEclipse - Hibernate Tools
 */
public abstract class BaseUserDAO extends HibernateDaoSupport implements IBaseUserDAO {

    protected static final Log log = LogFactory.getLog(BaseUserDAO.class);

	//property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	public static final String NICK_NAME = "nickName";
	public static final String QUESTION = "question";
	public static final String ANSWER = "answer";
	public static final String LAST_LOGIN_IP = "lastLoginIp";
	public static final String VERSION = "version";
	public static final String STATUS = "status";

	protected void initDao() {
		//do nothing
	}
    
    public void save(User transientInstance) {
        log.debug("saving User instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(User persistentInstance) {
        log.debug("deleting User instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public User findById( java.lang.Integer id) {
        log.debug("getting User instance with id: " + id);
        try {
            User instance = (User) getHibernateTemplate()
                    .get("com.lexus.bean.User", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(User instance) {
        log.debug("finding User instance by example");
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
      log.debug("finding User instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from User as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}
	
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}
	
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}
	
	public List findByNickName(Object nickName) {
		return findByProperty(NICK_NAME, nickName);
	}
	
	public List findByQuestion(Object question) {
		return findByProperty(QUESTION, question);
	}
	
	public List findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}
	
	public List findByLastLoginIp(Object lastLoginIp) {
		return findByProperty(LAST_LOGIN_IP, lastLoginIp);
	}
	
	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}
	
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}
	
    public User merge(User detachedInstance) {
        log.debug("merging User instance");
        try {
            User result = (User) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(User instance) {
        log.debug("attaching dirty User instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(User instance) {
        log.debug("attaching clean User instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IBaseUserDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IBaseUserDAO) ctx.getBean("BaseUserDAO");
	}
}