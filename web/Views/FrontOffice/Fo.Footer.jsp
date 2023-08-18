<%-- 
    Document   : Fo.Footer.jsp
    Created on : Mar 23, 2022, 3:39:30 PM
    Author     : vinnie chin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="${pageContext.servletContext.contextPath}/StyleSheets/FrontOffice/Fo.Footer.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <!--------------------------- Footer --------------------------->
    <footer class="text-center text-lg-start bg-dark home-footer mt-5">
        <!-- Section: Social media -->
        <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom ">
            <!-- Left -->
            <div class="me-5 d-none d-lg-block" style="padding-top: 10px;">
                <span class="mx-auto">Get connected with us on social networks:</span>
            </div>
            <!-- Left -->
            <!-- Right -->
            <div class="footer-social-icon">
                <a class="btn btn-outline-light btn-floating m-1" href="mailto:nike.ecommerce.vclx@gmail.com?&subject=Asking%20for%20Account%20Deactivated%20&body=Hi,%0d%0dI%20would%20like%20to%20ask:%0d%0d%0d(This%20is%20default%20subject%20and%20content,%20kindly%20change%20it%20if%20you%20have%20other%20questions.)%0d%0d%0d%0d%0d" role="button"
                   data-mdb-toggle="tooltip" data-mdb-placement="top" title="Email">
                    <i class="far fa-envelope"></i>
                </a>

                <!-- Facebook -->
                <a class="btn btn-outline-light btn-floating m-1" href="https://www.facebook.com/nike" role="button"
                    data-mdb-toggle="tooltip" data-mdb-placement="top" title="Facebook">
                    <i class="fab fa-facebook-f"></i>
                </a>

                <!-- Instagram -->
                <a class="btn btn-outline-light btn-floating m-1" href="https://www.instagram.com/nike/" role="button"
                    data-mdb-toggle="tooltip" data-mdb-placement="top" title="Instagram">
                    <i class="fab fa-instagram"></i>
                </a>

                <!-- Twitter -->
                <a class="btn btn-outline-light btn-floating m-1" href="https://twitter.com/Nike" role="button"
                    data-mdb-toggle="tooltip" data-mdb-placement="top" title="Twitter">
                    <i class="fab fa-twitter"></i>
                </a>

                <!-- Youtube -->
                <a class="btn btn-outline-light btn-floating m-1" href="https://www.youtube.com/user/nike" role="button"
                    data-mdb-toggle="tooltip" data-mdb-placement="top" title="Youtube">
                    <i class="fab fa-youtube"></i>
                </a>





            </div>
            <!-- Right -->
        </section>
        <!-- Section: Social media -->
        <!-- Section: Links  -->
        <section class="">
            <div class="container text-center text-md-start mt-5">
                <!-- Grid row -->
                <div class="row mt-2">
                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-3">
                        <!-- Content -->
                        <h6 class="text-uppercase fw-bold mb-3">
                            <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Fo.Home.jsp" class="text-reset">
                            <i class="fa fa-building me-3"></i>NIKE E-COMMERCE
                            </a>
                        </h6>
                        <p>
                           Simple E-Commerce website made by :
                        </p>
                        
                    </div>
                    <!-- Grid column -->
                    <!-- Grid column -->
                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-3">
                        <!-- Links -->

                        <h6 class="text-uppercase fw-bold mb-3">
                            Developers
                        </h6>
                        <p>En Xi <br/>Lin Yi<br/>Alvin<br/>Jun Yuan<br/>Vinnie</p>
                    </div>
                    <!-- Grid column -->
                    
                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-3">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-3">
                            General
                        </h6>
                        <p>
                            <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Fo.Home.jsp" class="text-reset">Home</a>
                        </p>
                        <p>
                             <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Product/Fo.ProductSummary.jsp" class="text-reset">Products</a>
                        </p>
                        
                        <p>
                            <pre:if test="${empty customerLogin}">
                                <a class="text-reset login-link" href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Fo.CustRegLog.jsp">
                                   Log In
                                </a>
                            </pre:if>
                            <pre:if test="${not empty customerLogin}"> 
                                <a class="text-reset" href="#" data-mdb-toggle="modal" data-mdb-target="#logOut-modal">
                                   Log Out
                                </a>
                            </pre:if>
                        </p>
                           
                    </div>
                    
                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-3">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-3">
                            Personal
                        </h6>
                        <p>
                            <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Cart/Fo.CartSummary.jsp" class="text-reset need-login">
                                Cart
                            </a>
                        </p>
                        <p>
                            <a class="text-reset need-login" href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Order/Fo.OrderSummary.jsp">
                                My Orders
                            </a>
                        </p>
                        <p>
                            <a class="text-reset need-login" href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Customer/Fo.CustomerView.jsp">
                                My profile
                            </a>
                        </p>

                    </div>
                    <!-- Grid column -->
                    <!-- Grid column -->
                    <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-3">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-3">
                            Contact
                        </h6>
                        <p>
                            <a href="mailto:nike.ecommerce.vclx@gmail.com?&subject=Asking%20for%20Account%20Deactivated%20/%20Order Problem%20&body=Hi,%0d%0dI%20would%20like%20to%20ask:%0d%0d%0d(This%20is%20default%20subject%20and%20content,%20kindly%20change%20it%20if%20you%20have%20other%20questions.)%0d%0d%0d%0d%0d" rel="Email" title="Contact Us" class="text-reset" id="contact-us-link"
                                data-mdb-toggle="tooltip" data-mdb-placement="top" title="Contact us">
                            <i class="fas fa-envelope me-3"></i>
                            nike.ecommerce.vclx@gmail.com
                            </a>
                        </p>
                        <p><i class="fas fa-phone me-3"></i> + 012 669 0313</p>

                    </div>
                    <!-- Grid column -->
                </div>
                <!-- Grid row -->
            </div>
        </section>
        <!-- Section: Links  -->
        <!-- Copyright -->
        <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
            © 2022 Copyright: Y2S3_NIKE-ECOMMERCE
        </div>
        <!-- Copyright -->
    </footer>
    <!-- Footer -->
        <%@include file="../JS_Resources.jsp" %>
        
        
    </body>
</html>
