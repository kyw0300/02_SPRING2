<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script> -->
<section class="content-header">
	<div class="container-fluid">
		<div class="row mb-2">
			<div class="col-sm-6">
				<h1>General Form</h1>
			</div>
			<div class="col-sm-6">
				<ol class="breadcrumb float-sm-right">
					<li class="breadcrumb-item"><a href="#">Home</a></li>
					<li class="breadcrumb-item active">General Form</li>
				</ol>
			</div>
		</div>
	</div>
</section>

<section class="content">
	<div class="container-fluid">
		<div class="row" style="justify-content: center;">

			<div class="col-md-6">
				<div class="card card-primary" style="positon: relative">
					<div class="card-header ui-sortable-handle" style="cursor: move;">
						<h3 class="card-title">공지사항 등록</h3>
					</div>
					
					<!-- 
						파일업로드
						1) method는 꼭 post
						2) enctype="multipart/form-data"
						3) <input type="file" name="boFile"
					 -->
					<!-- 
						요청 URI : /notice/generalFormPost
						요청방식 : post
						요청파라미터 : {boTitle=제목입니다, boContent=내용입니다, boWriter=개똥이, boFile=파일객체}
					 -->
					<form id="frm" name="frm" action="/notice/generalFormPost" method="post" enctype="multipart/form-data">
						<div class="card-body">
							<div class="form-group">
								<label for="boTitle">제목</label>
								<input type="text" class="form-control" id="boTotle" name="boTitle" 
									placeholder="제목을 입력해주세요" required>
							</div>
							<div class="form-group">
								<label for="boContent">내용</label> 
								<textarea id="boContent" name="boContent" rows="3" cols="5"></textarea>
							</div>
							<div class="form-group">
								<label for="boWriter">작성자</label>
								<input type="text" class="form-control" id="boWriter" name="boWriter" 
									placeholder="작성자를 입력해주세요" required>
							</div>
							<div class="form-group">
								<label for="exampleInputFile">File input</label>
								<div class="input-group">
									<div class="custom-file">
										<input type="file" class="custom-file-input" id="boFile" name="boFile" multiple/>
										<label class="custom-file-label" for="boFile">Choose file</label>
									</div>
<!-- 									<div class="input-group-append"> -->
<!-- 										<span class="input-group-text">Upload</span> -->
<!-- 									</div> -->
								</div>
							</div>
<!-- 							<div class="form-check"> -->
<!-- 								<input type="checkbox" class="form-check-input" -->
<!-- 									id="exampleCheck1"> <label class="form-check-label" -->
<!-- 									for="exampleCheck1">Check me out</label> -->
<!-- 							</div> -->
						</div>

						<div class="card-footer">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
	CKEDITOR.replace("boContent");
</script>