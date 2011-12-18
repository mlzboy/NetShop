package com.lexus.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.lexus.bean.Dictionary;
import com.lexus.util.*;
public final class XMLOperate {
	/**
	 * Logger for this class
	 */
	private static final Log log = LogFactory.getLog(XMLOperate.class);

	public static void createDictionariesXMLFile(String fileName,List list,HttpServletRequest request) throws FileNotFoundException, IOException
	{
		if (log.isInfoEnabled()) {
			log.info("执行createDictionariesXMLFile方法");
		}

		//建立元素
		Element root=new Element("tree");
		//建立一个文档并指定根元素
		Document doc=new Document(root);
		String sElement="tree";
		Iterator iter=list.iterator();
		while(iter.hasNext())
		{
			Dictionary dictionary=(Dictionary)iter.next();
			Element elemTree=new Element(sElement);
			
			Attribute attText=new Attribute("text",dictionary.getDictionaryName());
			elemTree.setAttribute(attText);
			
			Attribute attId=new Attribute("id","0,"+dictionary.getPkDictionaryId().toString());
			elemTree.setAttribute(attId);
			
			elemTree.setAttribute(new Attribute("onaction","insertValue(this)"));
			elemTree.setAttribute(new Attribute("src","../servlet/BuildCategories?act=buildCategories&parentId=0&dictionaryId="+dictionary.getPkDictionaryId().toString()));
			
			doc.getRootElement().addContent(elemTree);
		}
		XMLOutputter outp=new XMLOutputter(Format.getPrettyFormat());
		//格式化输出，产出缩进和换行
		Format format=outp.getFormat();
		//设置XML文档编码语言
		format.setEncoding("UTF-8");
		//设置输出空元素为<sample></sample>格式
		format.setExpandEmptyElements(true);
		outp.setFormat(format);
		//设置储存路径
		String path=request.getSession().getServletContext().getRealPath("");
		fileName=path+"\\"+fileName;
		if(log.isInfoEnabled())
		{
			log.info("path="+path);
			log.info("fileName="+fileName);
		}
		//输出xml文档
		outp.output(doc, new FileOutputStream(fileName));
	}
	public static Document dictionariesXMLDocument(List list)
	{
		if (log.isInfoEnabled()) {
			log.info("执行dictionariesXMLDocument方法");
		}

		//建立元素
		Element root=new Element("tree");
		//建立一个文档并指定根元素
		Document doc=new Document(root);
		String sElement="tree";
		Iterator iter=list.iterator();
		while(iter.hasNext())
		{
			Dictionary dictionary=(Dictionary)iter.next();
			Element elemTree=new Element(sElement);
			
			Attribute attText=new Attribute("text",dictionary.getDictionaryName());
			elemTree.setAttribute(attText);
			
			Attribute attId=new Attribute("id","0,"+dictionary.getPkDictionaryId().toString());
			elemTree.setAttribute(attId);
			
			elemTree.setAttribute(new Attribute("onaction","insertValue(this)"));
			elemTree.setAttribute(new Attribute("src","../servlet/BuildCategories?act=buildCategories&parentId=0&dictionaryId="+dictionary.getPkDictionaryId().toString()));
			
			doc.getRootElement().addContent(elemTree);
		}
		return doc;
	}
	/**
	 * 用以替代dictionariesXMLDocument,功能同dictionariesXMLDocument
	 * @param list
	 * @return
	 */
	public static Document dictionariesXMLDocument2(List list)
	{
		if (log.isInfoEnabled()) {
			log.info("执行dictionariesXMLDocument2方法");
		}

		//建立元素
		Element root=new Element("tree");
		//建立一个文档并指定根元素
		Document doc=new Document(root);
		String sElement="tree";
		Iterator iter=list.iterator();
		while(iter.hasNext())
		{
			Dictionary dictionary=(Dictionary)iter.next();
			Element elemTree=new Element(sElement);
			
			Attribute attText=new Attribute("text",dictionary.getDictionaryName());
			elemTree.setAttribute(attText);
			
//			Attribute attId=new Attribute("id","0,"+dictionary.getPkDictionaryId().toString());
			Attribute attId=new Attribute("tooltip","0");
			elemTree.setAttribute(attId);
			elemTree.setAttribute(new Attribute("action","dd"));
			elemTree.setAttribute(new Attribute("target","dd"));
			elemTree.setAttribute(new Attribute("onaction","insertValue(this,'0,"+dictionary.getPkDictionaryId().toString()+"')"));
			elemTree.setAttribute(new Attribute("src","treeList.do?parentId=0&dictionaryId="+dictionary.getPkDictionaryId().toString()+"&tmp="+PathAndFileOperate.getRandomNumber(10)));
			
			doc.getRootElement().addContent(elemTree);
		}
		return doc;
	}

}
