<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>str 페이지</h1>

	<c:forEach var="i" begin="1" end="10" step="1">
		<p>${model}</p>
	</c:forEach>
</body>
</html>