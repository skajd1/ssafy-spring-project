<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.ArrayList, com.mvc.vo.Board"%>
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
		
		<h1>MVC 게시판</h1>
		<img src = "resources/images/f1.jpg"/>
		<br/>
		<jsp:include page="loginCheck.jsp"/>
		
		<form method = "post" action = "search">
			검색:
			<select name = "condition">
				<option value = "title"> 제목 </option>
				<option value = "name"> 글쓴이 </option>
			</select>
			<input type = "text" name = "word">
			<input type = "submit" value = "검색">
		</form>
		
		<div id="result"></div>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>날짜</th>
					<th>조회수</th>
					<th>보기</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="b">
					<tr>
						<td>${b.num }</td>
						<td><a href="detail?num=${b.num}">${b.title }</a></td>
						<td>${b.name }</td>
						<td>${b.wdate }</td>
						<td>${b.count }</td>
						<td><a href='#' onclick="readArticle(${b.num})">보기</a></td>
					</tr>				
				</c:forEach>				
			</tbody>
		</table>
		<br>
		<a href="insert">새글쓰기</a>
		<a href = "txtest" >테스트 </a>
		<br>
	</div>
</body>
</html>



