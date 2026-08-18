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
	<h1>비밀번호 변경 페이지</h1>
	
	
	<form action="/customer/modifyPw" method = "post">	
		변경할 비번 : <input type="password" name="pw"><br>
		<button type="submit">비밀번호 변경하기</button>
		<button type="button" onclick=" location.href='/customer/mypage' ">마이페이지로 이동하기</button>
	</form>
</body>
</html>