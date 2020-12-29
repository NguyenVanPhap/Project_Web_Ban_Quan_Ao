<%--
  Created by IntelliJ IDEA.
  User: ThinkKING
  Date: 12/21/2020
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cart | E-Shopper</title>
    <link href="${pageContext.request.contextPath}/View/User/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/View/User/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="${pageContext.request.contextPath}/View/User/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="${pageContext.request.contextPath}/View/User/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- dropdown -->
    <script src="js/jquery.easydropdown.js"></script>

    <script src="js/scripts.js" type="text/javascript"></script>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--webfont-->
    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>

    <link href="${pageContext.request.contextPath}/View/User/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/View/User/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/View/User/css/prettyPhoto.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/View/User/css/price-range.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/View/User/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/View/User/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/View/User/css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/View/User/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/View/User/js/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
</head><!--/head-->

<body>
<header id="header"><!--header-->
    <jsp:include page="/View/User/Top-Header.jsp"></jsp:include>
</header><!--/header-->

<section id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li class="active"> Cart</li>
            </ol>
        </div>
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                <tr class="cart_menu">
                    <td>Number</td>
                    <td>Image</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>Total</td>
                    <td>Delete</td>
      <!--              <td class="image">Id</td>
                    <td class="description"></td>
                    <td class="price">Price</td>
                    <td class="quantity">Quantity</td>
                    <td class="total">Total</td>
                    STT // tính cộng dồn lên
                    Sản phẩm(image, tên, bởi ai bán) // Lấy từ Product ra với tên id User tương ứng
                    Giá // Lấy giá từ Id với User tương ứng
                    Số lượng // Lấy từ CartItem ra quantity
                    Thành tiền // Tiền của 1 sp ở product * số lượng
                    Gốc dưới là tổng tiền. // tính tổng các thành tiền...-->
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cartEntity.getCartitemEntities()}" var="cartItem" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td class="cart_product">
                            <a href=""><img height="200" width="200" src="${pageContext.request.contextPath}/image/${cartItem.getProductEntity().getImage()}" alt=""></a>
                        </td>
                        <td class="cart_description">
                            <h4><a href="">${cartItem.getProductEntity().getName()}</a></h4>
                            <p>${cartItem.getProductEntity().getDes() }</p>
                        </td>
                        <td class="cart_price">
                            <h4>${cartItem.getProductEntity().getPrice()} VNĐ</h4>
                        </td>
                        <td class="cart_quantity">
                            <div class="cart_quantity_button">
                                <a class="cart_quantity_up" href="${pageContext.request.contextPath}/member/cart/increaseOrDecrease?pId=${cartItem.getProductEntity().getId()}&&check=1"> + </a>
                                <input class="cart_quantity_input" type="text" name="quantity" value="${cartItem.getQuantity() }" autocomplete="off" size="2">
                                <a class="cart_quantity_down" href="${pageContext.request.contextPath}/member/cart/increaseOrDecrease?pId=${cartItem.getProductEntity().getId()}&&check=0"> - </a>
                            </div>
                        </td>
                        <td class="cart_total">
                            <p class="cart_total_price">${cartItem.getProductEntity().getPrice()*cartItem.getQuantity() } VND</p>
                        </td>
                        <td class="cart_delete">
                            <a class="cart_quantity_delete" href="${pageContext.request.contextPath}/member/cart/remove?pId=${loop.index}"><i class="fa fa-times"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="float-right text-right">
            <h4>Subtotal:</h4>
            <h1>${total} VNĐ</h1>
        </div>
        <div class="float-right text-right">
            <a href="catalog.html" class="btn btn-primary mb-4 btn-lg pl-5 pr-5">Checkout</a>
        </div>
    </div>
</section> <!--/#cart_items-->

<section id="do_action">
    <div class="container">
        <div class="heading">
            <h3>What would you like to do next?</h3>
            <p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <div class="chose_area">
                    <ul class="user_option">
                        <li>
                            <input type="checkbox">
                            <label>Use Coupon Code</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label>Use Gift Voucher</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label>Estimate Shipping & Taxes</label>
                        </li>
                    </ul>
                    <ul class="user_info">
                        <li class="single_field">
                            <label>Country:</label>
                            <select>
                                <option>United States</option>
                                <option>Bangladesh</option>
                                <option>UK</option>
                                <option>India</option>
                                <option>Pakistan</option>
                                <option>Ucrane</option>
                                <option>Canada</option>
                                <option>Dubai</option>
                            </select>

                        </li>
                        <li class="single_field">
                            <label>Region / State:</label>
                            <select>
                                <option>Select</option>
                                <option>Dhaka</option>
                                <option>London</option>
                                <option>Dillih</option>
                                <option>Lahore</option>
                                <option>Alaska</option>
                                <option>Canada</option>
                                <option>Dubai</option>
                            </select>

                        </li>
                        <li class="single_field zip-field">
                            <label>Zip Code:</label>
                            <input type="text">
                        </li>
                    </ul>
                    <a class="btn btn-default update" href="">Get Quotes</a>
                    <a class="btn btn-default check_out" href="">Continue</a>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="total_area">
                    <ul>
                        <li>Cart Sub Total <span>$59</span></li>
                        <li>Eco Tax <span>$2</span></li>
                        <li>Shipping Cost <span>Free</span></li>
                        <li>Total <span>$61</span></li>
                    </ul>
                    <a class="btn btn-default update" href="">Update</a>
                    <a class="btn btn-default check_out" href="">Check Out</a>
                </div>
            </div>
        </div>
    </div>
</section><!--/#do_action-->

<div class="footer">
    <div class="up-arrow">
        <a class="scroll" href="#home"><img src="images/up.png" alt="" /></a>
    </div>
    <div class="container">
        <div class="copyrights">
            <p>Copyright &copy; 2015 All rights reserved | Template by  <a href="http://w3layouts.com">  W3layouts</a></p>
        </div>
        <div class="footer-social-icons">
            <a href="#"><i class="fb"></i></a>
            <a href="#"><i class="tw"></i></a>
            <a href="#"><i class="in"></i></a>
            <a href="#"><i class="pt"></i></a>
        </div>
        <div class="clearfix">
        </div>
    </div>
</div>



<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</body>
</html>
