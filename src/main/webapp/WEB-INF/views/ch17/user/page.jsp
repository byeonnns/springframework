<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
		
		<!-- Bootstrap 5를 위한 외부 라이브러리 설정 -->
		<link href="${pageContext.request.contextPath}/resources/bootstrap-5.3.3/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath}/resources/bootstrap-5.3.3/js/bootstrap.bundle.min.js"></script>
		
		<!-- jQuery 외부 라이브러리  설정-->
		<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.7.1.min.js"></script>
		
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
                 <!-- ###################################### -->
				<div class="card">
					<div class="card-header">로그인한 모든 사람이 볼 수 있는 내용</div>
					<div class="card-body">
						로그인한 모든 사용자가 볼 수 있는 내용입니다.
					</div>
				</div>
                 <!-- ###################################### -->
                  </div>
               </div>
            </div>
         </div>
	</body>
</html>