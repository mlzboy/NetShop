<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
 
<html> 
	<head>
		<title>Net Shop Product Edit Panel</title>
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
		<html:form action="/manage/productEdit">
		<input name='id' type='hidden' value='<c:out value="${requestScope.product.pkProductId}">"></c:out>'>
			categoryName : <input type="text" name="categoryName" value="<c:out value="${requestScope.product.productCategories[0].name}" />" onfocus="showTree(this);"><html:errors property="categoryName"/>
			<input type="hidden" name="categoryId" value="<c:out value="${requestScope.product.productCategories[0].pkDictionaryLibId}" />"><html:errors property="categoryId"/><br/>
			productName : <input type="text" name="productName" value="<c:out value="${requestScope.product.productName}" />"><html:errors property="productName"/><br/>
			productDescription : <TEXTAREA NAME="productDescription" ROWS="" COLS=""><c:out value="${requestScope.product.productDescription}" /></TEXTAREA><html:errors property="productDescription"/><br/>
			status : 	<SELECT NAME="status">
						<option value="NORMAL" <c:if test="${requestScope.product.status=='NORMAL'}">selected</c:if>>Normal</option>
						<option value="LOCKED" <c:if test="${requestScope.product.status=='LOCKED'}">selected</c:if>>Locked</option>
						<option value="DELETED" <c:if test="${requestScope.product.status=='DELETED'}">selected</c:if>>Deleted</option>
						</select>
						<html:errors property="status"/><br/>
			price : <input type="text" name="price" value="<c:out value="${requestScope.product.productDetail.productPrice}" />"><html:errors property="price"/><br/>
			habitat : <input type="text" name="habitat" value="<c:out value="${requestScope.product.productDetail.productHabitat}" />"><html:errors property="habitat"/><br/>
			<html:submit/><html:cancel/><br/>
			<html:errors property="info"/>
			
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
						</html:form>
		
	</body>
</html>

