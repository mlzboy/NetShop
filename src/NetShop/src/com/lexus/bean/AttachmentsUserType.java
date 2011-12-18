package com.lexus.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

import com.lexus.service.IAttachmentService;
import com.lexus.util.AppContext;
import com.lexus.util.Constans;

public class AttachmentsUserType implements UserType {
	/**
	 * Logger for this class
	 */
	private static final org.apache.commons.logging.Log log = LogFactory.getLog(AttachmentsUserType.class);
	

	private static final char SPLITTER=',';
	private static final int[] TYPES=new int[]{Types.VARCHAR};


	public Object deepCopy(Object value) throws HibernateException {
		if(log.isInfoEnabled())
		{
			log.info("执行deepCopy方法");
		}
		if(value!=null)
		{
		List sourcelist=(List)value;
		List targetlist=new ArrayList();
		targetlist.addAll(sourcelist);
		return targetlist;
		}
		else
		{
			return null;
		}
	}


	public boolean equals(Object x, Object y) throws HibernateException {
		if(log.isInfoEnabled())
		{
			log.info("执行equals方法");
		}
		if(x==y)return true;
		if(x!=null&&y!=null)
		{
			List xList=(List)x;
			List yList=(List)y;
			if(xList.size()!=yList.size())return false;
			for(int i=0;i<xList.size();i++)
			{
				Attachment attachment1=(Attachment)xList.get(i);
				Attachment attachment2=(Attachment)yList.get(i);
				if(!attachment1.equals(attachment2))
					return false;
			}
			return true;
		}
		return false;
	}



	public boolean isMutable() {
		if(log.isInfoEnabled())
		{
			log.info("执行isMutable方法");
		}
		return false;
	}

	public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
			throws HibernateException, SQLException {
		if(log.isInfoEnabled())
		{
			log.info("执行nullSafeGet方法");
		}
		String value=(String)Hibernate.STRING.nullSafeGet(rs,names[0]);
		if(value!=null)
		{
			log.info("nullSafeGet方法中的value的值为="+value);
			return parse(value);
		}
		else
		{
			log.info("nullSafeGet方法中的value的值为null");
			return null;
		}
	}

	/**
	 * 将以","分隔的字符串解析为一个字符串数组，并获得每个值对应的Attachment对象组成List返回
	 * @param value
	 * @return
	 */
	public Object parse(String value) {
		if(log.isInfoEnabled())
		{
			log.info("执行parse方法");
		}
		String[] arrStrs=org.apache.commons.lang.StringUtils.split(value,SPLITTER);
		List<Attachment> attachmentList=new ArrayList<Attachment>();
		IAttachmentService attachmentService=(IAttachmentService)AppContext.getInstance().getAppContext().getBean(Constans.SERVICE_ATTACHMENT);
		for(int i=0;i<arrStrs.length;i++)
		{
			log.info(arrStrs[i]);
			attachmentList.add(attachmentService.findById(Integer.parseInt(arrStrs[i])));
		}
		return attachmentList;
	}

	public void nullSafeSet(PreparedStatement st, Object value, int index)
			throws HibernateException, SQLException {
		if(log.isInfoEnabled())
		{
			log.info("执行nullSafeSet方法");
		}
		if(value!=null)
		{
			String str=assemble((List)value);
			Hibernate.STRING.nullSafeSet(st, str, index);
		}
		else
		{
			Hibernate.STRING.nullSafeSet(st, value, index);
		}

	}

	/**
	 * 将Attachment对象的List集合拼装成为以各个Attachment对象的id的字符串，中间用逗号分隔
	 * @param list
	 * @return
	 */
	public String assemble(List list) {
		if(log.isInfoEnabled())
		{
			log.info("执行assemble方法");
		}
		StringBuffer strBuf=new StringBuffer();
		for(int i=0;i<list.size()-1;i++)
		{
			strBuf.append(((Attachment)list.get(i)).getPkAttachmentId().toString()).append(SPLITTER);
		}
		strBuf.append(((Attachment)list.get(list.size()-1)).getPkAttachmentId());
		return strBuf.toString();
	}



	public Class<List> returnedClass() {
		if(log.isInfoEnabled())
		{
			log.info("执行returnedClass方法");
		}
		return List.class;
	}

	public int[] sqlTypes() {
		if(log.isInfoEnabled())
		{
			log.info("执行sqlTypes方法");
		}
		return TYPES;
	}


	public Object assemble(Serializable arg0, Object arg1) throws HibernateException {
		// TODO 自动生成方法存根
		if(log.isInfoEnabled())
		{
			log.info("执行assemble(,)方法");
		}
		return null;
	}


	public Serializable disassemble(Object arg0) throws HibernateException {
		// TODO 自动生成方法存根
		if(log.isInfoEnabled())
		{
			log.info("执行disassemble方法");
		}
		return null;
	}


	public int hashCode(Object arg0) throws HibernateException {
		// TODO 自动生成方法存根
		if(log.isInfoEnabled())
		{
			log.info("执行hashCode方法");
		}
		return 0;
	}


	public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException {
		// TODO 自动生成方法存根
		if(log.isInfoEnabled())
		{
			log.info("执行replace方法");
			
		}
		return null;
	}

}
