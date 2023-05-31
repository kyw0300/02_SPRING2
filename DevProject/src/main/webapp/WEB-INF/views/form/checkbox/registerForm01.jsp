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
	<h2>Spring Form</h2>
	<p>1) 모델에 기본생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.</p>
	<form:form modelAttribute="member" method="post" action="/formtag/checkbox/result">
		<table>
			<tr>
				<td>개발자여부</td>
				<td>
					<form:checkbox path="developer" value="Y"/>
				</td>
			</tr>
			<tr>
				<td>외국인여부</td>
				<td>
					<form:checkbox path="foreigner" value="true"/>
				</td>
			</tr>
			<tr>
				<td>취미(hobby)</td>
				<td>
					<form:checkbox path="hobby" value="농구1" label="농구"/><br/>
					<form:checkbox path="hobby" value="탁구1" label="탁구"/><br/>
					<form:checkbox path="hobby" value="축구1" label="축구"/><br/>
				</td>
			</tr>
			<tr>
				<td>취미(hobbyArray)</td>
				<td>
					<form:checkbox path="hobbyArray" value="농구2" label="농구"/><br/>
					<form:checkbox path="hobbyArray" value="탁구2" label="탁구"/><br/>
					<form:checkbox path="hobbyArray" value="축구2" label="축구"/><br/>
				</td>
			</tr>
			<tr>
				<td>취미(hobbyList)</td>
				<td>
					<form:checkbox path="hobbyList" value="농구3" label="농구"/><br/>
					<form:checkbox path="hobbyList" value="탁구3" label="탁구"/><br/>
					<form:checkbox path="hobbyList" value="축구3" label="축구"/><br/>
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
</body>
</html>