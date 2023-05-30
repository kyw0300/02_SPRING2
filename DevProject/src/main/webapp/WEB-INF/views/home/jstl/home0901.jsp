<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/home0901</title>
</head>
<body>
	<h4>c:import 사용</h4>
	<p>특정 URL의 결과를 읽어와서 현재 위치에 삽입한다.</p>
	<p>절대 URL</p>
	<c:import url="http://localhost/board/list"/>
	<hr/>
	
	<c:import url="http://localhost/board/search">
		<c:param name="keyword" value="orange"/>
	</c:import>
	<hr/>
	<br/>
	
	<p>상대 URL - 절대 경로</p>
	<c:import url="http://localhost/board/list"/>
	<hr/>
	
	<p>상대 URL - 상대 경로</p>
	<c:import url="../../board/list.jsp"/>
	<hr/>
</body>
</html>