package com.lexus.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lexus.bean.User;
import com.lexus.util.Constans;

public class Authorization implements Filter {
	/**
	 * Logger for this class
	 */
	private static final Log log = LogFactory.getLog(Authorization.class);

	public void destroy() {

	}

	/**
	 * 后台登录验证filter
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (log.isInfoEnabled()) {
			log.info("执行后台session验证filter");
		}
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		if(log.isErrorEnabled())
		{
			log.error("HttpServletRequest.getRequestURI()="+req.getRequestURI());
		}
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute(Constans.SESSION_USER);
		if(user==null && req.getRequestURI().indexOf(".do")>-1 && req.getRequestURI().indexOf("login.do")==-1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("info.jsp");
			rd.forward(req, res);
		}
		else
		{
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
