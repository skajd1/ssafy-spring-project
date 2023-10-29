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
	
		<h1>글읽기</h1>	
		<img src = "resources/images/f2.jpg"/>
		</br>
		
		<jsp:include page="loginCheck.jsp"/>	
		<p>			
			<table class="table table-bordered"><TR>
				<TH>NUM</TH>
				<TD>${b.num }</TD>
				
				<Th>NAME</TH>
				<TD>${b.name }</TD>
			</TR>
			<TR>
				<TH>DATE</TH>
				<TD>${b.wdate }</TD>
				
				<TH>COUNT</TH>
				<TD>${b.count }</TD>
			</TR>
			<TR>
				<TH>TITLE</TH>
				<TD COLSPAN=3>${b.title }</TD>
			</TR>
			<TR>
				<TH>CONTENT</TH>
				<TD COLSPAN=3>
				<textarea readonly class="form-control" rows="5" id="comment" name="comment">			
				${b.content }
				</textarea>
			</td>
			</div>
			</TR>
		</TABLE>
	 <a href="delete?num=${b.num }">글삭제</a>&nbsp;&nbsp;
	 <a href="modify?num=${b.num }">글수정</a>&nbsp;&nbsp;
	 <a href="list">글목록</a>	 
	  
	<br><br>

	</div>
</body>
</html>






