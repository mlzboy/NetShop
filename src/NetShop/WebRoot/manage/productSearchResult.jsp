<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>productSearchResult.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <table width="768" border="1" align="center" cellpadding="4" cellspacing="1">
  <tr>
    <td>搜索结果</td>
  </tr>
  <tr>
    <td>关键词：<c:out value="${param.keyword}"></c:out></td>
  </tr>
</table>
<p/>
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
				<a href="productList.do?act=list&currentpage=1&fielName=<c:out value="${param.fieldName}"></c:out>&keyword=<c:out value="${param.keyword}"></c:out>">首页</a>
				<a
					href="productList.do?act=list&currentpage=<c:out value="${requestScope.page.currentPage-1}"/>&fielName=<c:out value="${param.fieldName}"></c:out>&keyword=<c:out value="${param.keyword}"></c:out>">上一页</a>
			</c:if>
			<c:if test="${requestScope.page.hasNextPage}">
				<a
					href="productList.do?act=list&currentpage=<c:out value="${requestScope.page.currentPage+1}"/>&fielName=<c:out value="${param.fieldName}"></c:out>&keyword=<c:out value="${param.keyword}"></c:out>">下一页</a>
				<a
					href="productList.do?act=list&currentpage=<c:out value="${requestScope.page.pageCount}"/>&fielName=<c:out value="${param.fieldName}"></c:out>&keyword=<c:out value="${param.keyword}"></c:out>">末页</a>
			</c:if>
		</div>
		<html:errors property="info" />
  </body>
</html:html>
