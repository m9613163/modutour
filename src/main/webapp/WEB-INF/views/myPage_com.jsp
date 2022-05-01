<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>BizNews - Free News Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <!-- Favicon -->
    <link rel="stylesheet" href="<c:url value='../resources/img/favicon.ico'/>">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">  

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
     <link rel="stylesheet" href="<c:url value='../resources/lib/owlcarousel/assets/owl.carousel.min.css'/>">

    <!-- Customized Bootstrap Stylesheet -->
    <link rel="stylesheet" href="<c:url value='../resources/css/style.css'/>">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">  

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
	<%------------ header section  ------------%>
	<jsp:include page="./fix/header.jsp" />

	<!-- 회사 유저 정보 -->
	<c:if test="${company != null}">
		<div class="container-fluid mt-5 pt-3">
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
						<div class="section-title mb-0">
							<h4 class="m-0 text-uppercase font-weight-bold">회원 정보</h4>
						</div>
						<div class="bg-white border border-top-0 p-4 mb-3">
							<div class="mb-4">
								<div class="mb-3">
									<div class="d-flex align-items-center mb-2">
										<i class="fa fa-id-card-alt text-primary mr-2"></i>
										<h6 class="font-weight-bold mb-0">ID</h6>
									</div>
									<p class="mb-4">${company.com_id}</p>
								</div>
								
								<div class="mb-3">
									<div class="d-flex align-items-center mb-2">
										<i class="fa fa-signature text-primary mr-2"></i>
										<h6 class="font-weight-bold mb-0">이름</h6>
									</div>
									<p class="mb-4">${company.com_name}</p>
								</div>
								
								<div class="mb-3">
									<div class="d-flex align-items-center mb-2">
										<i class="fa fa-phone-alt text-primary mr-2"></i>
										<h6 class="font-weight-bold mb-0">전화번호</h6>
									</div>
									<p class="m-0">${company.com_phoneNum}</p>
								</div>

								<div class="mb-3">
									<div class="d-flex align-items-center mb-2">
										<i class="fa fa-map-marker-alt text-primary mr-2"></i>
										<h6 class="font-weight-bold mb-0">주소</h6>
									</div>
									<p class="m-0">${company.com_address}</p>
								</div>
								
								<div class="mb-3">
									<div class="d-flex align-items-center mb-2">
										<i class="fa fa-envelope-open text-primary mr-2"></i>
										<h6 class="font-weight-bold mb-0">이메일</h6>
									</div>
									<p class="m-0">${company.com_email}</p>
								</div>
								
								<div class="mb-3">
									<div class="d-flex align-items-center mb-2">
										<i class="fa fa-calendar-check text-primary mr-2"></i>
										<h6 class="font-weight-bold mb-0">가입일자</h6>
									</div>
									<p class="m-0"><fmt:formatDate value="${company.com_joinDate}" pattern="yyyy-MM-dd"/></p>
								</div>
							</div>
							
							<div class="text-center">
								<button type="button" onclick="location.href='/member/modify_company'" class="btn btn-primary font-weight-semi-bold px-4">정보수정</button> &nbsp;
								<button type="button" onclick="location.href='/member/delete_company'" class="btn btn-primary font-weight-semi-bold px-4">회원탈퇴</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<!-- Contact End -->

	<%------------ footer section  ------------%>
	<jsp:include page="./fix/footer.jsp" />

    <!-- Back to Top -->
    <a href="#" class="btn btn-primary btn-square back-to-top"><i class="fa fa-arrow-up"></i></a>

    <!-- JavaScript Libraries -->
    <script src="<c:url value='https://code.jquery.com/jquery-3.4.1.min.js'/>"></script>
    <script src="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js'/>"></script>
    <script src="<c:url value='../resources/lib/easing/easing.min.js'/>"></script>
    <script src="<c:url value='../resources/lib/owlcarousel/owl.carousel.min.js'/>"></script>

    <!-- Template Javascript -->
    <script src="<c:url value='../resources/js/main.js'/>"></script>
</body>

</html>