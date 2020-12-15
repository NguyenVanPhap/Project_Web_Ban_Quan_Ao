<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/View/User" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
    <title>Pakhi an E-Commerce online Shopping Category Flat Bootstarp responsive Website Template| Products :: w3layouts</title>
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
<!-- header-section-starts -->
<div class="c-header" id="home">
    <div class="top-header">
        <div class="container">
            <div class="logo">
                <a href="index.html"><img src="${url}/images/logo.png" alt="" /></a>
            </div>
            <div class="header-top-right">
                <!-- start search-->
                <div class="search-box">
                    <div id="sb-search" class="sb-search">
                        <form>
                            <input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
                            <input class="sb-search-submit" type="submit" value="">
                            <span class="sb-icon-search"> </span>
                        </form>
                    </div>
                </div>
                <!-- search-scripts -->
                <script src="${url}/js/classie.js"></script>
                <script src="${url}/js/uisearch.js"></script>
                <script>
                    new UISearch( document.getElementById( 'sb-search' ) );
                </script>
                <!-- //search-scripts -->

                <a href="cart.html"><i class="cart"></i></a>
            </div>
            <div class="navigation">
                <div>
                    <label class="mobile_menu" for="mobile_menu">
                        <span>Menu</span>
                    </label>
                    <input id="mobile_menu" type="checkbox">
                    <ul class="nav">
                        <li class="active"><a href="index.html">Home</a></li>
                        <li class="dropdown1"><a href="#">Áo</a>
                            <ul class="dropdown2">
                                <li><a href="products.html">Áo thun nam</a></li>
                                <li><a href="products.html">Áo thun nữ</a></li>
                                <li><a href="products.html">Áo sơ mi nam</a></li>
                                <li><a href="products.html">Áo Sơ mi nữ</a></li>
                            </ul>
                        </li>
                        <li class="dropdown1"><a href="#">Quần</a>
                            <ul class="dropdown2">
                                <li><a href="products.html">Quần jean nam</a></li>
                                <li><a href="products.html">Quần jean nữ</a></li>
                                <li><a href="products.html">Quần kaki nam</a></li>
                            </ul>
                        </li>
                        </li>
                        <li class="dropdown1"><a href="#">Giày</a>
                            <ul class="dropdown2">
                                <li><a href="products.html">Giày adidas</a></li>
                                <li><a href="products.html">Giày nike</a></li>

                            </ul>
                        </li>
                        <li><a href="contact.html">Contact US</a></li>
                        <div class="clearfix"></div>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- start Dresses-page -->
<!-- content-section-starts -->
<div class="container">
    <div class="dreamcrub">
        <ul class="breadcrumbs">

            <li class="home">
                <a href="index.html" title="Go to Home Page"><img src="${url}/images/home.png" alt=""/></a>&nbsp;
                <span>&gt;</span>
            </li>
            <li>
                Dresses
                <span>&gt;</span>
            </li><li>
            <span class="red">&nbsp;Clothes&nbsp;</span>
        </li>
        </ul>
        <ul class="previous">
            <li><a href="index.html">Back to Previous Page</a></li>
        </ul>
        <div class="clearfix"></div>
    </div>
</div>
<div class="container">
    <div class="ft-ball">
        <div class="cont span_2_of_3">
            <div class="mens-toolbar">
                <div class="sort">
                    <div class="sort-by">
                        <label>Sort By</label>
                        <select>
                            <option value="">
                                Popularity               </option>
                            <option value="">
                                Price : High to Low               </option>
                            <option value="">
                                Price : Low to High               </option>
                        </select>
                        <a href=""><img src="${url}/images/arrow2.gif" alt="" class="v-middle"></a>
                    </div>
                </div>
                <div class="pager">
                    <div class="limiter visible-desktop">
                        <label>Show</label>
                        <select>
                            <option value="" selected="selected">
                                9                </option>
                            <option value="">
                                15                </option>
                            <option value="">
                                30                </option>
                        </select> per page
                    </div>
                    <ul class="dc_pagination dc_paginationA dc_paginationA06">
                        <li><a href="#" class="previous">Pages</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
            <c:forEach items="${productList}" var="pro">
            <div class="box1">
                <div class="col_1_of_single1 span_1_of_single1">
                    <div class="view1 view-fifth1">
                        <div class="top_box">
                            <h3 class="m_1">${pro.getName() }</h3>
                            <p class="m_2">${pro.getCategoryEntity().getCateName()}</p>
                            <a href="single.html">
                                <div class="grid_img">
                                    <c:url value="/image/${pro.getImage()}" var="imgUrl"></c:url>
                                    <div class="css3"><img height="250" width="200" src="${imgUrl}" alt=""/></div>
                                    <div class="mask1">
                                        <div class="info">Quick View</div>
                                    </div>
                                </div>
                                <div class="price">${pro.getPrice() }</div>
                            </a>
                        </div>
                    </div>
                    <ul class="list2">
                        <li>
                            <img src="${url}/images/plus.png" alt=""/>
                            <ul class="icon1 sub-icon1 profile_img">
                                <li><a class="active-icon c1" href="single.html">Add To Bag </a>
                                    <ul class="sub-icon1 list">
                                        <li><h3>Decription</h3><a href=""></a></li>
                                        <li><p>${pro.getDes() }<a href=""></a></p></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
            </div>
            </c:forEach>

        </div>
        <div class="rsidebar span_1_of_left">
            <section  class="sky-form">
                <div class="product_right">
                    <h3 class="m_2">Categories</h3>

                    <select class="dropdown" tabindex="50" data-settings='{"wrapperClass":"metro"}'>
                        <option value="1">Quần</option>
                        <option value="2">Quần jean nam</option>
                        <option value="3">Quần kaki nam</option>
                        <option value="4">Quần jean nữ</option>
                        <option value="5">Quần kaki nữ</option>


                    </select>
                    <select class="dropdown" tabindex="8" data-settings='{"wrapperClass":"metro"}'>
                        <option value="1">Giày</option>
                        <option value="2">Giày adidas</option>
                        <option value="3">Giày nike</option>

                    </select>
                    <select class="dropdown" tabindex="8" data-settings='{"wrapperClass":"metro"}'>
                        <option value="1">Áo</option>
                        <option value="2">ÁO sơ mi nam</option>
                        <option value="3">Áo sơ mi nữ </option>
                        <option value="4">Áo thun nam</option>
                        <option value="5">Áo thun nữ</option>

                    </select>

                </div>


            </section>

            <section  class="sky-form">
                <h4>Price</h4>
                <div class="row row1 scroll-pane">
                    <div class="col col-4">
                        <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i> dưới 100000</label>
                    </div>
                    <div class="col col-4">
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>100.000-200.000</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>200.000-300.000</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>300.000-600.000</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>600.000-1000.000</label>
                    </div>
                </div>
            </section>

        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!-- content-section-ends -->


<div class="footer">
    <div class="up-arrow">
        <a class="scroll" href="#home"><img src="${url}/images/up.png" alt="" /></a>
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
        <div class="clearfix"></div>
    </div>
</div>
</body>
</html>