package com.lexus.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lexus.bean.User;
import com.lexus.dao.IUserDAO;

public class UserDAO extends BaseUserDAO implements IUserDAO {
	/**
	 * Logger for this class
	 */
	private static final Log log = LogFactory.getLog(UserDAO.class);

	public boolean validateLogin(String username, String password) {
		log.debug("validatelogin username and password");
		String[] args = { username, password,"NORMAL"};
		List list = this.getHibernateTemplate().find(
				"from User where username=? and password=? and status=?", args);

		if (log.isDebugEnabled()) {
			log.debug("validateLogin(String, String) - username=" + username
					+ ", password=" + password);
		}
		if (list == null || list.size() == 0) {
			return false;
		} else {
			return true;
		}

	}
	
	public List findByAll() {
		log.debug("finding all user instance");
		List list=this.getHibernateTemplate().find("from User");
		return list;
	}

	public void saveOrUpdate(User transientInstance) {
        log.debug("saving or updating User instance");
        try {
            getHibernateTemplate().saveOrUpdate(transientInstance);
//            getHibernateTemplate().flush();
            log.debug("save or update successful");
        } catch (RuntimeException re) {
            log.error("save or update failed", re);
            throw re;
        }		
	}

}
