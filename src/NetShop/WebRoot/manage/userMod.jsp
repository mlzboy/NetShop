<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>userMod.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <c:choose>
  <c:when test="${empty sessionScope.user}">您尚未登录或session已失效请重新登录</c:when>
  <c:otherwise>
    <html:form action="/manage/userMod?act=mod" focus="password">
			<bean:message key="message.ui.manage.usermod.username"/> <html:text name="user" property="username" disabled="true" /><br/>
			<bean:message key="message.ui.manage.usermod.password"/><html:text property="password"/><html:errors property="password"/><br/>
			<bean:message key="message.ui.manage.usermod.newpassword"/> <html:password property="newpassword"/><html:errors property="newpassword"/><br/>
			<bean:message key="message.ui.manage.usermod.newpassword2"/> <html:password property="newpassword2"/><html:errors property="newpassword2"/><br/>
			<html:submit><bean:message key="message.ui.manage.usermod.submit"/></html:submit><html:cancel><bean:message key="message.ui.manage.usermod.cancle"/></html:cancel>
			<input type="hidden" name="id" value="<bean:write name="user" property="pkUserId"/>"/><br/><html:errors property="info"/>
			
    </html:form>
    </c:otherwise>
    </c:choose>
  </body>
</html:html>