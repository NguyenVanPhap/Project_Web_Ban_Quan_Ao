
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
            <h3>Bộ lọc tìm kiếm</h3>
            <h4>theo danh mục</h4>
            <div class="row row1 scroll-pane">

                <div class="col col-4">
                    <label class="checkbox"><input type="checkbox" name="catecheckbox" value="áo thun"
                    <c:forEach items="${categorylist}" var="cate" >
                        <c:set var="x" value="áo thun"></c:set>
                            <c:if test="${cate=x}"> checked="checked"</c:if>
                    </c:forEach>><i></i><a href="${pageContext.request.contextPath }/product/category?page=1">áo thun</a></label>
                    <%--/////////////--%>
                    <label class="checkbox"><input type="checkbox" name="catecheckbox" value="áo sơ mi"
                    <c:forEach items="${categorylist}" var="cate" >
                        <c:set var="x" value="áo sơ mi"></c:set>
                    <c:if test="${cate=x}"> checked="checked"</c:if>
                    </c:forEach>><i></i>áo sơ mi</label>
                    <%--/////////////--%>
                    <label class="checkbox"><input type="checkbox" name="catecheckbox" value="quần jean"
                    <c:forEach items="${categorylist}" var="cate" >
                        <c:set var="x" value="quần jean"></c:set>
                    <c:if test="${cate=x}"> checked="checked"</c:if>
                    </c:forEach>><i></i>quần kaki</label>
                    <%--/////////////--%>
                    <label class="checkbox"><input type="checkbox" name="catecheckbox" value="giày nike"
                    <c:forEach items="${categorylist}" var="cate" >
                        <c:set var="x" value="giày nike"></c:set>
                    <c:if test="${cate=x}"> checked="checked"</c:if>
                    </c:forEach>><i></i>áo nike</label>
                    <%--/////////////--%>
                    <label class="checkbox"><input type="checkbox" name="catecheckbox" value="giày adidas"
                    <c:forEach items="${categorylist}" var="cate" >
                        <c:set var="x" value="giày adidas"></c:set>
                    <c:if test="${cate=x}"> checked="checked"</c:if>
                    </c:forEach>><i></i>áo adidas</label>
                </div>
            </div>
        </div>
    </section>


    <section  class="sky-form">
        <h4>Theo giá</h4>
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

