<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<html> 
	<head>
		<title><bean:message key="message.ui.manage.userlist.title"/></title>
	</head>
	<script language="javascript">
	function turnURL(a,b)
	{
		if(a=="delete" && confirm("信息删除后不能恢复，请问要执行删除操作吗？")==false)
		{
			return;
		}
		window.location.href="userList.do?act="+a+"&id="+b;
	}
	//可以考虑使用js重载
	</script>
	<body>
<table width="600" border="1" align="center" cellpadding="4" cellspacing="1">
  <tr>
    <td><bean:message key="message.ui.manage.userlist.username" /></td>
    <td><bean:message key="message.ui.manage.userlist.status" /></td>
    <td><bean:message key="message.ui.manage.userlist.operate" /></td>
  </tr>
<logic:present name="users"><logic:iterate id="user" name="users" type="com.lexus.bean.User">
  <tr>
    <td><bean:write name="user" property="username" /></td>
    <td><bean:write name="user" property="status" /></td>
    <td>
    <logic:equal name="user" property="status" value="NORMAL">
    <input name="locked" type="button" id="locked" value="<bean:message key="message.ui.manage.userlist.locked"/>" onclick="turnURL('locked','<bean:write name="user" property="pkUserId"/>')"/>
    </logic:equal>
    <logic:equal name="user" property="status" value="LOCKED">
    <input name="unlock" type="button" id="unlock" value="<bean:message key="message.ui.manage.userlist.unlock"/>" onclick="turnURL('unlock','<bean:write name="user" property="pkUserId"/>')"/>    
    </logic:equal>
    <input name="delete" type="button" id="delete" value="<bean:message key="message.ui.manage.userlist.delete"/>" onclick="turnURL('delete','<bean:write name="user" property="pkUserId"/>')"/>
    <input name="modify" type="button" id="modify" value="<bean:message key="message.ui.manage.userlist.modify"/>" onclick="javascript:window.location.href='userMod.do?act=show&id=<bean:write name="user" property="pkUserId"/>'"/>  
      
    </td>
  </tr>
</logic:iterate></logic:present>
</table>
<html:errors property="info"/>
	</body>
</html>

