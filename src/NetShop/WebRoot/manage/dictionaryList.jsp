<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title><bean:message key="message.ui.manage.dictionarylist.title" /></title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="javascript">
function turnURL(id)
{
	if(confirm("信息删除后不能恢复，请问要执行删除操作吗？"))
	window.location.href='dictionaryList.do?act=delete&id='+id;
}
</script>
  </head>
  
  <body>
<table width="600" border="1" align="center" cellpadding="4" cellspacing="1">
  <tr>
    <td><bean:message key="message.ui.manage.dictionarylist.dictionaryname" /></td>
    <td><bean:message key="message.ui.manage.dictionarylist.status" /></td>
    <td><bean:message key="message.ui.manage.dictionarylist.operate" /></td>
  </tr>
  <logic:present name="dictionaries">
  <logic:iterate id="dictionary" name="dictionaries" type="com.lexus.bean.Dictionary">
  <tr>
    <td><bean:write name="dictionary" property="dictionaryName" /></td>
    <td><bean:write name="dictionary" property="status" /></td>
    <td><input type="button" name="delete" value="<bean:message key="message.ui.manage.dictionarylist.delete" />" onclick="turnURL(<bean:write name="dictionary" property="pkDictionaryId" />);">
  </tr>
  </logic:iterate>
  </logic:present>
</table>
<html:errors property="info"/>
  </body>
</html:html>
