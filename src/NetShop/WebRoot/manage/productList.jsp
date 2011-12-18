<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
	<head>
		<title>Product ListForm Panel</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	</head>
	<body>
		<html:form action="/manage/productList?act=search" method="get">
		<input type="hidden" name="act" value="search"/>
			<table width="768" border="1" align="center" cellpadding="4"
				cellspacing="1">
				<tr>
					<td>
						请选择搜索类型
						<select name="fieldName">
						<option value="p.productName">产品名称</option>
						<option value="p.productDescription">产品描述</option>
						<option value="pd.productPrice">产品价格</option>
						<option value="pd.productHabitat">产品产地</option>
						</select>
						请输入搜索关键词
						<input type="text" name="keyword" />
						<input type="Submit" name="Submit" value="搜索" />
					</td>
				</tr>
				<tr>
					<td>&nbsp;
						<html:errors property="fieldName" />
						<html:errors property="keyword" />
					</td>
				</tr>
			</table>
		</html:form>
		<p>
			&nbsp;
		</p>
		<table width="768" border="1" align="center" cellpadding="4"
			cellspacing="1">
			<tr>
				<td>
					图片
				</td>
				<td>
					产品名称
				</td>
				<td>
					所属分类
				</td>
				<td>
					操作
				</td>
			</tr>
			<c:forEach var="product" items="${requestScope.products}">
				<tr>
					<td>
						<a title="点击查看全图" target="_blank"
							href='../<c:out value="${product.productAttachments[0].attachmentUrl}"/>'><img
								border="0" width="50" height="50"
								src="../<c:out value="${product.productAttachments[0].attachmentUrl}"/>">
						</a>
					</td>
					<td>
						<c:out value="${product.productName}" />
					</td>
					<td>
						<c:out value="${product.productCategories[0].name}" />
					</td>
					<td>
						<a
							href="productList.do?act=mod&id=<c:out value="${product.pkProductId}"/>">编辑</a>&nbsp;&nbsp;
						<a
							href="javascript:if(confirm('确定要删除该项产品吗？，删除将不可恢复！')){window.location.href='productList.do?act=delete&id=<c:out value="${product.pkProductId}"/>';}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div align=center>
			共有<c:out value="${requestScope.page.recordCount}"/>条记录，共有<c:out value="${requestScope.page.pageCount}"/>页，当前在第<c:out value="${requestScope.page.currentPage}"/>页，每页显示<c:out value="${requestScope.page.pageSize}"/>条
			<c:if test="${requestScope.page.hasPrePage}">
				<a href="productList.do?act=list&currentpage=1">首页</a>
				<a
					href="productList.do?act=list&currentpage=<c:out value="${requestScope.page.currentPage-1}"/>">上一页</a>
			</c:if>
			<c:if test="${requestScope.page.hasNextPage}">
				<a
					href="productList.do?act=list&currentpage=<c:out value="${requestScope.page.currentPage+1}"/>">下一页</a>
				<a
					href="productList.do?act=list&currentpage=<c:out value="${requestScope.page.pageCount}"/>">末页</a>
			</c:if>
		</div>
		<html:errors property="info" />
	</body>
</html>

