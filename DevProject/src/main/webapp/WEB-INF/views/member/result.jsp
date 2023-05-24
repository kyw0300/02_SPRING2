<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set value="${member }" var="member"/>
<c:set value="${member.address }" var="add"/>
<h2>RESULT</h2>
아이디 : ${member.userId }<br/>
비밀번호 : ${member.password }<br/>
이름 : ${member.userName }<br/>
이메일 : ${member.email }<br/>
생년월일 : ${member.dateOfBirth }<br/>
성별 : ${member.gender }<br/>
개발자여부 : ${member.developer}<br/>
외국인여부 : ${member.foreigner ? '외국인' : '한국인' }<br/>
국적 : 
<c:forEach items="${member.nationality}" var="nationality">
	 ${nationality}
</c:forEach><br/>
소유차량 : 
<c:forEach items="${member.cars}" var="car">
	 ${car}
</c:forEach><br/>
취미 :
<c:forEach items="${member.hobby}" var="hobby">
	 ${hobby}
</c:forEach><br/>
우편번호 : ${add.postCode}<br/>
주소 : ${add.location}<br/>
<c:forEach items="${member.cardList}" var="cList" varStatus="stat">
	카드${stat.count} - 번호 : ${cList.no}<br/>
	카드${stat.count} - 유효년월 : ${cList.validMonth}<br/>
</c:forEach>
소개 : ${member.introduction }<br/>

</body>
</html>