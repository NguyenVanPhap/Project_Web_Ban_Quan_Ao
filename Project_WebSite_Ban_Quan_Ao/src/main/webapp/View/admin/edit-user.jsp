<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<c:url value="/View/admin/Static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Product Management</title>
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
	<link href="${url}/js/dataTables/dataTables.bootstrap.css"
		  rel="stylesheet" />
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
					<h2>Edit User</h2>
					<h5>You can Edit user's information  in here</h5>
				</div>
			</div>
			<!-- /. ROW  -->
			<hr />
			<div class="row">
				<div class="col-md-12">
					<!-- Form Elements -->
					<div class="panel panel-default">
						<div class="panel-heading">Info you can change</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-6">
									<h3>User:</h3>
									<c:url value="/admin/user/edit" var="edit"></c:url>

									<form role="form" action="${edit }" method="post" enctype="multipart/form-data">

										<input name="id" value="${user.id }" type="text" hidden="">

										<div class="form-group">
											<label>User Name:</label> <input class="form-control"
																			 value="${user.userName }" name="username" />
										</div>

										<div class="form-group">
											<label>Password</label> <input class="form-control"
																		   value="${user.password }" type="password" name="password" />
										</div>

										<div class="form-group">
											<label>Email:</label> <input class="form-control"
																		 value="${user.email }" name="email" />
										</div>

										<div class="form-group">
											<label>Address:</label> <input class="form-control"
																		   value="${user.address }" name="address" />
										</div>

										<div class="form-group">
											<label>Role</label>
											<div class="checkbox">
												<label> <input type="radio" value="1" name="permission"
														<c:if test="${user.permission==1}">
															checked
														</c:if>
												/>Admin
												</label> <br>
												<label> <input type="radio" value="2"
															   name="permission" <c:if test="${user.permission==2}">
													checked
												</c:if>
												/>Client
												</label>
											</div>

										</div>

										<div class="form-group">
											<label>Choose Avatar</label> <input type="file"
																				name="avatar" value="${user.avatar }" />
										</div>
										<button type="submit" class="btn btn-default">Edit</button>
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