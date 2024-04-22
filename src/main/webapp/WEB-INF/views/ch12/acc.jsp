<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			document.addEventListener('DOMContentLoaded', function() {
				  var accordionHeaders = document.querySelectorAll('.accordion-header');
	
				  accordionHeaders.forEach(function(header) {
				    header.addEventListener('click', function() {
				      var parent = this.parentNode;
				      var isActive = parent.classList.contains('active');
	
				      // Close all accordion items
				      accordionHeaders.forEach(function(item) {
				        item.parentNode.classList.remove('active');
				      });
	
				      // Toggle active class for the clicked item
				      if (!isActive) {
				        parent.classList.add('active');
				      }
				    });
				  });
				});
		</script>
		
		<style type="text/css">
			.accordion {
			  border: 1px solid #ccc;
			}
			
			.accordion-item {
			  border-bottom: 1px solid #ccc;
			}
			
			.accordion-header {
			  background-color: #f4f4f4;
			  padding: 10px;
			  cursor: pointer;
			}
			
			.accordion-content {
			  display: none;
			  padding: 10px;
			}
			
			/* Show content when accordion header is clicked */
			.accordion-item.active .accordion-content {
			  display: block;
			}
		
		</style>
		
	</head>
	
	<body>
		<div class="accordion">
		  <div class="accordion-item">
		    <div class="accordion-header">Section 1</div>
		    <div class="accordion-content">
		      <p>Content for section 1...</p>
		    </div>
		  </div>
		  <div class="accordion-item">
		    <div class="accordion-header">Section 2</div>
		    <div class="accordion-content">
		      <p>Content for section 2...</p>
		    </div>
		  </div>
		  <!-- Add more accordion items as needed -->
		</div>
	</body>
</html>