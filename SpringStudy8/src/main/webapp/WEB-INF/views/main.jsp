<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>main 페이지</h1>
	
	<div>
		<c:if test="${loginUserId == null }">
			<button id = "btn_signup">회원가입하러 가기</button>
		<br>
		<button type="button" onclick=" location.href='/customer/signin' ">로그인 하러가기</button>
		</c:if>	
		
		<c:if test="${loginUserId != null }">
		<p>${loginUserId} 님 환영합니다. </p>
		<button type="button" onclick=" location.href='/customer/mypage' ">마이페이지로 이동하기</button>
		<br>
		<button type="button" onclick=" location.href='/customer/signout' ">로그아웃</button>
		</c:if>	
	</div>
	
	<script>
		document.getElementById('btn_signup').addEventListener('click',()=>{
			location.href = "/customer/signup";
		})
		
	</script>
</body>
</html>