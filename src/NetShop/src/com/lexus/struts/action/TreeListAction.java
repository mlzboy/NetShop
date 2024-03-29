/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.lexus.struts.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import com.lexus.bean.DictionaryLib;
import com.lexus.util.*;
/** 
 * MyEclipse Struts
 * Creation date: 06-07-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class TreeListAction extends BaseAction {
	/**
	 * Logger for this class
	 */
	private static final Log log = LogFactory.getLog(TreeListAction.class);

	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws IOException 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (log.isInfoEnabled()) {
			log.info("执行treeList Action的execute方法");
		}
//		设置接收信息的字符集
//    	request.setCharacterEncoding("UTF-8");
		//接收浏览器端提交的信息
		int dictionaryId = Integer.parseInt(request.getParameter("dictionaryId"));		
		int parentId = Integer.parseInt(request.getParameter("parentId"));
//		String act = request.getParameter("act");
		//设置输出信息的格式及字符集        
        response.setContentType("text/xml; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");

    	List list=this.getDictionaryLibService().findByParentIdAndDictionaryId(parentId, dictionaryId);
    	if(log.isInfoEnabled())
    	{
    		if(list.isEmpty() || list==null)
    		{
    			log.info("list为空");
    		}
    		else
    		{
    			log.info("list不为空");
    			log.info("共有"+String.valueOf(list.size()+"条记录"));
    		}
    	}

    	//创建XML
    	Element root=new Element("tree");
    	Document doc=new Document(root);
    	if(list!=null)
    	{
    		for(int i=0;i<list.size();i++)
    		{
    			DictionaryLib temp=(DictionaryLib)list.get(i);
    			Element tree=new Element("tree");
    			tree.setAttribute(new Attribute("text",temp.getName()));
//    			tree.setAttribute(new Attribute("id",temp.getPkDictionaryLibId().toString()+","+String.valueOf(dictionaryId)));
    			tree.setAttribute(new Attribute("tooltip",temp.getPkDictionaryLibId().toString()));
    			tree.setAttribute(new Attribute("src","treeList.do?parentId="+temp.getPkDictionaryLibId().toString()+"&dictionaryId="+String.valueOf(dictionaryId)+"&tmp="+PathAndFileOperate.getRandomNumber(10)));
    			tree.setAttribute(new Attribute("onaction","insertValue(this,'"+temp.getPkDictionaryLibId().toString()+","+String.valueOf(dictionaryId)+"')"));
    			tree.setAttribute(new Attribute("action","dd"));
    			tree.setAttribute(new Attribute("target","dd"));
    			
    			doc.getRootElement().addContent(tree);
    		}
    	}
    	
		XMLOutputter xout=new XMLOutputter();
		xout.output(doc, response.getWriter());
		response.getWriter().close();
		return null;
	}
}