package com.lexus.service.impl;

import java.util.List;

import com.lexus.bean.Attachment;
import com.lexus.dao.IAttachmentDAO;
import com.lexus.service.IBaseAttachmentService;

public abstract class BaseAttachmentServiceImpl implements IBaseAttachmentService {
	private IAttachmentDAO attachmentDAO;
	public void attachClean(Attachment instance) {
		// TODO 自动生成方法存根

	}

	public void attachDirty(Attachment instance) {
		// TODO 自动生成方法存根

	}

	public void delete(Attachment persistentInstance) {
		this.attachmentDAO.delete(persistentInstance);
	}

	public List findByAttachmentDescription(Object attachmentDescription) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByAttachmentTitle(Object attachmentTitle) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByAttachmentUrl(Object attachmentUrl) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByExample(Attachment instance) {
		// TODO 自动生成方法存根
		return null;
	}

	public Attachment findById(Integer id) {
		return this.attachmentDAO.findById(id);
	}

	public List findByLinkUrl(Object linkUrl) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByStatus(Object status) {
		// TODO 自动生成方法存根
		return null;
	}

	public List findByVersion(Object version) {
		// TODO 自动生成方法存根
		return null;
	}

	public Attachment merge(Attachment detachedInstance) {
		// TODO 自动生成方法存根
		return null;
	}

	public void save(Attachment transientInstance) {
		this.attachmentDAO.save(transientInstance);

	}

	/**
	 * @return attachmentDAO
	 */
	public IAttachmentDAO getAttachmentDAO() {
		return attachmentDAO;
	}

	/**
	 * @param attachmentDAO 要设置的 attachmentDAO
	 */
	public void setAttachmentDAO(IAttachmentDAO attachmentDAO) {
		this.attachmentDAO = attachmentDAO;
	}

}
