<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html>
	<head>
		<title><bean:message key="message.ui.manage.categoryadd.title" />
		</title>
		<meta http-equiv=Expires content=0>
		<meta http-equiv=Pragma content=no-cache>
		<meta http-equiv=Cache-Control content=no-cache>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link type="text/css" rel="stylesheet" href="css/xtree2.css">
		<script type="text/javascript" src="js/xtree2.js"></script>
		<!-- xloadtree2.js鏂囦欢渚濊禆xtree2.js鏂囦欢銆� -->
		<script type="text/javascript" src="js/xloadtree2.js"></script>
		<script>
 function showTree(a)
{
	a.insertAdjacentElement("beforeBegin",divTree);  
    document.getElementById('divTree').style.display ="";
    //document.getElementById('divTree').style.left=a.offsetLeft+'px';
    //document.getElementById('divTree').style.top=a.offsetTop+ a.offsetHeight+'px';
}
function hideTree(a)
{
	document.getElementById('divTree').style.display="block";
}
function insertValue(oNode,param)
{
    document.getElementById('parentCategoryName').value = oNode.text;
 	//alert(oNode.id);
 	var arr=param.split(',');
    document.getElementById('parentCategoryId').value = arr[0];//父类id
	document.getElementById('dictionaryId').value=arr[1];//字典id
    document.getElementById('divTree').style.display = "none";
}

 </script>
	</head>
	<body>
		<html:form action="/manage/categoryAdd">
			<br />
			<br />
			<table border="1" cellpadding="4" cellspacing="0" width="600"
				align="center">
				<tr>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>
						<bean:message
							key="message.ui.manage.categoryadd.parentcategoryname" />
					</td>
					<td>
						<html:text property="parentCategoryName" onfocus="showTree(this);" />
						<div id="divTree"
							style="overflow-y:auto;height:200px;width:70px;display:none;position:absolute;background-color:#FFF;z-index:1000;border-style:solid;border-color:#ACAA9C;border-width:1px">
							<script type="text/javascript">
var tree=new WebFXLoadTree("dictionaries","dictionaryList2.do");
//var tree=new WebFXTree("dictionaries");
tree.setBehavior('explorer');

//var category12=new WebFXLoadTreeItem("鐨寘","category.xml");
//tree.add(dictionaries);
//var ti0 = new WebFXTreeItem("Item 0");
//tree.add(ti0);
tree.write();
tree.expand();
</script>
						</div>
					</td>
					<td>
						<html:errors property="parentCategoryName" />
					</td>
				</tr>
				<tr>
					<td>
						<bean:message key="message.ui.manage.categoryadd.categoryname" />
					</td>
					<td>
						<html:text property="categoryName" />
					</td>
					<td>
						<html:errors property="categoryName" />
					</td>
				</tr>
				<tr>
					<td>
						<bean:message key="message.ui.manage.categoryadd.description" />
					</td>
					<td>
						<html:textarea property="categoryDescription"></html:textarea>
					</td>
					<td>
						<html:errors property="categoryDescription" />
					</td>
				</tr>
				<tr>
					<td>
						<bean:message key="message.ui.manage.categoryadd.status" />
					</td>
					<td>
						<html:select size="1" property="categoryStatus">
							<html:option value="NORMAL">Normal</html:option>
							<html:option value="LOCKED">Locked</html:option>
							<html:option value="DELETED">Deleted</html:option>
						</html:select>

					</td>
					<td>
						<html:errors property="categoryStatus" />
					</td>
				</tr>
			</table>
			<html:hidden property="parentCategoryId" />
			<html:errors property="parentCategoryId" />
			<br />
			<html:errors property="info" />
			<html:hidden property="dictionaryId" />
			<br />
			<br />
			<div align="center">
			<html:submit>
				<bean:message key="message.ui.manage.categoryadd.submit" />
			</html:submit>
			<html:cancel>
				<bean:message key="message.ui.manage.categoryadd.reset" />
			</html:cancel>
			</div>
		</html:form>
		<div align="right"><a href="help2.html" target="_blank">首次使用请点这里</a></div>
	</body>
</html>

