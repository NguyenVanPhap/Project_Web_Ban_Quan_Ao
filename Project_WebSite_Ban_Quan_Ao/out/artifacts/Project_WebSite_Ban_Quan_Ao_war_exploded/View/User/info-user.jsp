<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/View/User" var="url"></c:url>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Quản lí tài khoản</title>
	<link href="${url}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${url}/css/font-awesome.min.css" rel="stylesheet">
	<link href="${url}/css/main.css" rel="stylesheet">
	<link href="${url}/css/responsive.css" rel="stylesheet">

	<link href="${url}/css/bootstrap.css" rel='stylesheet' type='text/css' />
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${url}/js/jquery.min.js"></script>
	<!-- Custom Theme files -->
	<link href="${url}/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${url}/css/form.css" rel="stylesheet" type="text/css" media="all" />
	<!-- Custom Theme files -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Pakhi Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!--webfont-->
	<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
	<!-- dropdown -->
	<script src="${url}/js/jquery.easydropdown.js"></script>
	<link href="${url}/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
	<script type="text/javascript" src="${url}/js/hover_pack.js"></script>
	<link rel="stylesheet" href="${url}/css/etalage.css">
	<script src="${url}/js/jquery.etalage.min.js"></script>
	<script>
		jQuery(document).ready(function($){

			$('#etalage').etalage({
				thumb_image_width: 300,
				thumb_image_height: 400,
				source_image_width: 800,
				source_image_height: 1000,
				show_hint: true,
				click_callback: function(image_anchor, instance_id){
					alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
				}
			});

		});
	</script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>
</head>

<body>
<div class="c-header" id="home">
	<jsp:include page="/View/User/Top-Header.jsp"></jsp:include>
</div>

<section id="cart_items">
	<div class="container">
		<div class="step-one">
			<h2 class="heading">Quản lí toàn khoản</h2>
		</div>
		<div class="shopper-informations">
			<div class="row">
				<div class="col-sm-6">
					<div class="shopper-info">
						<p>Thông tin tài khoản</p>
						<form>
							<input id="name" type="text" placeholder="Tên" value="${accountModel.getUsername()}">
							<input id="email" type="text" placeholder="Email" value="${accountModel.getEmail()}">
							<input id="address" type="text" placeholder="Địa chỉ" value="${accountModel.getAddress()}">
							<input id="phonenumber" type="text" placeholder="Số điện thoại" value="${accountModel.getPhonenumber()}">
						</form>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="shopper-info">
						<p>Thay đổi mật khẩu</p>
						<form>
							<input id="oldPassword" type="password" placeholder="Mật khẩu " value="">
							<input id="newPassword" type="password" placeholder="Mật khẩu mới">
							<input id="confirmPassword" type="password" placeholder="Xác nhận mật khẩu">
						</form>
						<a class="btn btn-primary" onclick="changePassword()" href="">Cập nhật thông tin</a>
					</div>
				</div>
			</div>
		</div>
		<div class="review-payment">
			<h2>Lịch sử mua hàng</h2>
		</div>

		<div class="table-responsive cart_info">
			<table class="table table-condensed">
				<thead>
				<tr class="cart_menu">
					<td class="image">ID đơn hàng</td>
					<td class="description">Tình trạng</td>
					<td class="price">Ngày mua</td>
					<td class="quantity">Tổng thanh toán</td>
					<td class="total">Action</td>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="cart" items="${carts}">
					<tr>
						<td class="cart_product">
							<h4>#${cart.id}</h4>
						</td>
						<td class="cart_description">
							<h4>Đã giao</h4>
						</td>
						<td class="cart_description">
							<h4>${cart.buyDate}</h4>
						</td><td class="cart_description">
						<h4>${cart.totalPrice} VNĐ</h4>
					</td><td class="cart_description">
						<a class="center" data-toggle="modal"   data-target="#oderlist${cart.id}">Xem chi tiết</a>
					</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<c:forEach items="${carts}" var="cart">
			<div class="modal fade" id="oderlist${cart.id}">
				<div class="modal-dialog modal-dialog-centered modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Chi  tiết đơn hàng</h4>
						</div>
						<div class="modal-body">
							<table class="table table-condensed">
								<thead>

								<tr class="cart_menu">
									<td class="image">Ảnh</td>
									<td class="description">Tên Sản Phẩm</td>
									<td class="price">Giá</td>
									<td class="quantity">Số Lượng</td>
									<td class="total">Tổng Tiền</td>
								</tr>
								</thead>
								<tbody>
								<c:forEach items="${cart.getItemModelList()}" var="item">
									<tr>
										<td class="cart_product">
											<c:url value="/image/${item.getProduct().getImage()}" var="imgUrl"></c:url>
											<img width="100px" height="100px" src="${imgUrl}" alt="#">
										</td>
										<td class="description">${item.getProduct().getProductName()}</td>
										<td class="price">${item.getUnitPrice()}<span>VNĐ</span></td>
										<td class="quantity">${item.getQuantity()}</td>
										<td class="total">${item.getUnitPrice()*item.getQuantity()}<span>VNĐ</span></td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
							<button type="button" class="btn btn-success">OK</button>
						</div>
					</div>
				</div>
			</div> <!-- end modal -->
		</c:forEach>
	</div>
<%--	<jsp:include page="footer.jsp"></jsp:include>--%>
</section> <!--/#cart_items-->
<script src="${url}/js/jquery.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/jquery.scrollUp.min.js"></script>
<script src="${url}/js/jquery.prettyPhoto.js"></script>
<script src="${url}/js/main.js"></script>
<script>
	function changePassword() {
		var oldPassword =$('#oldPassword').val();
		var newPassword =$('#newPassword').val();
		var confirmPassword =$('#confirmPassword').val();
		var data ={
			oldPassword:oldPassword,
			password:newPassword,
			confirmation_pwd:confirmPassword
		}
		console.log(data)
		$.ajax({
			url: '${APIurl}',
			type: 'PUT',
			enctype: 'multipart/form-data',
			processData:false,
			contentType: 'application/json',
			data:JSON.stringify(data),
			dataType: 'json',
			success: function (result){
				console.log("Success");
			},
			errMode: function (error){
				console.log("Error");
			}

		})

	}
</script>

</body>
</html>
