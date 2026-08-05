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
	<h1>jstl2</h1>
	
	<p>${msg1}</p>
	<p>${msg2}</p>
	

	띄어쓰기						띄어쓰기
	띄어쓰기 &nsp;&nsp;&nsp;&nsp;&nsp; 띄어쓰기
	&lt; &gt;
	
	<!--<p>${msgXml}</p> -->
	
	<c:out value="${msgXml}" escapeXml="true"/>
	
	<c:out value="${msg1}" escapeXml="true"/>
	<c:out value="${msg2}" escapeXml="true"/>
	
	<c:out value="${msgXml}" escapeXml="false"/>
	
	${msg2}
	
	<c:url var="jstlUrl" value="/jstl"/>
	
	<a href="/jstl1">jstl1 페이지 이동</a>
	<a href="/jstl1">jstl1 페이지 이동</a>
	<a href="/jstl1">jstl1 페이지 이동</a>
	
	<br>
	
	<a href=${jstlUrl}>jstl1 페이지 이동</a>
	<a href=${jstlUrl}>jstl1 페이지 이동</a>
	
	<button id="btn">jstl1 버튼</button>
	
<%-- 	<c:redirect url="http://www.naver.com"/> --%>
	
	<script>
	
		//location.href="http://www.naver.com"
	
		document.getElementById('btn').addEventListener('click', ()=>{
			location.href = "/jstl1";
		})
	
	</script>
	
</body>
</html>