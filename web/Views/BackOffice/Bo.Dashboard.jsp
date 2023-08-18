<%-- 
    Document   : Bo.Dashboard
    Created on : Mar 22, 2022, 1:10:37 PM
    Author     : Tan Lin Yi
--%>
<%@page import="Model.Report"%>
<%@page import="Model.ProductDetail"%>
<%@page import="Model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Dashboard"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            request.setAttribute("dashboards", new BusinessLogic.BackOffice.Dashboard.BllBo_Get().businessLogic(new Dashboard()));
            request.setAttribute("dashboardpayments", new BusinessLogic.BackOffice.Dashboard.BllBo_GetPayment().businessLogic(new Dashboard()));
            request.setAttribute("reports", new BusinessLogic.BackOffice.SalesReport.BllBo_Get().businessLogic(new Report()));
            request.setAttribute("products", new BusinessLogic.BackOffice.ReorderReport.BllBo_GetFull().businessLogic(new Product()));
        %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Nike Office | Dashboard</title>

        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <%@include file="Bo.HeaderANDNav.jsp"%>
    </head>
    <body> 

        <!-- Begin Page Content -->
        <div class="container-fluid" ml-4 p1-4>

            <!-- Content Row   -->
            <div class="row" >

                <!-- Earnings (Monthly) Card Example -->
                <div class="col-xl-4 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                        Daily Earnings </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800"><fmt:formatNumber value="${dashboardpayments[0].price}" type="number" minFractionDigits="2"/></div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Earnings (Monthly) Card Example -->
                <div class="col-xl-4 col-md-6 mb-4">
                    <div class="card border-left-info shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Daily Order
                                    </div>
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-auto">
                                            <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"><pre:out value="${dashboardpayments[0].sumOrder}" /></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <!-- Pending Requests Card Example -->
                <div class="col-xl-4 col-md-6 mb-4">

                    <div class="card border-left-warning shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                        Daily Customer Register</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800"><pre:out value="${dashboards[0].sumCustomer}" />
                                    </div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-comments fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>   
                </div>
            </div>

            <!-- Content Row -->

            <div class="row">
                <div class="col-xl-6 col-lg-6">
                    <div class="card shadow mb-4">
                        <div
                            class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                            <h6 class="m-0 font-weight-bold text-primary">Tight Inventory</h6>
                        </div>
                        <pre:forEach items="${products}" var="product"> 
                            <pre:forEach items="${product.productDetail}" var="productDetail"> 
                                <!-- Card Body -->
                                <div class="card-body">
                                    <h4 class="small font-weight-bold mb-4">
                                        <pre:out value="${product.productNo}" />
                                        <span class="float-right">
                                            <a href="${pageContext.servletContext.contextPath}/Views/BackOffice/Product/Bo.ProductView.jsp?productId=${product.productId}">View
                                            </a>
                                        </span>
                                    </h4>
                                </div>
                            </pre:forEach>
                        </pre:forEach>
                    </div>
                </div>


                <!-- Content Column -->
                <div class="col-lg-5 mb-4 ">
                    <!-- Project Card Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Product Category Sales</h6>
                        </div>
                        <pre:forEach items="${reports}" var="report"> 
                            <div class="card-body">

                                <h4 class="small font-weight-bold"><pre:out value="${report.product.category}"/>
                                    <span
                                        class="float-right"><pre:out value="${report.salesOutQTY}"/>
                                    </span>
                                </h4>
                                <div class="progress mb-4">
                                    <div class="progress-bar bg-danger" role="progressbar"
                                         aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </pre:forEach>
                    </div>
                </div>
            </div>
        </div>

        <!-- /.container-fluid -->
        <%@include file="Bo.Footer.jsp" %>
        <script src="../../Scripts/BackOffice/Dashboard/Bo.Dashboard.js" type="text/javascript"></script>
        <!-- End of Main Content -->
    </body>
</html>        
