<%@ page language="java" pageEncoding="UTF-8" import="com.lexus.bean.*;"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0); 
 %>
 
<html> 
	<head>
		<title>Category Detail</title>
			<meta http-equiv=Expires content=0>
		<meta http-equiv=Pragma content=no-cache>
		<meta http-equiv=Cache-Control content=no-cache></head>
	<body>
	<%DictionaryLib dictionaryLib=(DictionaryLib)request.getAttribute("category"); %>
		<html:form action="/manage/categoryDetail?act=mod">
			categoryName :  <INPUT TYPE="text" NAME="categoryName" value="<%=dictionaryLib.getName()%>"><html:errors property="categoryName"/><br/>
			status : <select name="status">
			<option value="NORMAL" <%if(dictionaryLib.getStatus().equalsIgnoreCase("normal")){out.write("selected");} %>>NORMAL</option>
			<option value="LOCKED" <%if(dictionaryLib.getStatus().equalsIgnoreCase("locked")){out.write("selected");} %>>LOCKED</option>
			<option value="DELETED" <%if(dictionaryLib.getStatus().equalsIgnoreCase("deleted")){out.write("selected");} %>>DELETED</option>
			</select><html:errors property="status"/><br/>
			description : <TEXTAREA NAME="description" ROWS="" COLS=""><%=dictionaryLib.getDescription() %></TEXTAREA><html:errors property="description"/><br/>
			 <INPUT TYPE="hidden" NAME="id" value="<%=dictionaryLib.getPkDictionaryLibId()%>"><br/>
			<html:errors property="info"/><br/>
			<html:submit/>&nbsp;&nbsp;<INPUT TYPE="button" name="delete" value="delete" onclick="if(confirm('删除将不可恢复，确定删除？！')){window.location.href='categoryDetail.do?act=delete&id=<%=dictionaryLib.getPkDictionaryLibId()%>';}">
		</html:form>
	</body>
</html>