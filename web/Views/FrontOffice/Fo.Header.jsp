<%-- 
    Document   : Header
    Created on : Feb 18, 2022, 2:15:33 AM
    Author     : vinnie
--%>

<%@page import="Model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Nike Simple</title>
        <link rel="shortcut icon" type="image/png" sizes="16x16" href="${pageContext.servletContext.contextPath}/Views/Images/nike-logo.png"/>
        <%@include file="../CSS_Resources.jsp" %>
        <%@include file="Customer/Fo.CustomerModal.jsp" %>
        <link href="${pageContext.servletContext.contextPath}/StyleSheets/FrontOffice/Fo.Header.css" rel="stylesheet" type="text/css"/>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="pre" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="func" %>
    </head>

    <%
        if (session.getAttribute("customerId") != null) {
            request.setAttribute("customerLogin", new BusinessLogic.FrontOffice.Customer.BllFo_GetImage().businessLogic(new Customer().setUsername((String) session.getAttribute("username"))));
            request.setAttribute("cartCount", new BusinessLogic.FrontOffice.Customer.BllFo_GetCartCount().businessLogic(new Customer().setCustomerId((Integer) session.getAttribute("customerId"))));
        }
    %>

    <body>

        <!-------- Top Nav ------ -->
        <nav id="navbar_top" class="navbar navbar-expand-lg navbar-dark bg-primary sticky-top">
            <!-- Container wrapper -->
            <div class="container-fluid justify-content-end">
                <!-- Navbar brand -->
                <a class="navbar-brand" href="Fo.Home.jsp" style=""><div class="bb logo"></div></a>

                <!-- Avatar -->
                <div class="dropdown position-absolute">
                    <a
                        class="dropdown-toggle d-flex align-items-center hidden-arrow"
                        href="#"
                        id="navbarDropdownMenuAvatar"
                        role="button"
                        data-mdb-toggle="dropdown"
                        aria-expanded="false"
                        >
                        <pre:if test="${not empty customerLogin}"> 
                            <img
                                src="data:image/png;base64,${customerLogin[0].imageAsBase64}"
                                onerror="this.onerror=null;this.src='<%=request.getContextPath()%>/Views/Images/icon.png';"
                                class="rounded-circle"
                                height="38"
                                width="38"
                                alt="Profile Picture"
                                loading="lazy"
                                style="object-fit: cover;"
                                />
                        </pre:if> 
                        <i class="fas fa-angle-down ms-2 mt-1" style="color: white; font-size: 25px;"></i>
                    </a>
                    <ul
                        class="dropdown-menu dropdown-menu-end"
                        aria-labelledby="navbarDropdownMenuAvatar"
                        style="font-size: 16px;">
                        <li>
                            <a class="dropdown-item need-login" id="my-profile" href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Customer/Fo.CustomerView.jsp">
                                <span class="nav-link-alignment">My profile</span>
                                <i class="fas fa-user-circle"></i>
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item need-login" href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Order/Fo.OrderSummary.jsp">
                                <span class="nav-link-alignment">My Orders</span>
                                <i class="fas fa-boxes"></i>
                            </a>
                        </li>
                        <li>
                            <pre:if test="${empty customerLogin}">
                                <a class="dropdown-item login-link" href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Fo.CustRegLog.jsp">
                                    <span class="nav-link-alignment">Log In</span>
                                    <i class="fas fa-sign-in-alt"></i>
                                </a>
                            </pre:if>
                            <pre:if test="${not empty customerLogin}"> 
                                <a class="dropdown-item" href="#" data-mdb-toggle="modal" data-mdb-target="#logOut-modal">
                                    <span class="nav-link-alignment">Log Out</span>
                                    <i class="fas fa-sign-out-alt"></i>
                                </a>
                            </pre:if>
                        </li>
                    </ul>
                </div>


                <!-- Toggle button -->
                <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#navbarCenteredExample"
                    aria-controls="navbarCenteredExample"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                    style="padding: 0.9rem 0 0.9rem 0 ;"
                    >
                    <i class="fas fa-bars"></i>
                </button>

                <!-- Collapsible wrapper -->
                <div
                    class="collapse navbar-collapse justify-content-center"
                    id="navbarCenteredExample">
                    <!-- Left links -->
                    <ul class="navbar-nav mb-lg-0 text-center">
                        <li class="nav-item mx-5">
                            <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Fo.Home.jsp" class="nav-link active"><i class="fa fa-home pe-3"></i><span class="nav-link-alignment">Home</span></a>
                        </li>
                        <li class="nav-item mx-5">
                            <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Product/Fo.ProductSummary.jsp" class="nav-link"><i class="fa fa-camera pe-3"></i><span class="nav-link-alignment">Products</span></a>
                        </li>
                        <li class="nav-item mx-5">
                            <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Cart/Fo.CartSummary.jsp" class="nav-link need-login"><i class="fa fa-cart-arrow-down pe-3"></i>
                                <pre:if test="${not empty customerLogin}">
                                    <span class="badge rounded-pill badge-notification bg-info me-3" style="margin-top: -0.3rem;margin-left: -1.3rem; font-size: 13px;">
                                        ${cartCount[0].cartItemQty}</span>
                                    </pre:if>
                                <span class="nav-link-alignment">Cart</span>
                            </a>
                        </li>
                    </ul>
                    <!-- Left links -->
                </div>
                <!-- Collapsible wrapper -->
            </div>
            <!-- Container wrapper -->
        </nav>
    </body>
</html>
