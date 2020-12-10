<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/View/admin/Static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Edit User</title>
	<!-- BOOTSTRAP STYLES-->
	<link href="${url}/css/bootstrap.css" rel="stylesheet" />
	<!-- FONTAWESOME STYLES-->
	<link href="${url}/css/font-awesome.css" rel="stylesheet" />
	<!-- MORRIS CHART STYLES-->

	<!-- CUSTOM STYLES-->
	<link href="${url}/css/custom.css" rel="stylesheet" />
	<!-- GOOGLE FONTS-->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans'
		  rel='stylesheet' type='text/css' />
	<!-- TABLE STYLES-->
</head>
<body>
<div id="wrapper">
	<jsp:include page="/View/admin/nav-bar.jsp"></jsp:include>
	<!-- /. NAV TOP  -->
	<jsp:include page="/View/admin/slide-bar.jsp"></jsp:include>
	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h2>Add User</h2>
					<h5>You can add user in here</h5>
				</div>
			</div>
			<!-- /. ROW  -->
			<hr />
			<div class="row">
				<div class="col-md-12">
					<!-- Form Elements -->
					<div class="panel panel-default">
						<div class="panel-heading">Add User</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-6">
									<h3>User:</h3>

									<form role="form" action="add"  method="post" enctype="multipart/form-data">
										<div class="form-group">
											<label>User Name:</label>
											<c:if test="${ not empty nameError}">
												<p style="color: red"><c:out value="${nameError}" /></p>
											</c:if>
											<input class="form-control" placeholder="Your name" type="textbox" name="username"
												   value=<c:out value="${param.username}"/>>

										</div>
										<div class="form-group">
											<label>Password</label>
											<c:if test="${ not empty passError}">
												<p style="color: red"><c:out value="${passError}" /></p>
											</c:if>

											<input class="form-control" placeholder="please enter password" type="password"
												   name="password" value=<c:out value="${param.password}"/>>
										</div>

										<div class="form-group">
											<label>Email:</label>
											<%--<c:if test="${ not empty maiError && not empty MailFormatError}">--%>
												<p style="color: red"><c:out value="${mailError}" /></p>
												<p style="color: red"><c:out value="${MailFormatError}" /></p>
											<%--</c:if>--%>
											<input class="form-control" type="textbox" placeholder="Please enter email"
												   name="email" value=<c:out value="${param.email}"/>>
										</div>

										<div class="form-group">
											<label>Address:</label>
											<input class="form-control" placeholder="Your address" type="textbox" name="address" >

										</div>
										<div class="form-group">
											<label>Role</label>
											<div class="checkbox">
												<label> <input type="radio" value="1" name="permission"/>Admin
												</label>
												<br>
												<label> <input type="radio" value="2" name="permission" />Client
												</label>
											</div>

										</div>
										<div class="form-group">
											<label>Avatar</label> <input type="file" name="avatar" />
										</div>
										<button type="submit" class="btn btn-default">Add</button>
										<button type="reset" class="btn btn-primary">Reset</button>
									</form>
								</div>
							</div>
						</div>
					</div>
					<!-- End Form Elements -->
				</div>
			</div>
			<!-- /. ROW  -->
			<div class="row">
				<div class="col-md-12"></div>
			</div>
			<!-- /. ROW  -->
		</div>
		<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="${url}/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="${url}/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="${url}/js/jquery.metisMenu.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>

</body>
</html>