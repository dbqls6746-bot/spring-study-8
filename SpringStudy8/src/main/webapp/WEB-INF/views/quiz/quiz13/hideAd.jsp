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
	<h1>광고 페이지</h1>
	<form action="/quiz13/hideAd" method="post">
	<c:if test="${close == null}">
	<p>아...... 2차 프로젝트 팀 이름 뭐하지.....?</p>
	</c:if>
	<input type="checkbox" name="close" value = "true">24시간보지않기</input>
	<button type="submit">닫기</button>
	</form>
</body>
</html>