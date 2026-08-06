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
	<c:forEach var="i" begin="0" end="9" step="1">
		<c:if test="${auth == 'basic'}">
			<c:if test="${memberList[i].type == 'basic'}">
				<p>${memberList[i].id}${memberList[i].pw}${memberList[i].name}${memberList[i].type}</p>
			</c:if>
		</c:if>

		<c:if test="${auth == 'manager'}">
			<c:if test="${memberList[i].type == 'manager'}">
				<p>${memberList[i].id}${memberList[i].pw}${memberList[i].name}${memberList[i].type}</p>
			</c:if>
		</c:if>

		<c:if test="${auth == 'admin'}">
			<p>${memberList[i].id}${memberList[i].pw}${memberList[i].name}${memberList[i].type}</p>
		</c:if>
	</c:forEach>
</body>
</html>