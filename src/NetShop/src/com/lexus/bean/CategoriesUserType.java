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

import com.lexus.service.IDictionaryLibService;
import com.lexus.util.AppContext;
import com.lexus.util.Constans;

public class CategoriesUserType implements UserType {
	/**
	 * Logger for this class
	 */
	private static final org.apache.commons.logging.Log log = LogFactory.getLog(CategoriesUserType.class);
	private static final char SPLITTER=',';
	private static final int[] TYPES=new int[]{Types.VARCHAR};
	public Object assemble(Serializable arg0, Object arg1)
			throws HibernateException {
		// TODO 自动生成方法存根
		return null;
	}

	public Object deepCopy(Object value) throws HibernateException {
		if(log.isInfoEnabled())
		{
			log.info("执行deepCopy方法");
		}
		List sourceList=(List)value;
		List targetList=new ArrayList();
		targetList.addAll(sourceList);
		return targetList;
	}

	public Serializable disassemble(Object arg0) throws HibernateException {
		// TODO 自动生成方法存根
		return null;
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
				DictionaryLib dictionaryLib1=(DictionaryLib)xList.get(i);
				DictionaryLib dictionaryLib2=(DictionaryLib)yList.get(i);
				if(!dictionaryLib1.equals(dictionaryLib2))
					return false;
			}
			return true;
		}
		return false;
	}

	public int hashCode(Object arg0) throws HibernateException {
		// TODO 自动生成方法存根
		return 0;
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
	 * 分割字符串
	 * @param value
	 * @return
	 */
	private Object parse(String value) {
		if(log.isInfoEnabled())
		{
			log.info("执行parse方法");
		}
		String[] arrStrs=org.apache.commons.lang.StringUtils.split(value,SPLITTER);
		List<DictionaryLib> dictionaryLibList=new ArrayList<DictionaryLib>();
		IDictionaryLibService dictionaryLibService=(IDictionaryLibService)AppContext.getInstance().getAppContext().getBean(Constans.SERVICE_DICTIONARYLIB);
		for(int i=0;i<arrStrs.length;i++)
		{
			log.info(arrStrs[i]);
			dictionaryLibList.add(dictionaryLibService.findById(Integer.parseInt(arrStrs[i])));
		}
		return dictionaryLibList;
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
	 * 组合成以","分隔的字符串
	 * @param list
	 * @return
	 */
	private String assemble(List list) {
		if(log.isInfoEnabled())
		{
			log.info("执行assemble方法");
		}
		StringBuffer strBuf=new StringBuffer();
		for(int i=0;i<list.size()-1;i++)
		{
			strBuf.append(((DictionaryLib)list.get(i)).getPkDictionaryLibId().toString()).append(SPLITTER);
		}
		strBuf.append(((DictionaryLib)list.get(list.size()-1)).getPkDictionaryLibId());
		return strBuf.toString();
	}

	public Object replace(Object arg0, Object arg1, Object arg2)
			throws HibernateException {
		// TODO 自动生成方法存根
		return null;
	}

	public Class returnedClass() {
		if(log.isInfoEnabled())
		{
			log.info("执行returntedClass方法");
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

}
