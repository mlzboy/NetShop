/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.lexus.struts.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.lexus.bean.DictionaryLib;
import com.lexus.bean.Product;
import com.lexus.bean.ProductDetail;
import com.lexus.util.Constans;

/** 
 * MyEclipse Struts
 * Creation date: 06-06-2007
 * 
 * XDoclet definition:
 * @struts.action path="/manage/productEdit" name="productEditForm" input="/form/productEdit.jsp" scope="request" validate="true"
 */
public class ProductEditAction extends BaseAction {
	/**
	 * Logger for this class
	 */
	private static final Log log = LogFactory.getLog(ProductEditAction.class);

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
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//		ProductEditForm productEditForm = (ProductEditForm) form;// TODO Auto-generated method stub
		if(log.isErrorEnabled())
		{
			log.error("执行execute方法");
		}
		boolean isErr=false;
		ActionMessages infos=new ActionMessages();
		//获取参数
		int id=request.getParameter(Constans.PARAM_OF_ID)==null?0:Integer.parseInt(request.getParameter(Constans.PARAM_OF_ID));
		String categoryName=(String)PropertyUtils.getProperty(form,"categoryName");
		String productName=(String)PropertyUtils.getProperty(form, "productName");
		String productDescription=(String)PropertyUtils.getProperty(form, "productDescription");
		String status=(String)PropertyUtils.getProperty(form, "status");
		long price=Long.parseLong((String)PropertyUtils.getProperty(form, "price"));
		String habitat=(String)PropertyUtils.getProperty(form, "habitat");
		int categoryId=Integer.parseInt(PropertyUtils.getProperty(form, "categoryId").toString());
		if(log.isErrorEnabled())
		{
			log.error("categoryName="+categoryName);
			log.error("productName="+productName);
			log.error("productDescription="+productDescription);
			log.error("status="+status);
			log.error("price="+price);
			log.error("habitat="+habitat);
			log.error("categoryId="+categoryId);
		}
		Product product=this.getProductService().findById(id);
		
		if(product!=null)
		{
			//进行更新操作
			product.setProductName(productName);
			product.setProductDescription(productDescription);
			product.setStatus(status);
				//产品明细
				ProductDetail productDetail=product.getProductDetail();
				productDetail.setProductHabitat(habitat);
				productDetail.setProductPrice(price);
				//字典库
					//验证categoryId合法性
					DictionaryLib dictionaryLib=this.getDictionaryLibService().findById(categoryId);
					if(dictionaryLib!=null)
					{
						//此处的操作假设产品只属于一个分类，即product_categories字段为一个数字，不是采用逗号分隔的字符串，即没有考虑产品多映射的情况，若考虑此情况，以下操作要进行更改
						List temp=new ArrayList();
						temp.add(dictionaryLib);
						product.setProductCategories(temp);
					}
					else
					{
						isErr=true;
						//非法参数
						infos.add("categoryId",new ActionMessage("error.struts.action.productlist.invalid"));
					}
			if(!isErr)
			{
				this.getProductService().saveOrUpdate(product);
				//编辑成功
				infos.add(Constans.MESSAGE_OF_INFO,new ActionMessage("error.struts.action.productlist.modify.success"));
			}
			
		}
		else
		{
			infos.add(Constans.MESSAGE_OF_INFO,new ActionMessage("error.struts.action.productlist.invalid"));
		}
		if(!infos.isEmpty())
		{
			this.saveErrors(request, infos);
		}
		return mapping.findForward(Constans.PAGE_PRODUCT_LIST_SHOW);
	}
}