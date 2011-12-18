<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title><bean:message key="message.ui.manage.login.title"></bean:message></title>
	</head>
	<body>
		<html:form action="/manage/login">
			<bean:message key="message.ui.manage.login.username" /><html:text property="username"/><html:errors property="username"/><br/>
			<bean:message key="message.ui.manage.login.password" /><html:password property="password"/><html:errors property="password"/><br/>
			<html:submit><bean:message key="message.ui.manage.login.submit"/></html:submit>
			<html:cancel><bean:message key="message.ui.manage.login.cancle"/></html:cancel><br/>
			<html:errors property="info"/>

		</html:form>
	</body>
</html>

