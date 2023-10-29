<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.ArrayList, com.mvc.vo.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>



</head>
<body>
	<div class="container text-center">
		
		<h1>유저목록</h1>
		<img src = "resources/images/f1.jpg"/>
		<br/>
		<jsp:include page="loginCheck.jsp"/>
		<jsp:include page="adminCheck.jsp"/>
		
		<div id="result"></div>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>아이디</th>
					<th>선택</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="u">
					<tr>
						<td><a href="list/${u.id}">${u.id }</a></td>
						<td><input type = "checkbox" value = "${u.id }"></td>
					</tr>				
				</c:forEach>				
			</tbody>
		</table>
		<br>
		<a href="insert">회원 등록</a>
		<a href="delete2"> 선택 삭제</a>
		<br>
	</div>
</body>
</html>



