<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<c:url value="/View/admin/Static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="<c:url value="/ckeditor/ckeditor.js" />"></script>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Addition Product</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="${url}/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="${url}/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLES-->
    <link href="${url}/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans'
          rel='stylesheet' type='text/css' />
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
                    <h2>Edit OPTION</h2>
                    <h5>Edit the SKU of product</h5>
                </div>
            </div>
            <!-- /. ROW  -->
            <hr />
            <div class="row">
                <div class="col-md-12">
                    <!-- Form Elements -->
                    <div class="panel panel-default">
                        <div class="panel-heading">Add Product</div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <h3>Product's Option:</h3>
                                    <form role="form" action="${edit }" method="post"
                                          enctype="multipart/form-data">
                                        <input name="id" value="${sku.skuId }" hidden="">
<%--                                        <input name="product" value="${sku.getProductEntity().getName()}" hidden="">--%>
                                        <div class="form-group">
                                            <label>Product:</label> <input class="form-control"
                                                                        value="${prod.id }" name="product" />
                                        </div>


                                        <div class="form-group">
                                            <label>Colors</label>
                                            <div class="checkbox">
                                                <select name="color" }>

                                                    <c:forEach items="${colors}" var="color">
                                                        <option value="${color.getColorId()}">${color.getColorName()}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>

                                        </div>
                                        <div class="form-group">
                                            <label>Sizes</label>
                                            <div class="checkbox">
                                                <select name="size">
                                                    <c:forEach items="${sizes}" var="size">
                                                        <option value="${size.getSizeId()}">${size.getSizeName()}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>

                                        </div>
                                        <div class="form-group">
                                            <label>Quantity</label> <input class="form-control"
                                                                            value="${sku.getQuantity() }" type="number" name="quantity" />
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
<script type="text/javascript" language="javascript">
    CKEDITOR.replace('editer', {width: '700px',height: '300px'});
</script>
</body>
</html>