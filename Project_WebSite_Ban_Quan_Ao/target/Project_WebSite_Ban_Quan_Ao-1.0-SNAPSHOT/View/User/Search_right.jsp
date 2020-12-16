
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
                        <a style="color: black;" href="#">Áo&emsp;&emsp;&emsp;</a>
                        <ul class="dropdown2">
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=10">Áo thun nam</a></li>
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=9">Áo thun nữ</a></li>
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=8">Áo sơ mi nam</a></li>
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=7">Áo sơ mi nữ</a></li>
                        </ul>
                    </li>
                    <li><a style="color: black;" href="#">Giày&emsp;&emsp;&emsp;</a>
                        <ul class="dropdown2">
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=2">Giày adidas</a></li>
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=1">Giày nike</a></li>
                        </ul>
                    </li>
                    <li ><a style="color: black;" href="#">QUần&emsp;&emsp;&emsp;</a>
                        <ul class="dropdown2">
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=6">Quần jean nam</a></li>
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=5">Quần jean nữ</a></li>
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=4">Quần kaki nam</a></li>
                            <li><a style="background-color: #FFE4E1; color: black;" href="${pageContext.request.contextPath }/product/category?cate_id=3">Quần kaki nữ</a></li>
                        </ul>
                    </li>
                </ul>
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

