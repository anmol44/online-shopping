<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>online shopping - ${title}</title>
<script>
	window.menu = "${title}"
	window.contextRoot = "${contextRoot}"
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap readable theme CSS -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"
	rel="stylesheet">

<!-- Bootstrap dataTable theme CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<link href="${css}/bootstrap-grid.css" rel="stylesheet">
<link href="${css}/bootstrap-grid.css.map" rel="stylesheet">

<link href="${css}/dataTables.jqueryui.css" rel="stylesheet">





<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>
		<div class="content">
			<!-- Page Content -->
			<!-- loading home content here -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>
			<!-- load only when user clicks about -->
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>
			<!--load only when user clicks contact   -->
			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>

			<!--load only when user clicks contact   -->
			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true }">
				<%@include file="listProducts.jsp"%>
			</c:if>
		</div>

		<!--load only when user clicks show product   -->
		<c:if test="${userClickShowProduct == true }">
			<%@include file="singleProduct.jsp"%>
		</c:if>


		<!-- Footer comes here-->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/popper.js"></script>
		<script src="${js}/bootstrap.min.js"></script>
		<!--self coded javascript  -->

		<!-- data table plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- datatable bootstrap script -->
		<script src="${js}/dataTables.bootstrap.js"></script>



		<script src="${js}/dataTables.jqueryui.js"></script>

		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
