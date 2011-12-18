package com.lexus.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lexus.bean.User;
import com.lexus.service.IAttachmentService;
import com.lexus.service.IDictionaryLibService;
import com.lexus.service.IDictionaryService;
import com.lexus.service.IFieldNameService;
import com.lexus.service.ILogService;
import com.lexus.service.IProductDetailService;
import com.lexus.service.IProductService;
import com.lexus.service.ITableFieldDictMappingService;
import com.lexus.service.ITableNameService;
import com.lexus.service.IUserDetailService;
import com.lexus.service.IUserService;
import com.lexus.util.AppContext;
import com.lexus.util.Constans;

public class BaseDispatchAction extends DispatchAction {
	/**
	 * Logger for this class
	 */
	protected static final Log log = LogFactory.getLog(BaseAction.class);

	private IUserService userService;
	private IUserDetailService userDetailService;
	private ILogService logService;
	private IAttachmentService attachmentService;
	private IDictionaryLibService dictionaryLibService;
	private IDictionaryService dictionaryService;
	private IFieldNameService fieldNameService;
	private IProductDetailService productDetailService;
	private IProductService productService;
	private ITableFieldDictMappingService tableFieldDictMappingService;
	private ITableNameService tableNameService;
	


	/**
	 * 
	 */
	public BaseDispatchAction() {
		super();
		// TODO 自动生成构造函数存根
	}
	public User getUserSession(HttpServletRequest request)
	{
		return (User)request.getSession(false).getAttribute(Constans.SESSION_USER);
	}
	/**
	 * @return userService
	 */
	public IUserService getUserService() {
		this.userService = (IUserService) AppContext.getInstance()
				.getAppContext().getBean(Constans.SERVICE_USER);

		if (log.isInfoEnabled()) {
			log.info("getUserService()");
		}
		return userService;
	}

	/**
	 * @return logService
	 */
	public ILogService getLogService() {
		this.logService = (ILogService) AppContext.getInstance()
				.getAppContext().getBean(Constans.SERVICE_LOG);

		if (log.isDebugEnabled()) {
			log.debug("getLogService()");
		}
		return logService;
	}

	/**
	 * @return userDetailService
	 */
	public IUserDetailService getUserDetailService() {
		this.userDetailService = (IUserDetailService) AppContext.getInstance()
				.getAppContext().getBean(Constans.SERVICE_USERDETAIL);

		if (log.isDebugEnabled()) {
			log.debug("getUserDetailService()");
		}
		return userDetailService;
	}
	/* （非 Javadoc）
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception {
		// TODO 自动生成方法存根
		return super.execute(arg0, arg1, arg2, arg3);
	}
	/**
	 * @return attachmentService
	 */
	public IAttachmentService getAttachmentService() {
		this.attachmentService=(IAttachmentService)AppContext.getInstance().getAppContext().getBean(Constans.SERVICE_ATTACHMENT);
		if(log.isInfoEnabled())
		{
			log.info("getAttachmentService()");
		}
		return attachmentService;
	}
	/**
	 * @return dictionaryLibService
	 */
	public IDictionaryLibService getDictionaryLibService() {
		this.dictionaryLibService=(IDictionaryLibService)AppContext.getInstance().getAppContext().getBean(Constans.SERVICE_DICTIONARYLIB);
		if(log.isInfoEnabled())
		{
			log.info("getDictionaryLibService()");
		}
		return dictionaryLibService;
	}
	/**
	 * @return dictionaryService
	 */
	public IDictionaryService getDictionaryService() {
		this.dictionaryService=(IDictionaryService)AppContext.getInstance().getAppContext().getBean(Constans.SERVICE_DICTIONARY);
		if(log.isInfoEnabled())
		{
			log.info("getDictionaryService()");
		}
		return dictionaryService;
	}
	/**
	 * @return fieldNameService
	 */
	public IFieldNameService getFieldNameService() {
		this.fieldNameService=(IFieldNameService)AppContext.getInstance().getAppContext().getBean(Constans.SERVICE_FIELDNAME);
		if(log.isInfoEnabled())
		{
			log.info("getFieldNameService()");
		}
		return fieldNameService;
	}
	/**
	 * @return productDetailService
	 */
	public IProductDetailService getProductDetailService() {
		this.productDetailService=(IProductDetailService)AppContext.getInstance().getAppContext().getBean(Constans.SERVICE_PRODUCTDETAIL);
		if(log.isInfoEnabled())
		{
			log.info("getProductDetailService()");
		}
		return productDetailService;
	}
	/**
	 * @return productService
	 */
	public IProductService getProductService() {
		this.productService=(IProductService)AppContext.getInstance().getAppContext().getBean(Constans.SERVICE_PRODUCT);
		if(log.isInfoEnabled())
		{
			log.info("getProductService()");
		}
		return productService;
	}
	/**
	 * @return tableFieldDictMappingService
	 */
	public ITableFieldDictMappingService getTableFieldDictMappingService() {
		this.tableFieldDictMappingService=(ITableFieldDictMappingService)AppContext.getInstance().getAppContext().getBean(Constans.SERVICE_TableFieldDictMappingService);
		if(log.isInfoEnabled())
		{
			log.info("getTableFieldDictMappingService()");
		}
		return tableFieldDictMappingService;
	}
	/**
	 * @return tableNameService
	 */
	public ITableNameService getTableNameService() {
		this.tableNameService=(ITableNameService)AppContext.getInstance().getAppContext().getBean(Constans.SERVICE_TABLENAME);
		if(log.isInfoEnabled())
		{
			log.info("getTableNameService()");
		}
		return tableNameService;
	}
}
