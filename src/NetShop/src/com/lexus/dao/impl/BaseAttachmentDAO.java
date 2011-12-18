package com.lexus.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lexus.bean.Attachment;
import com.lexus.dao.IBaseAttachmentDAO;

/**
 * Data access object (DAO) for domain model class Attachment.
 * @see com.lexus.bean.Attachment
 * @author MyEclipse - Hibernate Tools
 */
public abstract class BaseAttachmentDAO extends HibernateDaoSupport implements IBaseAttachmentDAO {

    protected static final Log log = LogFactory.getLog(BaseAttachmentDAO.class);

	//property constants
	public static final String ATTACHMENT_TITLE = "attachmentTitle";
	public static final String ATTACHMENT_URL = "attachmentUrl";
	public static final String ATTACHMENT_DESCRIPTION = "attachmentDescription";
	public static final String LINK_URL = "linkUrl";
	public static final String VERSION = "version";
	public static final String STATUS = "status";

	protected void initDao() {
		//do nothing
	}
    
    public void save(Attachment transientInstance) {
        log.debug("saving Attachment instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Attachment persistentInstance) {
        log.debug("deleting Attachment instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Attachment findById( java.lang.Integer id) {
        log.debug("getting Attachment instance with id: " + id);
        try {
            Attachment instance = (Attachment) getHibernateTemplate()
                    .get("com.lexus.bean.Attachment", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Attachment instance) {
        log.debug("finding Attachment instance by example");
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
      log.debug("finding Attachment instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Attachment as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByAttachmentTitle(Object attachmentTitle) {
		return findByProperty(ATTACHMENT_TITLE, attachmentTitle);
	}
	
	public List findByAttachmentUrl(Object attachmentUrl) {
		return findByProperty(ATTACHMENT_URL, attachmentUrl);
	}
	
	public List findByAttachmentDescription(Object attachmentDescription) {
		return findByProperty(ATTACHMENT_DESCRIPTION, attachmentDescription);
	}
	
	public List findByLinkUrl(Object linkUrl) {
		return findByProperty(LINK_URL, linkUrl);
	}
	
	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}
	
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}
	
    public Attachment merge(Attachment detachedInstance) {
        log.debug("merging Attachment instance");
        try {
            Attachment result = (Attachment) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Attachment instance) {
        log.debug("attaching dirty Attachment instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Attachment instance) {
        log.debug("attaching clean Attachment instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IBaseAttachmentDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IBaseAttachmentDAO) ctx.getBean("BaseAttachmentDAO");
	}
}