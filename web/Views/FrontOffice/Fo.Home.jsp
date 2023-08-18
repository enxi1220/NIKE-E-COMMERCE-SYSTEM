<%--
    Document   : Fo.Home.jsp
    Created on : Feb 16, 2022, 6:18:08 PM
    Author     : vinnie
--%>

<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setAttribute("bestSalesProducts", new BusinessLogic.FrontOffice.Product.BllFo_GetBestSales().businessLogic(new Product()));
    request.setAttribute("latestProducts", new BusinessLogic.FrontOffice.Product.BllFo_GetLatest().businessLogic(new Product()));
    request.setAttribute("featuredProducts", new BusinessLogic.FrontOffice.Product.BllFo_GetFeatured().businessLogic(new Product()));


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nike Simple | Home</title>
        <%@include file="Fo.Header.jsp" %>
        <!--------------------------- Product Slider CSS--------------------------->
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,400,700&subset=latin-ext" rel="stylesheet"/>
        
        <!--------------------------- Product Sliders CSS--------------------------->
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"
              integrity="sha512-tS3S5qG0BlhnQROyJXvNjeEM4UpMXHrQfTGmbQ1gKmelCxlSEBUaxhRBj/EFTzpbP4RVSrpEikbmdJobCvhE3g=="
              crossorigin="anonymous" />
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css"
              integrity="sha512-sMXtMNL1zRzolHYKEujM2AqCLUR9F2C4/05cdbxjjLSRvMQIciEPCQZo++nk7go3BtSuK9kfa/s+a4f4i5pLkw=="
              crossorigin="anonymous" />
        
        <!--------------------------- Home CSS --------------------------->
        <link href="${pageContext.servletContext.contextPath}/StyleSheets/FrontOffice/Fo.Home.css" rel="stylesheet" type="text/css" />

    </head>

    <body>
        <div id="carouselExampleIndicators" class="carousel slide home_big_slide" data-mdb-ride="carousel">
            <div class="carousel-indicators">
                <button type="button"
                        data-mdb-target="#carouselExampleIndicators"
                        data-mdb-slide-to="0"
                        class="active"
                        aria-current="true"
                        aria-label="Slide 1"></button>
                <button type="button"
                        data-mdb-target="#carouselExampleIndicators"
                        data-mdb-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button"
                        data-mdb-target="#carouselExampleIndicators"
                        data-mdb-slide-to="2"
                        aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active bg-image">
                    <img src="../Images/slide1.jpg" class="d-block w-100" alt="Camera" />
                    <div class="mask" style="background-color: rgba(0, 0, 0, 0.3)"></div>
                </div>
                <div class="carousel-item bg-image">
                    <img src="../Images/slide2.jpg" class="d-block w-100" alt="Camera" />
                    <div class="mask" style="background-color: rgba(0, 0, 0, 0.3)"></div>
                </div>
                <div class="carousel-item bg-image">
                    <img src="../Images/slide3.jpg" class="d-block w-100" alt="Exotic Fruits" />
                    <div class="mask" style="background-color: rgba(0, 0, 0, 0.3)"></div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-mdb-target="#carouselExampleIndicators" data-mdb-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-mdb-target="#carouselExampleIndicators" data-mdb-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

        <!--------------------------- Product Slider 1--------------------------->
        
        <div class="container pb-5 border-bottom">
            <h2 class="mt-5 mb-3">Best Selling</h2>
            <div class="col-12 m-auto">
                <!--  <div class="carousel-wrap">-->
                <div class="owl-carousel owl-theme" id="bestSales">
                    <pre:forEach items="${bestSalesProducts}" var="bestSalesProduct">
                        <div class="item">
                            <div class="bg-image hover-zoom">
                                <div class="bg-image rounded-6">
                                    <img
                                        src="data:image/png;base64,${bestSalesProduct.productImage[0].imageAsBase64}"
                                        class="w-100"
                                        alt="best selling products image"
                                        style="width: 100px; height: 380px; object-fit: cover;"/>
                                    <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Product/Fo.ProductView.jsp?productId=${bestSalesProduct.productId}">
                                        <!-- Mask -->
                                        <div class="mask" style="background: linear-gradient(to bottom, hsla(0, 0%, 0%, 0), hsla(0, 0%, 0%, 0.5));">
                                            <div class="bottom-0 d-flex align-items-end h-100 text-center justify-content-center">
                                                <div>
                                                    <h3 class="text-light mb-4">${bestSalesProduct.productName}</h3>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </pre:forEach>
                </div>
            </div>
        </div>

        <!--------------------------- Product Slider 2--------------------------->

        <div class="container latest-collection-container pb-5 border-bottom">
            <h2 class="mt-5 mb-3">Latest Collection</h2>
            <div class="col-12 m-auto">
                <!--  <div class="carousel-wrap">-->
                <div class="owl-carousel owl-theme" id="latest-collection">

                    <pre:forEach items="${latestProducts}" var="latestProduct">
                        <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Product/Fo.ProductView.jsp?productId=${latestProduct.productId}">
                            <div class="item mb-4 card border-0 shadow">
                                <div class="bg-image hover-zoom">
                                    <img src="data:image/png;base64,${latestProduct.productImage[0].imageAsBase64}" alt="" class="card-img-top">
                                </div>
                                <div class="card-body">
                                    <div class="card-title text-center text-wrap">
                                        <h4>${latestProduct.productName}</h4>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </pre:forEach>
                </div>
            </div>
        </div>
        
        <!--------------------------- Product Slider 3 --------------------------->

        <div class="container featured-container">
             <h2 class="mt-5 mb-3">Featured</h2>
            <div class="col-12 m-auto">
                <div class="owl-carousel owl-theme" id="featured">
                    <pre:forEach items="${featuredProducts}" var="featuredProduct">
                        <div class="item mb-4" >
                            <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Product/Fo.ProductView.jsp?productId=${featuredProduct.productId}">
                                <div class="card border-0 shadow">
                                    <img src="data:image/png;base64,${featuredProduct.productImage[0].imageAsBase64}" alt="" class="card-img-top">
                                </div>
                                <div class="card-body bg-dark">
                                    <div class="card-title text-center">
                                        <h4>${featuredProduct.productName}</h4>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </pre:forEach>
                </div>
            </div>
        </div>

        <%@include file="Fo.Footer.jsp" %>

        <!--------------------------- End of HOME --------------------------->

        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"
                integrity="sha512-bPs7Ae6pVvhOSiIcyUClR7/q2OAsRiovw4vAkX+zJbw3ShAeeqezq50RIIcIURq7Oa20rW2n2q+fyXBNcU9lrw=="
        crossorigin="anonymous"></script>

        <script src="<%=request.getContextPath()%>/Scripts/FrontOffice/Fo.Home.js" type="text/javascript"></script>

    </body>
</html>
