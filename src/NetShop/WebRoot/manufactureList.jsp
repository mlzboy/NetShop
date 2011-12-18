<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<HTML>
	<HEAD>
		<TITLE>Spring Paper Products Co., Ltd</TITLE>
		<META name="generator" content="Adobe Photoshop(R) CS Web 照片画廊">
		<META http-equiv="Content-Type" content="text/html; charset=gb2312">
	</HEAD>

<BODY bgcolor=#FFFFFF text=#000000 link=#0000FF vlink=#800080 alink=#FF0000>

<TABLE border="0" cellpadding="5" cellspacing="2" width="100%" bgcolor=#F0F0F0>
<TR>
	<TD><FONT size=3 face=“Arial”>Spring Paper Products Co., Ltd
													<BR>ADD: Shuanglong North Road, Jinhua, China
													<BR>Zip:321000
													<BR>Tel: 0086-579-3291009
													<BR><A href="mailto:info@springpaper.cn"> info@springpaper.cn</A> &nbsp;&nbsp; <a href="mailto:jennifer635180@yahoo.com.cn">jennifer635180@yahoo.com.cn</a>
		</FONT>
	</TD>
</TR>
</TABLE>

<CENTER>
<TABLE border="0" cellpadding="0" cellspacing="2" width="200">
<TR>
</TR>
</TABLE>
</CENTER></P>
<CENTER><TABLE cellspacing=10 cellpadding=0 border=0>

<TR>
<c:set var="page" value="${requestScope.page.recordCount}"></c:set>
<c:set var="i" value="1"></c:set>
<c:forEach var="product" items="${requestScope.products}">
	<TD align="center"><A name="${i}" target="_blank" href="${product.productAttachments[0].attachmentUrl}"><IMG src="${product.productAttachments[0].attachmentUrl}" height="159" width="250" border=0></A>
	<div><span align="center" valign="top"><FONT size=3 face=宋体>${product.productName}</FONT></span></div>
	<br/></TD>
	<c:if test="${i%3==0}"></TR><TR></c:if>
	<c:set var="i" value="${i+1}"></c:set>
</c:forEach>
<c:if test="${(i-1)%3!=0}">
<c:forEach var="j" begin="${(i-1)%3}" end="2" step="1">
<TD align="center"><IMG src="manage\images\none.gif" height="159" width="250" border=0>
	<div><span align="center" valign="top"><FONT size=3 face=宋体>&nbsp;</FONT></span></div>
	<br/></TD>
</c:forEach>
</c:if>
</TR>
</TABLE></CENTER>

<div align=center>
			total recoreds:<c:out value="${requestScope.page.recordCount}"/>，total pages<c:out value="${requestScope.page.pageCount}"/>，current page:<c:out value="${requestScope.page.currentPage}"/>，<c:out value="${requestScope.page.pageSize}"/>recoreds/per page &nbsp;
			<c:if test="${requestScope.page.hasPrePage}">
				<a href="manufactureList.do?currentpage=1&id=${param.id}">First Page</a>
				<a
					href="manufactureList.do?currentpage=<c:out value="${requestScope.page.currentPage-1}"/>&id=${param.id}">Preview Page</a>
			</c:if>
			<c:if test="${requestScope.page.hasNextPage}">
				<a
					href="manufactureList.do?currentpage=<c:out value="${requestScope.page.currentPage+1}"/>&id=${param.id}">Next Page</a>
				<a
					href="manufactureList.do?currentpage=<c:out value="${requestScope.page.pageCount}"/>&id=${param.id}">Last Page</a>
			</c:if>
		</div>
</BODY>
</HTML>
