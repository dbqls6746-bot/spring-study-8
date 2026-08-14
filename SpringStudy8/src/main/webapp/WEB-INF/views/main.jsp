<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>main 페이지</h1>
	
	<div>
		<button id = "btn_signup">회원가입하러 가기</button>
		<br>
		<button type="button" onclick=" location.href='/customer/signin' ">로그인 하러가기</button>
	</div>
	
	<script>
		document.getElementById('btn_signup').addEventListener('click',()=>{
			location.href = "/customer/signup";
		})
		
	</script>
</body>
</html>