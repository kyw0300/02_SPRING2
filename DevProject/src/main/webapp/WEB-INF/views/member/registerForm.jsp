<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER FORM</title>
</head>
<body>
	<h1>REGISTER FORM</h1>
	<hr/>
	
	<h4>1. 컨트롤러 메소드 매개변수(요청처리)</h4>
	<hr/>
	
	<p>1) URL 경로 상의 쿼리 파라미터 정보로부터 요청 데이터를 취득할 수 있다.</p>
	<a href="/register?userId=stw777&password=7777">BUTTON1</a>
	<br/>
	
	<p>
		2) URL 경로 상의 경로 변수로부터 요청 데이터를 취득할 수 있다.<br/>
		<font color="red">서버 쪽 컨트롤러 메소드에서 @PathVariables를 사용하지 않는 경우 파라미터로 해당 값을 얻을 수 없다.(null)</font>
	</p>
	<a href="/register/jdm999">BUTTON2</a>
	
	<p>3) HTML Form 필드명과 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.</p>
	<form action="/register01" method="post">
		userId : <input type="text" name="userId" value="jdm999"/><br/>
		password : <input type="text" name="password" value="9999"/><br/>
		coin : <input type="text" name="coin" value="100"/><br/>
		<input type="submit" value="register01"/><br/>
	</form>
	
	<p>4) HTML Form 필드가 여러개일 경우에도 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.</p>
	<form action="/register02" method="post">
		userId : <input type="text" name="userId" value="jdm999"/><br/>
		password : <input type="text" name="password" value="9999"/><br/>
		coin : <input type="text" name="coin" value="100"/><br/>
		<input type="submit" value="register02"/><br/>
	</form>
	
	<p>5) HTML Form 필드가 여러 개일 경우에 컨트롤러 매개변수의 위치는 상관이 있는가?</p>
	<form action="/register03" method="post">
		userId : <input type="text" name="userId" value="stw777"/><br/>
		password : <input type="text" name="password" value="7777"/><br/>
		coin : <input type="text" name="coin" value="100"/><br/>
		<input type="submit" value="register03"/><br/>
	</form>
	
	<p>6) HTML Form 필드값이 숫자일 경우에는 컨트롤러 매개변수 타입이 문자열이면 그대로 문자열 형태로 들어가는가?</p>
	<form action="/register04" method="post">
		userId : <input type="text" name="userId" value="stw777"/><br/>
		password : <input type="text" name="password" value="7777"/><br/>
		coin : <input type="text" name="coin" value="100"/><br/>
		<input type="submit" value="register04"/><br/>
	</form>
	
	<p>7) HTML Form 필드값이 숫자일 경우에는 컨트롤러 매개변수 타입이 숫자형이면 숫자로 타입변환하여 데이터를 취득하는가?</p>
	<form action="/register05" method="post">
		userId : <input type="text" name="userId" value="stw777"/><br/>
		password : <input type="text" name="password" value="7777"/><br/>
		coin : <input type="text" name="coin" value="100"/><br/>
		<input type="submit" value="register05"/><br/>
	</form>
	
	<br/><hr/>
	
	<h4>3. 요청 데이터 처리 어노테이션</h4>
	<hr/>
	
	<p>1) URL 경로 상의 경로 변수가 여러 개 일때 @PathVariable 어노테이션을 사용하여 특정한 경로 변수명을 지정해준다.</p>
	<a href="/register/stw777/100">BUTTON3</a>
	
	<p>2) HTML 폼의 필드명과 컨트롤러 매개변수명이 일치하면 요청을 처리할 수 있다.</p>
	<form action="/register0101" method="post">
		userId : <input type="text" name="userId" value="stw777"/><br/>
		password : <input type="text" name="password" value="7777"/><br/>
		coin : <input type="text" name="coin" value="100"/><br/>
		<input type="submit" value="register0101"/><br/>
	</form>
	
	<p>3) HTML 폼 필드명과 컨트롤러 매개변수명이 일치(대소문자 구분)하지 않으면 요청을 처리할 수 없다.</p>
	<form action="/register0201" method="post">
		userId : <input type="text" name="userId" value="stw777"/><br/>
		password : <input type="text" name="password" value="7777"/><br/>
		coin : <input type="text" name="coin" value="100"/><br/>
		<input type="submit" value="register0201"/><br/>
	</form>
	
	<p>4) @RequestParam 어노테이션을 사용하여 특정한 HTML Form의 필드명을 지정하여 요청을 처리한다.</p>
	<form action="/register0202" method="post">
		userId : <input type="text" name="userId" value="stw777"/><br/>
		password : <input type="text" name="password" value="7777"/><br/>
		coin : <input type="text" name="coin" value="100"/><br/>
		<input type="submit" value="register0202"/><br/>
	</form>
	
	<br/><hr/>
	
	<h4>4. 요청 처리 자바빈즈</h4>
	<hr/>
	
	<p>1) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.</p>
	<form action="/beans/register01" method="post">
		userId : <input type="text" name="userId" value="a001"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		coin : <input type="text" name="coin" value="456"/><br/>
		<input type="submit" value="registerJavaBeans01"/><br/>
	</form>
	
	<p>2) 폼 텍스트 필드 요소값을 자바빈즈 매개변수와 기본 데이터 타입인 정수 타입 매개변수로 처리한다.</p>
	<form action="/beans/register02" method="post">
		userId : <input type="text" name="userId" value="jdm9999"/><br/>
		password : <input type="text" name="password" value="9999"/><br/>
		coin : <input type="text" name="coin" value="777"/><br/>
		<input type="submit" value="registerJavaBeans02"/><br/>
	</form>
	
	<p>3) 여러 개의 폼 텍스트 필드 요소값을 매개변수 순서와 상관없이 매개변수명을 기준으로 처리한다.</p>
	<form action="/beans/register03" method="post">
		uid : <input type="text" name="uid" value="50"/><br/>
		userId : <input type="text" name="userId" value="jdm9999"/><br/>
		password : <input type="text" name="password" value="9999"/><br/>
		coin : <input type="text" name="coin" value="777"/><br/>
		<input type="submit" value="registerJavaBeans03"/><br/>
	</form>
	
	<h4>5. Date 타입 처리</h4>
	<hr/>
	<p>1) 쿼리 파라미터(dateOfBirth=1234)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환에 실패한다.</p>
	<a href="/registerByGet01?userId=kyw0300&dateOfBirth=1234">BUTTON4</a><br/>
	
	<p>2) 쿼리 파라미터(dateOfBirth=1995-07-25)로 전달받은 값이 날짜 문자열 형식으로 설정 시, Date 타입으로 받는가?</p>
	<a href="/registerByGet01?userId=kyw0300&dateOfBirth=1995-07-25">BUTTON5</a>
	
	<p>3) 쿼리 파라미터(dateOfBirth=19980814)로 전달받은 값이 날짜 문자열 형식으로 설정 시, Date 타입으로 받는가?</p>
	<a href="/registerByGet01?userId=kyw0300&dateOfBirth=19980814">BUTTON6</a>
	
	<p>4) 쿼리 파라미터(dateOfBirth=1992/10/13)로 전달받은 값이 날짜 문자열 형식으로 설정 시, Date 타입으로 받는가?</p>
	<a href="/registerByGet01?userId=kyw0300&dateOfBirth=1992/10/13">BUTTON7</a>
	<font color="green">SUCCESS</font>
	
	<p>5) Member 매개변수와 쿼리 파라미터(dateOfBirth=19980814)로 전달받은 값이 날짜 문자열 형식으로 설정 시, Date 타입으로 받는가?</p>
	<a href="/registerByGet02?userId=kyw0300&dateOfBirth=19980814">BUTTON8</a>
	
	<p>6) Member 매개변수와 폼 방식 요청 전달받은 값이 날짜 문자열 형식으로 설정 시, Date 타입으로 받는가?</p>
	<form action="/register" method="post">
		userId : <input type="text" name="userId" value="kyw95"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		dateOfBirth : <input type="text" name="dateOfBirth" value="19980814"/><br/>
		<input type="submit" value="register"/><br/>
	</form>
	<br/><hr/>
</body>
</html>