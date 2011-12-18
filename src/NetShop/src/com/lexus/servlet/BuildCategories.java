package com.lexus.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.lexus.bean.Dictionary;
import com.lexus.bean.DictionaryLib;
import com.lexus.service.IDictionaryLibService;
import com.lexus.service.IDictionaryService;
import com.lexus.util.AppContext;
import com.lexus.util.Constans;

public class BuildCategories extends HttpServlet {
	private static final Log log=LogFactory.getLog(BuildCategories.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
    	//设置接收信息的字符集
    	request.setCharacterEncoding("UTF-8");
		//接收浏览器端提交的信息
		int dictionaryId = Integer.parseInt(request.getParameter("dictionaryId"));		
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		String act = request.getParameter("act");
		//设置输出信息的格式及字符集        
        response.setContentType("text/xml; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
    	//配置spring
    	IDictionaryLibService dictionaryLibService=(IDictionaryLibService)AppContext.getInstance().getAppContext().getBean(Constans.SERVICE_DICTIONARYLIB);
        IDictionaryService dictionaryService=(IDictionaryService)AppContext.getInstance().getAppContext().getBean(Constans.SERVICE_DICTIONARY);
    	//取出fk_dictionary_lib_parent_id和fk_dictionary_id等于获取参数的一层结点集
    	//List list=dictionaryLibService.findByParentIdAndDictionaryId(parentId,dictionaryId);
    	
    	Dictionary dictionary=new Dictionary();
    	dictionary.setPkDictionaryId(dictionaryId);
    	
    	DictionaryLib parentDictionaryLib=new DictionaryLib();
    	//parentId为0表示为顶类，数据库采用Null值表示顶类
    	if(parentId!=0)
    	{
    		parentDictionaryLib.setPkDictionaryLibId(parentId);
    	}
    	else
    	{
    		parentDictionaryLib.setDepth(Short.parseShort("1"));
    	}
    	parentDictionaryLib.setDictionary(dictionary);
    	
//    	DictionaryLib dictLib=dictionaryLibService.findById(parentId);
//    	if(dictLib!=null)
//    	{
//    		parentDictionaryLib.setPkDictionaryLibId(parentId);
//    	}
//    	else
//    	{
//    		parentDictionaryLib.
//    	}
  
    	
    	
    	DictionaryLib dictionaryLib=new DictionaryLib();
    	dictionaryLib.setDictionaryLib(parentDictionaryLib);
    	dictionaryLib.setDictionary(dictionary);
    	if(log.isInfoEnabled())
    	{
    		log.info("执行了findByExample方法");
    	}
//    	List list=dictionaryLibService.findByExample(dictionaryLib);
    	List list=dictionaryLibService.findByParentIdAndDictionaryId(parentId, dictionaryId);
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
//    	list=null;
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
    			tree.setAttribute(new Attribute("id",temp.getPkDictionaryLibId().toString()+","+String.valueOf(dictionaryId)));
    			tree.setAttribute(new Attribute("onaction","insertValue(this)"));
    			tree.setAttribute(new Attribute("src","../servlet/BuildCategories?act=buildCategories&parentId="+temp.getPkDictionaryLibId().toString()+"&dictionaryId="+String.valueOf(dictionaryId)));
    			doc.getRootElement().addContent(tree);
    		}
    	}
    	
		XMLOutputter outp=new XMLOutputter(Format.getPrettyFormat());
		//格式化输出，产出缩进和换行
		Format format=outp.getFormat();
		//设置XML文档编码语言
		format.setEncoding("UTF-8");
		//设置输出空元素为<sample></sample>格式
		format.setExpandEmptyElements(true);
		outp.setFormat(format);
		
    	//创建输出流对象
        PrintWriter out = response.getWriter();
        outp.output(doc, out);
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
