<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
		
		<!-- Bootstrap 5를 위한 외부 라이브러리 설정 -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		
		<!-- jQuery 외부 라이브러리  설정-->
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
		
		<!-- 사용자 정의 자바스크립트 -->
		<script>
			
		</script>
		
	</head>
	
	<body>
		<div class="d-flex flex-column vh-100">
			<%@ include file="/WEB-INF/views/common/header.jsp"%>
			<div class="flex-grow-1 m-2">
				<div class="d-flex row">
					<div class="col-md-4">
						<%@ include file="/WEB-INF/views/common/menu.jsp"%>
					</div>
					
					<div class="col-md-8">
						<!-- ############################################ -->
						<div class="card">
							<div class="card-header">회원가입 양식</div>
								<div class="card-body">
									<form class="m-2" method="post" action="signUp">
										<div class="form-group mb-2">
											<label for="mid">아이디</label>
											<input type="text" class="form-control" id="mid" name="mid" value="${ch04SignUpForm.mid}">
											<div class="text-danger" style="font-size: 0.8rem;"><form:errors path="ch04SignUpForm.mid"/></div>
										</div>
										
										<div class="form-group mb-2">
											<label for="mpassword">비밀번호</label>
											<input type="password" class="form-control" id="mpassword" name="mpassword" value="${ch04SignUpForm.mpassword}">
											<div class="text-danger" style="font-size: 0.8rem;"><form:errors path="ch04SignUpForm.mpassword"/></div>
										</div>
										
										<div class="form-group mb-2">
											<label for="mname">이름</label>
											<input type="text" class="form-control" id="mname" name="mname" value="${ch04SignUpForm.mname}">
											<div class="text-danger" style="font-size: 0.8rem;"><form:errors path="ch04SignUpForm.mname"/></div>
										</div>
										
										<div class="form-group mb-2">
											<label for="memail">이메일</label>
											<input type="text" class="form-control" id="memail" name="memail" value="${ch04SignUpForm.memail}">
											<div class="text-danger" style="font-size: 0.8rem;"><form:errors path="ch04SignUpForm.memail"/></div>
										</div>
										
										<div class="form-group mb-2">
											<label for="mphone">전화번호</label>
											<input type="text" class="form-control" id="mphone" name="mphone" value="${ch04SignUpForm.mphone}">
											<div class="text-danger" style="font-size: 0.8rem;"><form:errors path="ch04SignUpForm.mphone"/></div>
										</div>
										<!-- form 태그 안에 있는 button 태그는 기본적으로 type="submit"를 가진다. -->
										<button type="submit" class="btn btn-success btn-sm">회원가입</button>
									</form>
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>