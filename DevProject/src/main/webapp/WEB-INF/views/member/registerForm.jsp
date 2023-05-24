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
	
	<br/><hr/>
	
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
	
	<h4>7. 폼 방식 요청 처리</h4>
	<hr/>
	<p>1) 폼 텍스트 필드 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerUserId" method="post">
		userId : <input type="text" name="userId"/><br/>
		<input type="submit" value="registerUserId"/><br/>
	</form><br/>
	
	<p>2) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerMemberUserId" method="post">
		userId : <input type="text" name="userId"/><br/>
		<input type="submit" value="registerMemberUserId"/><br/>
	</form><br/>
	
	<p>3) 폼 비밀번호 필드 요소값을 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerPassword" method="post">
		password : <input type="text" name="password"/><br/>
		<input type="submit" value="registerPassword"/><br/>
	</form><br/>
	
	<p>4) 폼 라디오버튼 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerRadio" method="post">
		gender : <br/>
		<input type="radio" name="gender" value="male" checked="checked">Male <br/>
		<input type="radio" name="gender" value="female">Female <br/>
		<input type="radio" name="gender" value="other">Other <br/>
		<input type="submit" value="registerRadio"/><br/>
	</form><br/>
	
	<p>5) 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerSelect" method="post">
		nationality : <br/>
		<select name="nationality">
			<option value="korea">대한민국</option>
			<option value="italy">이탈리아</option>
			<option value="japan">일본</option>
			<option value="germany">독일</option>
			<option value="usa">미국</option>
		</select><br/>
		<input type="submit" value="registerSelect"/><br/>
	</form><br/>
	
	<p>6) 복수 선택이 가능한 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerMultiSelect01" method="post">
		cars : <br/>
		<select name="cars" multiple="multiple">
			<option value="Lamborghini">Lamborghini</option>
			<option value="Ferrari">Ferrari</option>
			<option value="Porsche">Porsche</option>
			<option value="BMW">BMW</option>
			<option value="audi">AUDI</option>
		</select><br/>
		<input type="submit" value="registerMultiSelect01"/><br/>
	</form><br/>
	
	<p>7) 복수 선택이 가능한 폼 셀렉트 박스 요소값을 문자열 배열 타입 매개변수로 처리한다.</p>
	<form action="/registerMultiSelect02" method="post">
		cars : <br/>
		<select name="carArray" multiple="multiple">
			<option value="Lamborghini">Lamborghini</option>
			<option value="Ferrari">Ferrari</option>
			<option value="Porsche">Porsche</option>
			<option value="BMW">BMW</option>
			<option value="audi">AUDI</option>
		</select><br/>
		<input type="submit" value="registerMultiSelect02"/><br/>
	</form><br/>
	
	<p>8) 복수 선택이 가능한 폼 셀렉트박스 요소값을 문자열 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.</p>
	<form action="/registerMultiSelect03" method="post">
		cars : <br/>
		<select name="carList" multiple="multiple">
			<option value="Lamborghini">Lamborghini</option>
			<option value="Ferrari">Ferrari</option>
			<option value="Porsche">Porsche</option>
			<option value="BMW">BMW</option>
			<option value="audi">AUDI</option>
		</select><br/>
		<input type="submit" value="registerMultiSelect03"/><br/>
	</form><br/>
	
	<p>9) 폼 체크박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerCheckbox01" method="post">
		hobby : <br/>
		<input type="checkbox" name="hobby" value="Sports">Sports<br/>
		<input type="checkbox" name="hobby" value="Music">Music<br/>
		<input type="checkbox" name="hobby" value="Movie">Movie<br/>
		<input type="checkbox" name="hobby" value="Book">Book<br/>
		<input type="submit" value="registerCheckbox01"/><br/>
	</form><br/>
	
	<p>10) 폼 체크박스 요소값을 문자열 배열 타입 매개변수로 처리한다.</p>
	<form action="/registerCheckbox02" method="post">
		hobby : <br/>
		<input type="checkbox" name="hobbyArray" value="Sports">Sports<br/>
		<input type="checkbox" name="hobbyArray" value="Music">Music<br/>
		<input type="checkbox" name="hobbyArray" value="Movie">Movie<br/>
		<input type="checkbox" name="hobbyArray" value="Book">Book<br/>
		<input type="submit" value="registerCheckbox02"/><br/>
	</form><br/>
	
	<p>11) 폼 체크박스 요소값을 문자열 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.</p>
	<form action="/registerCheckbox03" method="post">
		hobby : <br/>
		<input type="checkbox" name="hobbyList" value="Sports">Sports<br/>
		<input type="checkbox" name="hobbyList" value="Music">Music<br/>
		<input type="checkbox" name="hobbyList" value="Movie">Movie<br/>
		<input type="checkbox" name="hobbyList" value="Book">Book<br/>
		<input type="submit" value="registerCheckbox03"/><br/>
	</form><br/>
	
	<p>12) 폼 체크박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerCheckbox04" method="post">
		developer : <br/>
		<input type="checkbox" name="developer" value="Y">Sports<br/>
		<input type="submit" value="registerCheckbox04"/><br/>
	</form><br/>
	
	<p>13) 폼 체크박스 요소값을 기본 데이터 타입인 불리언 타입 매개변수로 처리한다.</p>
	<form action="/registerCheckbox05" method="post">
		foreigner : <br/>
		<input type="checkbox" name="foreigner" value="true"><br/>
		<input type="submit" value="registerCheckbox05"/><br/>
	</form><br/>
	
	<p>14) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerAddress" method="post">
		postCode : <input type="text" name="postCode"/><br/>
		location : <input type="text" name="location"/><br/>
		<input type="submit" value="registerAddress"/><br/>
	</form><br/>
	
	<p>15) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerUserAddress" method="post">
		postCode : <input type="text" name="address.postCode"/><br/>
		location : <input type="text" name="address.location"/><br/>
		<input type="submit" value="registerUserAddress"/><br/>
	</form><br/>
	
	<p>16) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerUserCardList" method="post">
		카드1 - 번호 : <input type="text" name="cardList[0].no"/><br/>
		카드1 - 유효년월 : <input type="text" name="cardList[0].validMonth"/><br/>
		카드2 - 번호 : <input type="text" name="cardList[1].no"/><br/>
		카드2 - 유효년월 : <input type="text" name="cardList[1].validMonth"/><br/>
		<input type="submit" value="registerUserCardList"/><br/>
	</form><br/>
	
	<p>17) 폼 텍스트 영역 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerTextArea" method="post">
		introduction : <br/>
		<textarea name="introduction" rows="6" cols="50"></textarea><br/>
		<input type="submit" value="registerTextArea"/><br/>
	</form><br/>
	
	<p>18) 폼 텍스트 영역 요소값은 Date 타입 매개변수로 처리한다.</p>
	<form action="/registerDate01" method="post">
		dateOfBirth : <br/>
		<input type="text" name="dateOfBirth"/><br/>
		<input type="submit" value="registerDate01"/><br/>
	</form><br/>
	
	<h3>8. 파일업로드 폼 방식 요청 처리</h3>
	<hr/>
	
	<p>1) 파일업로드 폼 파일 요소값을 스프링 MVC가 지원하는 MultipartFile 매개변수로 처리한다.</p>
	<form action="/registerFile01" method="post" enctype="multipart/form-data">
		<input type="file" name="picture"/>
		<input type="submit" value="업로드"/>
	</form><br/>
	
	<p>2) 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 매개변수와 문자열 매개변수로 처리한다.</p>
	<form action="/registerFile02" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="stw777"/><br/>
		password : <input type="text" name="password" value="7777"/><br/>
		<input type="file" name="picture"/>
		<input type="submit" value="업로드"/>
	</form><br/>
	
	<p>3) 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 매개변수와 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerFile03" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="a001"/><br/>
		password : <input type="text" name="password" value="0000"/><br/>
		<input type="file" name="picture"/>
		<input type="submit" value="업로드"/>
	</form><br/>
	
	<p>4) 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 FileMember 타입의 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerFile04" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="a001"/><br/>
		password : <input type="text" name="password" value="0000"/><br/>
		<input type="file" name="picture"/>
		<input type="submit" value="업로드"/>
	</form><br/>
	
	<p>5) 여러 개의 파일업로드를 폼 파일 요소값을 여러 개의 MultipartFile 매개변수로 처리한다.</p>
	<form action="/registerFile05" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="a001"/><br/>
		password : <input type="text" name="password" value="0000"/><br/>
		<input type="file" name="picture"/>
		<input type="file" name="picture2"/>
		<input type="submit" value="업로드"/>
	</form><br/>
	
	<p>6) 여러 개의 파일업로드를 폼 파일 요소값을 MultipartFile 타입의 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.</p>
	<form action="/registerFile06" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="a001"/><br/>
		password : <input type="text" name="password" value="0000"/><br/>
		<input type="file" name="pictureList[0]"/>
		<input type="file" name="pictureList[1]"/>
		<input type="submit" value="업로드"/>
	</form><br/>
	
	<p>7) 여러개의 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultiFileMember 타입의 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerFile07" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="a001"/><br/>
		password : <input type="text" name="password" value="0000"/><br/>
		<input type="file" name="pictureList[0]"/>
		<input type="file" name="pictureList[1]"/>
		<input type="submit" value="업로드"/>
	</form><br/>
	
	<p>7) 번과 동일한 URL로 요청 진행</p>
	<form action="/registerFile07" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="a001"/><br/>
		password : <input type="text" name="password" value="0000"/><br/>
		<input type="file" name="pictureList" multiple="multiple"/>
		<input type="submit" value="업로드"/>
	</form><br/>
	
	<p>8) 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 타입의 배열 매개변수로 처리한다.</p>
	<form action="/registerFile08" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="jdm999"/><br/>
		password : <input type="text" name="password" value="9999"/><br/>
		<input type="file" name="pictureList" multiple="multiple"/>
		<input type="submit" value="업로드"/>
	</form><br/>
</body>
</html>