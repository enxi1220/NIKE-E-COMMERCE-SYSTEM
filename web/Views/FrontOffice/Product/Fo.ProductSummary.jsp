<%--
    Document   : Fo.ProductSummary
    Created on : Feb 27, 2022, 2:11:51 AM
    Author     : vinnie chin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<%@page import="Model.Product"%>
<%
    request.setAttribute("products", new BusinessLogic.FrontOffice.Product.BllFo_GetFull().businessLogic(new Product()));

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nike Simple | All Products</title>
        <%@include file="../Fo.Header.jsp" %>
        <link href="${pageContext.servletContext.contextPath}/StyleSheets/FrontOffice/Product/Fo.ProductSummary.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-3">
                    <!-- Tab navs -->
                    <div class="nav flex-column nav-pills text-center justify-content-center ms-3"
                         id="v-pills-tab"
                         role="tablist"
                         aria-orientation="vertical"
                         style=" height: calc(100vh - 80px);">
                        <a class="nav-link active"
                           id="all-tab"
                           data-mdb-toggle="pill"
                           href="#all"
                           role="tab"
                           aria-controls="all"
                           aria-selected="true">All</a>
                        <a class="nav-link"
                           id="unisex-tab"
                           data-mdb-toggle="pill"
                           href="#unisex"
                           onclick="checkTabExist(this.href)"
                           role="tab"
                           aria-controls="unisex"
                           aria-selected="false">Unisex</a>
                        <a class="nav-link"
                           id="women-tab"
                           data-mdb-toggle="pill"
                           href="#women"
                           onclick="checkTabExist(this.href)"
                           role="tab"
                           aria-controls="women"
                           aria-selected="false">Women</a>
                        <a class="nav-link"
                           id="men-tab"
                           data-mdb-toggle="pill"
                           href="#men"
                           onclick="checkTabExist(this.href)"
                           role="tab"
                           aria-controls="men"
                           aria-selected="false">Men</a>
                        <a class="nav-link"
                           id="kids-tab"
                           data-mdb-toggle="pill"
                           href="#kids"
                           onclick="checkTabExist(this.href)"
                           role="tab"
                           aria-controls="kids"
                           aria-selected="false">Kids</a>
                    </div>
                    <!-- Tab navs -->
                </div>

                <div class="col-9">
                    <!-- Tab content -->
                    <div class="tab-content" id="v-pills-tabContent">
                        <div class="tab-pane fade show active"
                             id="all"
                             role="tabpanel"
                             aria-labelledby="all-tab">

                            <div class="container mt-3 pt-1">
                                <div class="row">
                                    <pre:forEach items="${products}" var="product">
                                        <div class="col-md-3">
                                            <div class="wsk-cp-product">
                                                <div class="wsk-cp-img">
                                                    <img src="data:image/png;base64,${product.productImage[0].imageAsBase64}" alt="Product" class="img-responsive" />
                                                </div>
                                                <div class="wsk-cp-text">
                                                    <div class="category">
                                                        <span><pre:out value="${product.category}" /></span>
                                                    </div>
                                                    <div class="title-product">
                                                        <h3><pre:out value="${product.productName}" /></h3>
                                                    </div>

                                                    <div class="card-footer">
                                                        <div class="wcf-left">
                                                            <span class="price">RM <fmt:formatNumber value="${product.price}" type="number" minFractionDigits="2"/></span>
                                                        </div>
                                                        <div class="wcf-right">
                                                            <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Product/Fo.ProductView.jsp?productId=${product.productId}" class="view-prod-btn"><span>More</span><i class="fas fa-chevron-circle-right ps-1"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </pre:forEach>
                                </div>
                            </div>
                        </div>


                        <div class="tab-pane fade"
                             id="unisex"
                             role="tabpanel"
                             aria-labelledby="unisex-tab">
                            <div class="container mt-3 pt-1">
                                <div class="row">
                                    <pre:forEach items="${products}" var="product">
                                        <pre:if test="${product.category == 'Unisex'}">
                                            <div class="col-md-3">
                                                <div class="wsk-cp-product">
                                                    <div class="wsk-cp-img">
                                                        <img src="data:image/png;base64,${product.productImage[0].imageAsBase64}" alt="Product" class="img-responsive" />
                                                    </div>
                                                    <div class="wsk-cp-text">
                                                        <div class="category">
                                                            <span>${product.category}</span>
                                                        </div>
                                                        <div class="title-product">
                                                            <h3>${product.productName}</h3>
                                                        </div>

                                                        <div class="card-footer">
                                                            <div class="wcf-left">
                                                                <span class="price">RM <fmt:formatNumber value="${product.price}" type="number" minFractionDigits="2"/></span>
                                                            </div>
                                                            <div class="wcf-right">
                                                                <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Product/Fo.ProductView.jsp?productId=${product.productId}" class="view-prod-btn"><span>More</span><i class="fas fa-chevron-circle-right ps-1"></i></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </pre:if>
                                    </pre:forEach>
                                </div> 
                            </div>
                        </div>

                        <div class="tab-pane fade"
                             id="women"
                             role="tabpanel"
                             aria-labelledby="women-tab">
                            <div class="container mt-3 pt-1">
                                <div class="row">
                                    <pre:forEach items="${products}" var="product">
                                        <pre:if test="${product.category == 'Women'}">
                                            <div class="col-md-3">
                                                <div class="wsk-cp-product">
                                                    <div class="wsk-cp-img">
                                                        <img src="data:image/png;base64,${product.productImage[0].imageAsBase64}" alt="Product" class="img-responsive" />
                                                    </div>
                                                    <div class="wsk-cp-text">
                                                        <div class="category">
                                                            <span>${product.category}</span>
                                                        </div>
                                                        <div class="title-product">
                                                            <h3>${product.productName}</h3>
                                                        </div>

                                                        <div class="card-footer">
                                                            <div class="wcf-left">
                                                                <span class="price">RM <fmt:formatNumber value="${product.price}" type="number" minFractionDigits="2"/></span>
                                                            </div>
                                                            <div class="wcf-right">
                                                                <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Product/Fo.ProductView.jsp?productId=${product.productId}" class="view-prod-btn"><span>More</span><i class="fas fa-chevron-circle-right ps-1"></i></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </pre:if>
                                    </pre:forEach>
                                </div> 
                            </div>
                        </div>
                        
                        <div class="tab-pane fade"
                             id="men"
                             role="tabpanel"
                             aria-labelledby="men-tab">
                            <div class="container mt-3 pt-1">
                                <div class="row">
                                    <pre:forEach items="${products}" var="product">
                                        <pre:if test="${product.category == 'Men'}">
                                            <div class="col-md-3">
                                                <div class="wsk-cp-product">
                                                    <div class="wsk-cp-img">
                                                        <img src="data:image/png;base64,${product.productImage[0].imageAsBase64}" alt="Product" class="img-responsive" />
                                                    </div>
                                                    <div class="wsk-cp-text">
                                                        <div class="category">
                                                            <span>${product.category}</span>
                                                        </div>
                                                        <div class="title-product">
                                                            <h3>${product.productName}</h3>
                                                        </div>

                                                        <div class="card-footer">
                                                            <div class="wcf-left">
                                                                <span class="price">RM <fmt:formatNumber value="${product.price}" type="number" minFractionDigits="2"/></span>
                                                            </div>
                                                            <div class="wcf-right">
                                                                <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Product/Fo.ProductView.jsp?productId=${product.productId}" class="view-prod-btn"><span>More</span><i class="fas fa-chevron-circle-right ps-1"></i></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </pre:if>
                                    </pre:forEach>
                                </div> 
                            </div>
                        </div>
                        
                         <div class="tab-pane fade"
                             id="kids"
                             role="tabpanel"
                             aria-labelledby="kids-tab">
                            <div class="container mt-3 pt-1">
                                <div class="row">
                                    <pre:forEach items="${products}" var="product">
                                        <pre:if test="${product.category == 'Kids'}">
                                            <div class="col-md-3">
                                                <div class="wsk-cp-product">
                                                    <div class="wsk-cp-img">
                                                        <img src="data:image/png;base64,${product.productImage[0].imageAsBase64}" alt="Product" class="img-responsive" />
                                                    </div>
                                                    <div class="wsk-cp-text">
                                                        <div class="category">
                                                            <span>${product.category}</span>
                                                        </div>
                                                        <div class="title-product">
                                                            <h3>${product.productName}</h3>
                                                        </div>

                                                        <div class="card-footer">
                                                            <div class="wcf-left">
                                                                <span class="price">RM <fmt:formatNumber value="${product.price}" type="number" minFractionDigits="2"/></span>
                                                            </div>
                                                            <div class="wcf-right">
                                                                <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Product/Fo.ProductView.jsp?productId=${product.productId}" class="view-prod-btn"><span>More</span><i class="fas fa-chevron-circle-right ps-1"></i></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </pre:if>
                                    </pre:forEach>
                                </div> 
                            </div>
                        </div>

                        <!--no content-->
                        <div class="tab-pane fade"
                             id="no-content"
                             role="tabpanel"
                             >
                            <div class="container mt-5 pt-5 text-center">
                                <div class="row mt-5 pt-5">
                                    <h3>No products available for this category for now...</h3>
                                    <br/><br/><br/>
                                    <h1>Coming Soon</h1>
                                </div>
                            </div>
                        </div>
                        <!--no content-->


                    </div>
                </div>
                <!-- Tab content -->
            </div>
        </div>

        <%@include file="../Fo.Footer.jsp" %>

        <script>

            function checkTabExist(id)
            {
                var strFine = id.substring(id.lastIndexOf('#'));
                if ($(strFine).children().children().children().length) {
                    $('#no-content').removeClass("show active");
                } else {
                    $('strFine').removeClass("show active");
                    $('#no-content').addClass("show active");
                }
            }

        </script>

    </body>
</html>
