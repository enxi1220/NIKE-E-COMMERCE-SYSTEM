<%-- 
    Document   : Header
    Created on : Mar 22, 2022, 4:12:17 PM
    Author     : Tan Lin Yi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title> Nike - Back Office</title>
        <link rel="shortcut icon" type="image/png" sizes="16x16" href="${pageContext.servletContext.contextPath}/Views/Images/nike-logo.png"/>
        <!-- Custom fonts for this template-->
        <link href="${pageContext.servletContext.contextPath}/Library/Bootstrap5/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <%
        if(session.getAttribute("username") == null){
            response.setStatus(500);
            throw new Exception("Please Login First");
        }
        %>
        <%
                      request.setAttribute("username", session.getAttribute("username"));
        %>
        <!-- Custom styles for this template-->
        <link href="${pageContext.servletContext.contextPath}/StyleSheets/BackOffice/header.css" rel="stylesheet" type="text/css"/>
        <%@include file="../CSS_Resources.jsp" %>
        <%@include file="User/Bo.UserComfirm.jsp"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="pre" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="func" %>

    </head>
    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand --> 
                <a class="sidebar-brand d-flex align-items-center justify-content-center">
                    <div class="sidebar-brand-icon rotate-n-12">
                        <img class="nike-logo" src="${pageContext.servletContext.contextPath}/Views/Images/nike-logo.png">
                    </div>
                    <div class="sidebar-brand-text mx-3">Nike </div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/Views/BackOffice/Bo.Dashboard.jsp">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Interface
                </div>
                <!-- Nav Item - User -->
                <li class="nav-item">   
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/Views/BackOffice/User/Bo.UserSummary.jsp">
                        <i class="fas fa-user-alt fa-fw me-3"></i>
                        <span>User</span></a>
                </li>
                <!-- Nav Item - Product -->
                <li class="nav-item">    
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/Views/BackOffice/Product/Bo.ProductSummary.jsp">
                        <i class="fas fa-shopping-bag fa-fw me-3"></i>
                        <span>Product</span></a>
                </li>
                <!-- Nav Item - Sales -->
                <li class="nav-item">    
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/Views/BackOffice/Bo.Sales.jsp">
                        <i class="fas fa-chart-line fa-fw me-3"></i>
                        <span>Sales</span></a>
                </li>
                <!-- Nav Item - Report -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                       aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-file-alt fa-fw me-3"></i>
                        <span>Report</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Components:</h6>
                            <a class="collapse-item" href="${pageContext.servletContext.contextPath}/Views/BackOffice/Report/Bo.StockReport.jsp">Stock Report</a>
                            <a class="collapse-item" href="${pageContext.servletContext.contextPath}/Views/BackOffice/Report/Bo.SalesReport.jsp">Sales Report</a>
                            <a class="collapse-item" href="${pageContext.servletContext.contextPath}/Views/BackOffice/Report/Bo.ReorderReport.jsp">Restock Report</a>
                        </div>
                    </div>

                </li>
                <!-- Nav Item - Order -->
                <li class="nav-item">    
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/Views/BackOffice/Order/Bo.OrderSummary.jsp">
                        <i class="fas fa-cube fa-fw me-3"></i>
                        <span>Order</span></a>
                </li>
                <!-- Nav Item - Payment -->
                <li class="nav-item">    
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/Views/BackOffice/Payment/Bo.PaymentSummary.jsp">
                        <i class="far fa-credit-card fa-fw me-3"></i>
                        <span>Payment</span></a>
                </li>
                <!-- Nav Item - Customer -->
                <li class="nav-item">    
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/Views/BackOffice/Customer/Bo.CustomerSummary.jsp">
                        <i class="fas fa-users fa-fw me-3"></i>
                        <span>Customer</span></a>
                </li>
                <!-- Nav Item - Courier -->
                <li class="nav-item">    
                    <a class="nav-link" href="${pageContext.servletContext.contextPath}/Views/BackOffice/Courier/Bo.CourierSummary.jsp">
                        <i class="fas fa-truck fa-fw me-3"></i>
                        <span>Courier</span></a>
                </li>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <div>
                            <img class="nike-slogan ml-2" src="${pageContext.servletContext.contextPath}/Views/Images/NikeSlogan.png">
                        </div>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Facebook -->
                            <a class="mt-4 mb-4 mx-2" href="https://www.facebook.com/nike" role="button">
                                <i class="fab fa-facebook"></i>
                            </a>

                            <!-- Instagram -->
                            <a class="mt-4 mb-4 mx-2" href="https://www.instagram.com/nike/" role="button">
                                <i class="fab fa-instagram"></i>
                            </a>

                            <!-- Twitter -->
                            <a class="mt-4 mb-4 mx-2" href="https://twitter.com/Nike" role="button">
                                <i class="fab fa-twitter"></i>
                            </a>

                            <!-- Youtube -->
                            <a class="mt-4 mb-4 mx-2" href="https://www.youtube.com/user/nike" role="button">
                                <i class="fab fa-youtube"></i>
                            </a>

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">${username}</span>
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="userDropdown">
                                   
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal" onclick="bouserLogout()">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>

                            </li>

                        </ul>

                    </nav>

                    <main>

                    </main>
                    <!--Main layout-->
                </div>

                </body>
                </html>
