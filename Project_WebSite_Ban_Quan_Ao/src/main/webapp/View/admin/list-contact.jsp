<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/View/admin/Static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Order Management</title>
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
                    <h2>Contact Management</h2>


                </div>
            </div>
            <!-- /. ROW  -->
            <hr />

            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">Advanced Tables</div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover"
                                       id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>index</th>
                                        <th>Name</th>
                                        <th>Mobile</th>
                                        <th>Email</th>
                                        <th>Subject</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </a>
                                    <c:set var="index" value="${0}" />
                                    <c:forEach items="${contactEntityList }" var="list">
                                        <c:if test="${list.status !=-1}">
                                            <tr class="odd gradeX">
                                                <c:set var="index" value="${index + 1}" />
                                                <td>${index }</td>
                                                <td>${list.name}</td>
                                                <td>${list.mobile}</td>

                                                <td>${list.email}</td>
                                                <td>${list.subject}</td>
                                                <td>
                                                    <c:if test="${list.status ==0}">Đang chờ xử lý</c:if>
                                                    <c:if test="${list.status ==1}">Đã xử lý</c:if>
                                                </td>
                                                <td><a
                                                        href="<c:url value='/admin/contact/update?id=${list.id }&value=1'/>"
                                                        class="center">Duyệt
                                                    </a> |
                                                    <a href="<c:url value='/admin/contact/update?id=${list.id }&value=0'/>"
                                                        class="center">Chờ
                                                    </a> |
                                                    <a  href="<c:url value='/admin/contact/update?id=${list.id }&value=-1'/>"
                                                        class="center">Xoá
                                                    </a>
                                                </td>


                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>

        </div>

    </div>
    <!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->
<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="${url}/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="${url}/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="${url}/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="${url}/js/dataTables/jquery.dataTables.js"></script>
<script src="${url}/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable();
    });
</script>
<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>

</body>
</html>