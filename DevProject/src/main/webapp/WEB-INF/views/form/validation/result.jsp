<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Result</h2>
	유저ID : ${member.userId }<br/>
	이름 : ${member.userName }<br/>
	E-Mail : ${member.email }<br/>
</body>
</html>