<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
		<h1>회원정보</h1>	
		<img src = "resources/images/f2.jpg"/>
		</br>
		
		<jsp:include page="loginCheck.jsp"/>
		<jsp:include page="adminCheck.jsp"/>	
		<p>			
		<table class="table table-bordered">
			<TR>
				<TH>아이디</TH>
				<TD>${u.id }</TD>
				
				<Th>비번</TH>
				<TD>${u.pw }</TD>
			</TR>
		</table>
	 <a href="delete?num=${u.id }">유저삭제</a>&nbsp;&nbsp;
	 <a href="modify?num=${u.id }">정보수정</a>&nbsp;&nbsp;
	 <a href="/mvc/list">유저목록</a>	 
	  
	<br><br>

	</div>
</body>
</html>






