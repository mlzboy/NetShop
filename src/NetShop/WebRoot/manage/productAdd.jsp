<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>Net Shop Product Add Panel</title>
			<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
				<meta http-equiv=Expires content=0>
		<meta http-equiv=Pragma content=no-cache>
		<meta http-equiv=Cache-Control content=no-cache>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link type="text/css" rel="stylesheet" href="css/xtree2.css">
		<script type="text/javascript" src="js/xtree2.js"></script>
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
    document.getElementById('categoryName').value = oNode.text;
 	//alert(oNode.id);
 	var arr=param.split(',');
    document.getElementById('categoryId').value = arr[0];//父类id
	//document.getElementById('dictionaryId').value=arr[1];//字典id
    document.getElementById('divTree').style.display = "none";
}

 </script>
	</head>
	<body>
		<html:form action="/manage/productAdd" enctype="multipart/form-data">
			categoryName : <html:text property="categoryName" onfocus="showTree(this);" /><div id="divTree"
							style="overflow-y:auto;height:200px;width:70px;display:none;position:absolute;background-color:#FFF;z-index:1000;border-style:solid;border-color:#ACAA9C;border-width:1px">
<script type="text/javascript">
var tree=new WebFXLoadTree("字典库","dictionaryList2.do");
tree.write();
</script>
</div><html:errors property="categoryName"/>
			<html:hidden property="categoryId"/><html:errors property="categoryId"/><br/>
			productName : <html:text property="productName"/><html:errors property="productName"/><br/>
			productDescription : <html:textarea property="productDescription"/><html:errors property="productDescription"/><br/>
			status : 	<html:select size="1" property="status">
							<html:option value="NORMAL">Normal</html:option>
							<html:option value="LOCKED">Locked</html:option>
							<html:option value="DELETED">Deleted</html:option>
						</html:select><html:errors property="status"/><br/>
			price : <html:text property="price"/><html:errors property="price"/><br/>
			habitat : <html:text property="habitat"/><html:errors property="habitat"/><br/>
			attachment : <html:file property="attachment"/><html:errors property="attachment"/><br/>
			<html:submit/><html:cancel/><br/>
			<html:errors property="info"/>

		</html:form>
		
		<div align="right"><a href="help4.html" target="_blank">首次使用请点这里</a></div>
	</body>
</html>

