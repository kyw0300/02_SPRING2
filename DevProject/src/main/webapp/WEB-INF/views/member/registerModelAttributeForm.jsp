<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerModelAttributeForm</title>
</head>
<body>
	<h3>3. @ModelAttribute 어노테이션</h3>
	<hr/>
	
	<p>1) 기본 자료형은 매개변수로 선언헀을 때 전달되는지 확인합니다.</p>
	<form action="/modelattribute/register01" method="post">
		userId : <input type="text" name="userId" value="jdm999"/><br/>
		password : <input type="text" name="password" value="9999"/><br/>
		<input type="submit" value="register01">
	</form>
	
	<p>2) 기본 자료형인 매개변수에 @ModelAttribute 어노테이션을 지정하여 데이터를 전달한다.</p>
	<form action="/modelattribute/register02" method="post">
		userId : <input type="text" name="userId" value="stw777"/><br/>
		password : <input type="text" name="password" value="7777"/><br/>
		<input type="submit" value="register02">
	</form>
	
	<p>3) 자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 기본적으로 전달된다.</p>
	<form action="/modelattribute/register03" method="post">
		userId : <input type="text" name="userId" value="stw777"/><br/>
		password : <input type="text" name="password" value="7777"/><br/>
		<input type="submit" value="register03">
	</form>
	
</body>
</html>