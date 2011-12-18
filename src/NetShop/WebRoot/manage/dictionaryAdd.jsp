<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title><bean:message key="message.ui.manage.dictionaryadd.title"></bean:message></title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	</head>
	<body>
		<html:form action="/manage/dictionary?act=add">
			<bean:message key="message.ui.manage.dictionaryadd.dictionaryname"></bean:message> <html:text property="dictionaryName"/><html:errors property="dictionaryName"/><br/>
			<bean:message key="message.ui.manage.dictionaryadd.ismultinest"></bean:message><html:checkbox property="isMultinest" value="true"></html:checkbox><html:errors property="isMultinest"/><br/>
			<html:submit><bean:message key="message.ui.manage.dictionaryadd.submit"></bean:message></html:submit><html:cancel><bean:message key="message.ui.manage.dictionaryadd.cancle"></bean:message></html:cancel>
			<br/>
			<html:errors property="info"/>
		</html:form>
	</body>
</html>

