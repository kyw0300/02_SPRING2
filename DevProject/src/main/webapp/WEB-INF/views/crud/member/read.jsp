<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<body>
	<h2>Member Read</h2>
	<table border="1" style="border-collapse: collapse;">
		<tr>
			<td>userId</td>
			<td>${member.userId }</td>
		</tr>
		<tr>
			<td>userName</td>
			<td>${member.userName }</td>
		</tr>
		<tr>
			<td>auth - 1</td>
			<td>${member.authList[0].auth }</td>
		</tr>
		<tr>
			<td>auth - 2</td>
			<td>${member.authList[1].auth }</td>
		</tr>
		<tr>
			<td>auth - 3</td>
			<td>${member.authList[2].auth }</td>
		</tr>
	</table>
	<a href="/crud/member/modify?userNo=${member.userNo }">
		Modify
	</a>
	<button type="button" id="btnRemove">Remove</button>
	<button type="button" id="btnList">List</button>
</body>
<script type="text/javascript">
$(function(){
	var btnRemove = $("#btnRemove");
	var btnList = $("#btnList");
	
	btnRemove.on("click", function(){
		if(confirm("정말로 삭제하시겠습니까?")){
			location.href = "/crud/member/list";
		}
	});
	btnList.on("click", function(){
		location.href = "/crud/member/list";
	});
});
</script>
</html>