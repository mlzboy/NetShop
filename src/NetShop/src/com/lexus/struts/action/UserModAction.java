/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.lexus.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;

import com.lexus.bean.User;
import com.lexus.util.Constans;

/**
 * MyEclipse Struts Creation date: 05-02-2007
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/userMod" name="userModForm" input="/manage/userMod.jsp"
 *                scope="request" validate="true"
 */
public class UserModAction extends BaseAction {
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String act = request.getParameter(Constans.PARAM_OF_ACTION).trim()
				.toLowerCase();
		if (Constans.ACTION_OF_MODIFY.equals(act)) {
			return this.doModify(mapping, form, request, response);
		} else if (Constans.ACTION_OF_SHOW.equals(act)) {
			return this.doShow(mapping, form, request, response);
		} else {
			return super.execute(mapping, form, request, response);
		}

	}

	private ActionForward doShow(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (log.isInfoEnabled()) {
			log.info("执行UserModAction");
		}
		int id = Integer.parseInt(request.getParameter(Constans.PARAM_OF_ID));
		User user = this.getUserService().findById(id);
		if (user != null) {
			request.getSession().setAttribute(Constans.ENTITY_OF_USER, user);
		} else {
			ActionMessages infos = new ActionMessages();
			infos.add("info", new ActionMessage(
					"error.struts.action.usermod.invalid"));
			if (!infos.isEmpty()) {
				this.saveErrors(request, infos);
			}
		}
		// return mapping.findForward(Constans.PAGE_USERMOD);
		return mapping.getInputForward();
	}

	private ActionForward doModify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter(Constans.PARAM_OF_ID));
		DynaActionForm userModForm = (DynaActionForm) form;
		ActionMessages infos = new ActionMessages();
		String password = (String) userModForm.get("password");
		String newpassword = (String) userModForm.get("newpassword");
		String newpassword2 = (String) userModForm.get("newpassword2");
		// 验证用户是否登录
		User user = this.getUserSession(request);
		if (user == null) {
			infos.add("info", new ActionMessage(
					"error.struts.action.useradd.dislogin"));
		} else {
			if (newpassword.equals(newpassword2)) {
				user = this.getUserService().findById(id);
				if (user != null) {
					if (user.getPassword().equals(password)) {
						user.setPassword(newpassword);
						this.getUserService().saveOrUpdate(user);
						infos.add("info", new ActionMessage(
								"message.struts.action.usermod.success"));
						if (log.isInfoEnabled()) {
							log.info("执行修改密码操作");
						}
					} else {
						infos.add("info", new ActionMessage(
								"error.struts.action.usermod.passworderror"));
					}
				} else {
					infos.add("info", new ActionMessage(
							"error.struts.action.usermod.invalid"));
				}
			} else {
				infos.add("info", new ActionMessage(
						"error.struts.action.usermod.differ"));
			}
			if (!infos.isEmpty()) {
				this.saveErrors(request, infos);
			}
		}
		// return mapping.findForward(Constans.PAGE_USERMOD);
		return mapping.getInputForward();
	}
}