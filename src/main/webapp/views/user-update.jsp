<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 16.11.2023
  Time: 02:33
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title> User Update </title>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<c:url value="/resources/init/plugins/fontawesome-free/css/all.min.css"/>">
    <!-- DataTables -->
    <link rel="stylesheet" href="<c:url value="/resources/init/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/init/plugins/datatables-responsive/css/responsive.bootstrap4.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/init/plugins/datatables-buttons/css/buttons.bootstrap4.min.css"/>">
    <!-- Theme style -->
    <link rel="stylesheet" href="<c:url value="/resources/init/dist/css/adminlte.min.css"/>">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Home</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Contact</a>
            </li>
        </ul>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <!-- Navbar Search -->
            <li class="nav-item">
                <a class="nav-link" data-widget="navbar-search" href="#" role="button">
                    <i class="fas fa-search"></i>
                </a>
                <div class="navbar-search-block">
                    <form class="form-inline">
                        <div class="input-group input-group-sm">
                            <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                            <div class="input-group-append">
                                <button class="btn btn-navbar" type="submit">
                                    <i class="fas fa-search"></i>
                                </button>
                                <button class="btn btn-navbar" type="button" data-widget="navbar-search">
                                    <i class="fas fa-times"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </li>

            <!-- Messages Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-comments"></i>
                    <span class="badge badge-danger navbar-badge">3</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="#" alt="User Avatar" class="img-size-50 mr-3 img-circle">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Brad Diesel
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">Call me whenever you can...</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="#" alt="User Avatar" class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    John Pierce
                                    <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">I got your message bro</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="#" alt="User Avatar" class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nora Silvester
                                    <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">The subject goes here</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
                </div>
            </li>
            <!-- Notifications Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-bell"></i>
                    <span class="badge badge-warning navbar-badge">15</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <span class="dropdown-item dropdown-header">15 Notifications</span>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-envelope mr-2"></i> 4 new messages
                        <span class="float-right text-muted text-sm">3 mins</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-users mr-2"></i> 8 friend requests
                        <span class="float-right text-muted text-sm">12 hours</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-file mr-2"></i> 3 new reports
                        <span class="float-right text-muted text-sm">2 days</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                    <i class="fas fa-expand-arrows-alt"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                    <i class="fas fa-th-large"></i>
                </a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="#" class="brand-link">
            <img src="#" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
            <span class="brand-text font-weight-light">AdminLTE 3</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="#" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="#" class="d-block">Alexander Pierce</a>
                </div>
            </div>

            <!-- SidebarSearch Form -->
            <div class="form-inline">
                <div class="input-group" data-widget="sidebar-search">
                    <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
                    <div class="input-group-append">
                        <button class="btn btn-sidebar">
                            <i class="fas fa-search fa-fw"></i>
                        </button>
                    </div>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item menu-open">
                        <a href="<%=request.getContextPath()%>/dashboard/data" class= "nav-link ">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                User Update
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/category/findCategory"  class="nav-link ">
                            <i class="nav-icon fas fa-book"></i>
                            <p>Catalog</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/product/findProduct" class="nav-link">
                            <i class="nav-icon fas fa-columns"></i>
                            <p>Product</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/bill/findBill>" class="nav-link">
                            <i class="nav-icon fas fa-copy"></i>
                            <p>Bill</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/image/findImage" class="nav-link">
                            <i class="nav-icon far fa-image"></i>
                            <p>Image</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/user/findUser" class="nav-link active">
                            <i class="nav-icon fas fa-users"></i>
                            <p>User</p>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1> User Update</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active"> User Update</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title">User</h3>
                            <div class="card-tools">
                                <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                                    <i class="fas fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="card-body">
                            <form action="<%=request.getContextPath()%>/userManage/update" method="post">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="accId">Acc ID</label>
                                            <input type="text" id="accId" readonly name="accId" value="${accountUpdate.accId}" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input type="text" id="email" readonly name="email" value="${accountUpdate.email}" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label for="userName">User Name</label>
                                            <input type="text" id="userName" readonly name="userName" value="${accountUpdate.userName}" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label for="password">Password</label>
                                            <input type="text" id="password" name="password" value="${accountUpdate.password}" class="form-control">
                                        </div>

                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="created">Day</label>
                                            <input type="date" readonly id="created" name="created" value="${accountUpdate.created}" class="form-control">

                                        </div>
                                        <div class="form-group">
                                            <label for="role">Role</label>
                                            <select id="role" name="role" value="${accountUpdate.role}" class="form-control custom-select">
                                                <option disabled>Select one</option>
                                                <option value="true" ${accountUpdate.role?"selected":""}>Admin</option>
                                                <option value="false" ${accountUpdate.role?"":"selected"}>Khách Hàng</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="accStatus">accStatus</label>
                                            <select id="accStatus" name="accStatus" value="${accountUpdate.accStatus}" class="form-control custom-select">
                                                <option disabled>Select one</option>
                                                <option value="true" ${accountUpdate.accStatus?"selected":""}>Active</option>
                                                <option value="false" ${accountUpdate.accStatus?"":"selected"}>Inactive</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <a href="<%=request.getContextPath()%>/userManage/findUser" class="btn btn-secondary">Cancel</a>
                                    <input type="submit" value="Save Changes" class="btn btn-success float-right"/>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- /.card-body -->
                </div>
                <!-- /.card -->
            </div>
     </section>
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
            <b>Version</b> 3.1.0
        </div>
        <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<!-- Button trigger modal -->

