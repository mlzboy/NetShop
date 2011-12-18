<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title><bean:message key="message.ui.manage.useradd.title"></bean:message></title>
	</head>
	<body>
		<html:form action="/manage/userAdd">
			<bean:message key="message.ui.manage.useradd.username"/><html:text property="username"/><html:errors property="username"/><br/>
			<bean:message key="message.ui.manage.useradd.password"/><html:password property="password"/><html:errors property="password"/><br/>
			<bean:message key="message.ui.manage.useradd.password2"/><html:password property="password2"/><html:errors property="password2"/><br/>
			<html:submit><bean:message key="message.ui.manage.useradd.submit"/></html:submit><html:cancel><bean:message key="message.ui.manage.useradd.cancle"/></html:cancel><br/>
			<html:errors property="info"/>
		</html:form>
	  </body>
</html>

