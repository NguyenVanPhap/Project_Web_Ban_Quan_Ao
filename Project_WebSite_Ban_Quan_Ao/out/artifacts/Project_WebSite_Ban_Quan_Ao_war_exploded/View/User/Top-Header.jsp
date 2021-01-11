<%--
  Created by IntelliJ IDEA.
  User: ThinkKING
  Date: 12/16/2020
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/View/User" var="url"></c:url>
<div class="top-header">
    <div class="container">
        <div class="logo">
            <a href="${pageContext.request.contextPath }/Home"><img src="${url}/images/logo.png" alt="" /></a>
        </div>
        <div class="header-top-right">
            <!-- start search-->
            <div class="search-box">
                <div id="sb-search" class="sb-search">
                    <form action="${pageContext.request.contextPath }/product/SearchName">
                        <input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search_name" id="search">
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

            <a href="${pageContext.request.contextPath }/member/cart"><i class="cart"></i></a>
        </div>
        <div class="navigation">
            <div>
                <label class="mobile_menu" for="mobile_menu">
                    <span>Menu</span>
                </label>
                <input id="mobile_menu" type="checkbox">
                <ul class="nav">
                    <li class="active"><a href="${pageContext.request.contextPath }/Home">Home</a></li>

                    <li class="dropdown1"><a href="">Áo</a>
                        <ul class="dropdown2">
                            <li><a href="${pageContext.request.contextPath }/product/category?cateid=áo thun&page=1">Áo Thun</a></li>
                            <li><a href="${pageContext.request.contextPath }/product/category?cateid=áo so mi&page=1">Áo Sơ mi</a></li>
                        </ul>
                    </li>

                    <li class="dropdown1"><a href="#">Quần</a>
                        <ul class="dropdown2">

                            <li><a href="${pageContext.request.contextPath }/product/category?cateid=quan jean&page=1">QUần jean</a></li>
                            <li><a href="${pageContext.request.contextPath }/product/category?cateid=quan kaki&page=1">Quần kaki</a></li>

                        </ul>
                    </li>

                    <li class="dropdown1"><a href="#">Giày</a>
                        <ul class="dropdown2">
                            <li><a href="${pageContext.request.contextPath }/product/category?cateid=giày adidas&page=1">Giày adidas</a></li>
                            <li><a href="${pageContext.request.contextPath }/product/category?cateid=giày nike&page=1">Giày nike</a></li>
                        </ul>
                    </li>

                    <li><a href="${url}/contact.jsp">Contact US</a></li>
                    <li><a href="${pageContext.request.contextPath }/infoController">Info</a></li>
                    <div class="clearfix"></div>
                </ul>
            </div>
        </div>
    </div>
</div>