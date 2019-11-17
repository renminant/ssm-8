<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图书管理</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td>
						<%--<form method="post" action="<%=request.getContextPath()%>/billList.action">--%>
							<input name="method" value="query" class="input-text" type="hidden">
							书籍名称：<input name="name" class="input-text" type="text" value="<c:out value="${name}"></c:out>">
							作者：<input name="author" class="input-text" type="text" value="<c:out value="${author}"></c:out>">
							是否借出：<input type="radio" name="borrower" value="1" <c:if  test="${book.borrower=='1'}">checked</c:if>>是
							<input type="radio" name="payed" value="0" <c:if  test="${book.borrower=='0'}">checked</c:if>>否
							<input value="查 询" type="submit" name="search">
						<%--</form>--%>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			
			<div class="title">借阅管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<thead>
				<tr>
					<td width="70" height="29"><div class="STYLE1" align="center">图书编号</div>
					</td>
					<td width="80"><div class="STYLE1" align="center">书籍名称</div>
					</td>
					<td width="80"><div class="STYLE1" align="center">作者</div>
					</td>
					<td width="100"><div class="STYLE1" align="center">出版社</div>
					</td>
					<td width="100"><div class="STYLE1" align="center">是否借出</div>
					</td>
					<td width="100"><div class="STYLE1" align="center">图书管理</div>
					</td>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="book" items="${pageinfo.list}">
					<tr>
						<td><c:out value="${book.id}"></c:out></td>
						<td><c:out value="${book.productName}"></c:out></td>
						<td><c:out value="${book.productUnit}"></c:out></td>
						<td><c:if test="${book.proId=='0'}">中华出版社</c:if>
							<c:if test="${book.proId=='1'}">清华出版社</c:if>
							<c:if test="${book.proId=='2'}">成光出版社</c:if></td>
						<%--<td><c:out value="${product.proId}"></c:out></td>--%>
						<td>
							<c:if test="${book.payed=='1'}">是</c:if>
							<c:if test="${book.payed=='0'}">否</c:if>
							<%--${product.payed}--%>
						</td>
						<%--<td><c:out value="${product.payed}"></c:out></td>--%>
						<div name="div1">
						<td><a href="<%=request.getContextPath()%>/borrow.action?id=${product.id}">
							<c:if test="${book.payed=='0'}"><input value="借阅" class="input-button" onclick="" type="button"></c:if>
							<c:if test="${book.payed=='1'}"><input value="借阅" class="input-button-disabled" type="button" disabled></c:if>
						</a></td>
						</div>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div align="center">
				当前页是第<span>${pageinfo.pageNum}</span>页&nbsp;一共<span>${pageinfo.pages}</span>页
				<c:if test="${pageinfo.isFirstPage==false}">
					<a href="<%=request.getContextPath()%>/bill2.action?page=${pageinfo.prePage}">上一页</a>
				</c:if>
				<c:if test="${pageinfo.isFirstPage==true}">上一页</c:if>

				<c:if test="${pageinfo.isLastPage==false}">
					<a href="<%=request.getContextPath()%>/bill2.action?page=${pageinfo.nextPage}">下一页</a>
				</c:if>
				<c:if test="${pageinfo.isLastPage==true}">下一页</c:if>
			</div>
		</div>
	</div>

</body>
</html>