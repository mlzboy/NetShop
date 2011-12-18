package com.lexus.dao;

import java.util.List;

import com.lexus.bean.Attachment;

public interface IBaseAttachmentDAO {

	public void save(Attachment transientInstance);

	public void delete(Attachment persistentInstance);

	public Attachment findById(java.lang.Integer id);

	public List findByExample(Attachment instance);

	public List findByProperty(String propertyName, Object value);

	public List findByAttachmentTitle(Object attachmentTitle);

	public List findByAttachmentUrl(Object attachmentUrl);

	public List findByAttachmentDescription(Object attachmentDescription);

	public List findByLinkUrl(Object linkUrl);

	public List findByVersion(Object version);

	public List findByStatus(Object status);

	public Attachment merge(Attachment detachedInstance);

	public void attachDirty(Attachment instance);

	public void attachClean(Attachment instance);

}