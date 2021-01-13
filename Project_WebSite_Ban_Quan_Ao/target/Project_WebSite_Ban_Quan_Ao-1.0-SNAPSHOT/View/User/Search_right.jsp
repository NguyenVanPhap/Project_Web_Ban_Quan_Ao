
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
<<<<<<< HEAD
<<<<<<< Updated upstream
    <h3>Bộ lọc tìm kiếm</h3>
=======
>>>>>>> parent of 0dd74e8... load
    <section  class="sky-form">
        <div class="product_right">
            <h4>Bộ lọc tìm kiếm</h4>
            <h4>theo danh mục</h4>
            <div class="row row1 scroll-pane">
                <div class="col col-4">
                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=0&page=1'"
                                                   type="checkbox"  value="áo thun">All</label>
                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=1&page=1'"
                                                   type="checkbox"  value="áo thun">giày nike</label>

                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=2&page=1'"
                                                   type="checkbox"  value="áo thun">giày adidas</label>

                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=3&page=1'"
                                                   type="checkbox"  value="áo thun">áo thun </label>

                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=4&page=1'"
                                                   type="checkbox"  value="áo thun">áo sơ mi</label>

                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=5&page=1'"
                                                   type="checkbox"  value="áo thun">quần kaki</label>

                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=6&page=1'"
                                                   type="checkbox"  value="áo thun">quần jean</label>

                </div>

            </div>
        </div>
    </section>
<<<<<<< HEAD
    
=======
    <section  class="sky-form">
        <div class="product_right">
            <h4>Bộ lọc tìm kiếm</h4>
            <h4>theo danh mục</h4>
            <div class="row row1 scroll-pane">
                <div class="col col-4">
                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=0&page=1'"
                                                   type="checkbox"  value="áo thun">All</label>
                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=1&page=1'"
                                                   type="checkbox"  value="áo thun">giày nike</label>

                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=2&page=1'"
                                                   type="checkbox"  value="áo thun">giày adidas</label>

                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=3&page=1'"
                                                   type="checkbox"  value="áo thun">áo thun </label>

                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=4&page=1'"
                                                   type="checkbox"  value="áo thun">áo sơ mi</label>

                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=5&page=1'"
                                                   type="checkbox"  value="áo thun">quần kaki</label>

                    <label class="checkbox"><input onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=6&page=1'"
                                                   type="checkbox"  value="áo thun">quần jean</label>

                </div>

            </div>
        </div>
    </section>


>>>>>>> Stashed changes
=======


>>>>>>> parent of 0dd74e8... load
    <section  class="sky-form">
        <h4>Theo giá</h4>
        <div class="row row1 scroll-pane">
            <div class="col col-4">
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=0&endPrice=10000000&page=1">ALL</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=0&endPrice=100000&page=1">Dưới 100.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=100000&endPrice=200000&page=1">100.000-200.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=200000&endPrice=300000&page=1">200.000-300.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=600000&endPrice=600000&page=1">300.000-600.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=600000&endPrice=1000000&page=1">600.000-1000.000</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?startPrice=1000000&endPrice=999999999&page=1">Trên 1000.000</a></li>
            </div>
        </div>
    </section>
    <section  class="sky-form">
        <h4>Theo màu</h4>
        <div class="row row1 scroll-pane">
            <div class="col col-4">
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?colorid=0&page=1">ALL</a></li>
<<<<<<< HEAD
<<<<<<< Updated upstream
                <c:forEach items="${colorList}" var="color">
                    <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?colorid=${color.getColorId()}&page=1">${color.getColorName()}</a></li>

                </c:forEach>
=======
=======
>>>>>>> parent of 0dd74e8... load
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?colorid=1&page=1">Xanh</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?colorid=2&page=1">Đỏ</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?colorid=3&page=1">Tím</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?colorid=4&page=1">Vàng</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?colorid=5&page=1">Nâu</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?colorid=6&page=1">Đen</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?colorid=7&page=1">Hồng</a></li>
<<<<<<< HEAD
>>>>>>> Stashed changes
=======
>>>>>>> parent of 0dd74e8... load
            </div>
        </div>
    </section>

<<<<<<< HEAD
<<<<<<< Updated upstream

=======
=======
>>>>>>> parent of 0dd74e8... load
   <%-- <section  class="sky-form">
        <h4>Theo màu</h4>
        <div class="row row1 scroll-pane">
            <div class="col col-4">
                <select name="color" style="width: 50%" onchange="searchByProperty()">
                    <option onclick="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=1&page=1&color_id=0'"  value="0" selected>All</option>
                    <option  onchange="window.location.href='${pageContext.request.contextPath }/product/searchByProperties?cateid=1&page=1&color_id=1'" value="1" >Xanh</option>
                    <option href="${pageContext.request.contextPath }/product/searchByProperties?cate_id=${cate_id}&color_id=0'" value="1" >Tím</option>
                    <option  value="4" >Vàng</option>
                    <option  value="5" >Nâu</option>
                    <option  value="6" >Đen</option>
                    <option  value="7" >Hồng</option>
                </select>
            </div>
        </div>
    </section>
--%>
   <%-- <section  class="sky-form">
        <h4>Theo Size</h4>
        <div class="row row1 scroll-pane">
            <div class="col col-4">
                <select name="size" style="width: 50%">
                    <option  value="0" >All</option>
                    <option  value="1" >Size S</option>
                    <option  value="2" >Size M</option>
                    <option  value="3" >Size L</option>
                    <option  value="4" >Size XL</option>
                    <option  value="5" >Size 2XL</option>
                    <option  value="6" >Size 37</option>
                    <option  value="7" >Size 38</option>
                    <option  value="8" >Size 39</option>
                    <option  value="9" >Size 40</option>
                    <option  value="10" >Size 41</option>
                </select>
            </div>
        </div>
    </section>--%>
<<<<<<< HEAD
>>>>>>> Stashed changes
=======
>>>>>>> parent of 0dd74e8... load
    <section  class="sky-form">
        <h4>Theo Size</h4>
        <div class="row row1 scroll-pane">
            <div class="col col-4">
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=0&page=1">ALL</a></li>
<<<<<<< HEAD
<<<<<<< Updated upstream

                <c:forEach items="${sizeList}" var="size">
                    <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=${size.getSizeId()}&page=1">${size.getSizeName()}</a></li>
                </c:forEach>
=======
=======
>>>>>>> parent of 0dd74e8... load
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=1&page=1">Size S</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=2&page=1">Size M</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=3&page=1">Size L</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=4&page=1">Size XL</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=5&page=1">Size 2XL</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=6&page=1">Size 37</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=7&page=1">Size 38</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=8&page=1">Size 39</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=9&page=1">Size 40</a></li>
                <li><a style="color: black; font-size: larger; text-decoration : none;" href="${pageContext.request.contextPath }/product/searchByProperties?sizeid=10&page=1">Size 41</a></li>
<<<<<<< HEAD
>>>>>>> Stashed changes
=======
>>>>>>> parent of 0dd74e8... load
            </div>
        </div>
    </section>
</div>