<!-- Modal -->


<!-- jQuery -->
<script src="../resources/init/plugins/jquery/jquery.min.js"></script>
<%--<!-- Bootstrap 4 -->--%>
<script src="../resources/js/category.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<%--<script type="text/javascript">--%>
<%--    $(".page-category").click(function () {--%>
<%--        let pageId = $(this).attr("pageId")--%>
<%--        let This = $(this)--%>
<%--        $.ajax({--%>
<%--            type: "GET",--%>
<%--            url: "http://localhost:8080/category/findCategory?page="+pageId,--%>
<%--            // data: { name: "John", location: "Boston" }--%>
<%--        }).done(function() {--%>
<%--            window.location = "http://localhost:8080/category/findCategory?page="+pageId--%>
<%--        });--%>
<%--    })--%>
<%--</script>--%>
<%--<!-- DataTables  & Plugins -->--%>
<%--<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>--%>
<%--<script src="../../plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>--%>
<%--<script src="../../plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>--%>
<%--<script src="../../plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>--%>
<%--<script src="../../plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>--%>
<%--<script src="../../plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>--%>
<%--<script src="../../plugins/jszip/jszip.min.js"></script>--%>
<%--<script src="../../plugins/pdfmake/pdfmake.min.js"></script>--%>
<%--<script src="../../plugins/pdfmake/vfs_fonts.js"></script>--%>
<%--<script src="../../plugins/datatables-buttons/js/buttons.html5.min.js"></script>--%>
<%--<script src="../../plugins/datatables-buttons/js/buttons.print.min.js"></script>--%>
<%--<script src="../../plugins/datatables-buttons/js/buttons.colVis.min.js"></script>--%>
<%--<!-- AdminLTE App -->--%>
<%--<script src="../../dist/js/adminlte.min.js"></script>--%>
<%--<!-- AdminLTE for demo purposes -->--%>
<%--<script src="../../dist/js/demo.js"></script>--%>
<%--<!-- Page specific script -->--%>
<%--<script>--%>
<%--    $(function () {--%>
<%--        $("#example1").DataTable({--%>
<%--            "responsive": true, "lengthChange": false, "autoWidth": false,--%>
<%--            "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]--%>
<%--        }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');--%>
<%--        $('#example2').DataTable({--%>
<%--            "paging": true,--%>
<%--            "lengthChange": false,--%>
<%--            "searching": false,--%>
<%--            "ordering": true,--%>
<%--            "info": true,--%>
<%--            "autoWidth": false,--%>
<%--            "responsive": true,--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
</body>
</html>
