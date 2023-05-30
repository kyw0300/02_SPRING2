<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0101</title>
</head>
<body>
	<h3>4. 표현언어(EL)을 이용하여 출력</h3>
	<p>3) 논리 연산자를 이용한 방법</p>
	<table border="1">
		<tr>
			<td>\${coin == 1000 && userId == "k001"}</td>
			<td>${coin == 1000 && userId == "k001" }</td>
		</tr>
		<tr>
			<td>\${coin == 1000 and userId == "k001"}</td>
			<td>${coin == 1000 and userId == "k001" }</td>
		</tr>
		<tr>
			<td>\${not empty member && userId eq "k001" }</td>
			<td>${not empty member && userId eq "k001" }</td>
		</tr>
		<tr>
			<td>\${! empty member && userId eq "k001" }</td>
			<td>${! empty member && userId eq "k001" }</td>
		</tr>
	</table>
</body>
</html>