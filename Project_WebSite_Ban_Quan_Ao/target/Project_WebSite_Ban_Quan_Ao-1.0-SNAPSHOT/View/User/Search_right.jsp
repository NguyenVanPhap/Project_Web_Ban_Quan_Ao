
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/View/User" var="url"></c:url>
<script type="text/javascript">
    var urlMenu=document.getElementById('dropshoe');
    urlMenu.onchange= function (){
        var UserOption =this.options(this.selectedIndex);
    }

</script>
<div class="rsidebar span_1_of_left">
    <section  class="sky-form">
        <div class="product_right">
                <h3 class="m_2">Categories</h3>
                <ul class="nav">

                    <li class="active"><a href="#" style="color: black;"></a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</li>
                    <li>
                        <a style="  color: black;" href="#">Áo&emsp;&emsp;&emsp;</a>
                        <ul class="dropdown2">

                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=9&page=1">Áo thun nam</a></li>
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=8&page=1">Áo thun nữ</a></li>
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=7&page=1">Áo sơ mi nam</a></li>
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=6&page=1">Áo sơ mi nữ</a></li>

                        </ul>
                    </li>
                    <li><a style="color: black;" href="#">Giày&emsp;&emsp;&emsp;</a>
                        <ul class="dropdown2">
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=2&page=1">Giày adidas</a></li>
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=1&page=1">Giày nike</a></li>
                        </ul>
                    </li>
                    <li ><a style="color: black;" href="#">QUần&emsp;&emsp;&emsp;</a>
                        <ul class="dropdown2">

                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=5&page=1">Quần jean nam</a></li>
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=4&page=1">Quần jean nữ</a></li>
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=3&page=1">Quần kaki nam</a></li>
<<<<<<< HEAD

=======
                           
>>>>>>> a1a4dd79683d8d30beb74a8c4f5fc8fbe053d906

                        </ul>
                    </li>
                </ul>
        </div>
    </section>


    <section  class="sky-form">
        <h4>Price</h4>
        <div class="row row1 scroll-pane">
            <div class="col col-4">
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByPrice?startPrice=0&endPrice=100000&page=1">Dưới 100.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByPrice?startPrice=100000&endPrice=200000&page=1">100.000-200.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByPrice?startPrice=200000&endPrice=300000&page=1">200.000-300.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByPrice?startPrice=600000&endPrice=600000&page=1">300.000-600.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByPrice?startPrice=600000&endPrice=1000000&page=1">600.000-1000.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByPrice?startPrice=1000000&endPrice=999999999&page=1">Trên 1000.000</a></li>
            </div>
        </div>
    </section>

</div>

