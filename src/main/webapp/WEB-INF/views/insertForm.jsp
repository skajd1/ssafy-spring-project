<%@ page contentType="text/html;charset=utf-8"%>

<HTML>
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
<BODY>
	<div class="container text-center">
		
		<h1>회원가입</h1>
		<img src = "resources/images/f3.jpg"/>
		<form action="insertProcess" method="post">
			<div class="form-group text-left">
				<label for="id">아이디</label> 
				<input type="text"	class="form-control" name="id">
			</div>

			<div class="form-group text-left">
				<label for="pw">비번</label> 
				<input type="password"	class="form-control" name="pw">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<a href="list">목록보기</a>
	</div>

</BODY>
</HTML>











