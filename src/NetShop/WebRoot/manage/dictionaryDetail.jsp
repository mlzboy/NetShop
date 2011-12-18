<%@ page language="java" pageEncoding="UTF-8" import="com.lexus.bean.*;"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0); 
 %>
<html> 
	<head>
		<title>DictionaryDetail</title>
			<meta http-equiv=Expires content=0>
		<meta http-equiv=Pragma content=no-cache>
		<meta http-equiv=Cache-Control content=no-cache></head>
	<body>
	
	<%Dictionary dictionary=(Dictionary)request.getAttribute("dictionary"); %>
		<html:form action="/manage/dictionaryDetail?act=mod">
			dictionaryName : <input type="text" name="dictionaryName" value="<bean:write name="dictionary" property="dictionaryName"/>"><html:errors property="dictionaryName"/><br/>
			isMultinest :   <input type="checkbox" name="isMultinest" value="on" <%if(dictionary.getIsMultinest()==1){out.write("checked=true");} %>><br/>
			dictionaryStatus : <select name="dictionaryStatus">
			<option value="NORMAL" <%if(dictionary.getStatus().equalsIgnoreCase("normal")){out.write("selected");} %>>NORMAL</option>
			<option value="LOCKED" <%if(dictionary.getStatus().equalsIgnoreCase("locked")){out.write("selected");} %>>LOCKED</option>
			<option value="DELETED" <%if(dictionary.getStatus().equalsIgnoreCase("deleted")){out.write("selected");} %>>DELETED</option>
			</select>
			<html:errors property="dictionaryStatus"/><br/>
			<input type="hidden" name="id" value="<bean:write name="dictionary" property="pkDictionaryId"/>"><br/>
			<html:errors property="info"/><br/>
			<html:submit/>&nbsp;&nbsp;<INPUT TYPE="button" name="delete" value="delete" onclick="if(confirm('删除将不可恢复，确定删除？！')){window.location.href='dictionaryDetail.do?act=delete&id=<bean:write name="dictionary" property="pkDictionaryId"/>';}">
		</html:form>
	</body>
</html>

