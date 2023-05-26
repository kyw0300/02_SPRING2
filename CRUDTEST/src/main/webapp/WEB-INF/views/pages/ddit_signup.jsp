<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
  <title>
    대덕인재개발원 CRUD 연습
  </title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
  <!-- Nucleo Icons -->
  <link href="../assets/css/nucleo-icons.css" rel="stylesheet" />
  <link href="../assets/css/nucleo-svg.css" rel="stylesheet" />
  <!-- Font Awesome Icons -->
  <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
  <!-- Material Icons -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
  <!-- CSS Files -->
  <link id="pagestyle" href="../assets/css/material-dashboard.css?v=3.0.4" rel="stylesheet" />
</head>

<body class="">
  <main class="main-content  mt-0">
    <section>
      <div class="page-header min-vh-100">
        <div class="container">
          <div class="row">
            <div class="col-6 d-lg-flex d-none h-100 my-auto pe-0 position-absolute top-0 start-0 text-center justify-content-center flex-column">
              <div class="position-relative bg-gradient-info h-100 m-3 px-7 border-radius-lg d-flex flex-column justify-content-center" style="background-image: url('../assets/img/illustrations/illustration-lock.jpg'); background-size: cover;">
              </div>
            </div>
            <div class="col-xl-4 col-lg-5 col-md-7 d-flex flex-column ms-auto me-auto ms-lg-auto me-lg-5">
              <div class="card card-plain">
                <div class="card-header">
                  <h4 class="font-weight-bolder">회원가입</h4>
                  <p class="mb-0">회원등록 후, 저희 서비스와 함께해요!</p>
                </div>
                <div class="card-body">
                  <form action="/member/signup" method="post" role="form" name="signupForm">
                    <div class="input-group input-group-outline mb-3">
                      <label class="form-label">아이디</label>
                      <input type="text" class="form-control" name="mem_id" value="${memberVO.mem_id }">
                    </div>
                    <div class="input-group input-group-outline mb-3">
                      <label class="form-label">비밀번호</label>
                      <input type="text" class="form-control" name="mem_pw" value="${memberVO.mem_pw }">
                    </div>
                    <div class="input-group input-group-outline mb-3">
                      <label class="form-label">비밀번호 재입력</label>
                      <input type="text" class="form-control" name="mem_pw2">
                    </div>
					<div class="input-group input-group-outline mb-3">
                      <label class="form-label">이름</label>
                      <input type="text" class="form-control" name="mem_name" value="${memberVO.mem_name }">
                    </div>
					<div class="form-check mb-3">
					  <input class="form-check-input" type="radio" name="mem_gender" id="customRadio1" value="M" checked>
					  <label class="custom-control-label" for="customRadio1">남자</label>
					  <input class="form-check-input" type="radio" name="mem_gender" id="customRadio1" value="F">
					  <label class="custom-control-label" for="customRadio1">여자</label>
					</div>
					<div class="input-group input-group-outline mb-3">
                      <label class="form-label">핸드폰번호</label>
                      <input type="text" class="form-control" name="mem_phone" value="${memberVO.mem_phone }">
                    </div>
					<div class="input-group input-group-outline mb-3">
                      <label class="form-label">이메일</label>
                      <input type="text" class="form-control" name="mem_email" value="${memberVO.mem_email }">
                    </div>
                    <div class="form-check form-switch">
					  <input class="form-check-input" type="checkbox" id="agreeCheck" name="mem_agree" value="agree">
					  <label class="form-check-label" for="agreeCheck">개인정보 동의</label>
					  <a href="../pages/sign-in.html" class="text-primary text-gradient font-weight-bold">
					    상세보기
					  </a>	
					</div>
                    <div class="text-center">
                      <button type="button" class="btn btn-lg bg-gradient-primary btn-lg w-100 mt-4 mb-0" onclick="CheckSignup()">가입하기</button>
                    </div>
                  </form>
                </div>
                <div class="card-footer text-center pt-0 px-lg-2 px-1">
                  <p class="mb-2 text-sm mx-auto">
                    	우리 서비스 회원이세요?
                    <a href="/member/signin" class="text-primary text-gradient font-weight-bold">로그인</a>
                  </p>
                </div>
                <c:if test="${not empty error }">
                	<script>
	                	alert("${error }");
                	</script>
                </c:if>
                <c:if test="${not empty msg }">
                	<script>
	                	alert("${msg }");
                	</script>
                </c:if>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </main>
  <!--   Core JS Files   -->
  <script src="../assets/js/core/bootstrap.min.js"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="../assets/js/material-dashboard.min.js?v=3.0.4"></script>
</body>
<script type="text/javascript">

// $(function(){
// 	$('#agreeCheck').on('change', function (e, data) {
// 	console.log($('#agreeCheck'));
// 	console.log(e);
// 	console.log(e.data);
// 	alert($('#agreeCheck').val())
// // 	alert(data.val);
// 	})
// })
function CheckSignup(){
	var form = document.signupForm;
	var checkbox = document.getElementById('agreeCheck');
	
	
	if(form.mem_id.value == ""){
		alert("아이디를 입력해주세요!");
		form.mem_id.focus();
		return false;
	}
	if(form.mem_pw.value == ""){
		alert("비밀번호를 입력해주세요!");
		form.mem_pw.focus();
		return false;
	}
	if(form.mem_name.value == ""){
		alert("이름을 입력해주세요!");
		form.mem_name.focus();
		return false;
	}
	if(form.mem_phone.value == ""){
		alert("핸드폰 번호를 입력해주세요!");
		form.mem_phone.focus();
		return false;
	}
	if(form.mem_email.value == ""){
		alert("이메일을 입력해주세요!");
		form.mem_email.focus();
		return false;
	}
	if(!checkbox.checked){
		alert("개인정보 동의를 체크해주세요!");
		return false;
	}
	if(form.mem_pw.value != form.mem_pw2.value){
		alert("비밀번호가 일치하지 않습니다!");
		return false;
	}
	
	form.submit();
	
}
</script>
</html>