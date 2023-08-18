<%--
    Document   : Fo.ProductView
    Created on : Feb 27, 2022, 3:13:25 AM
    Author     : vinnie chin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Model.Product, Model.ProductDetail"%>
<%@page import="java.util.ArrayList"%>

<%
    request.setAttribute("product", new BusinessLogic.FrontOffice.Product.BllFo_Get().businessLogic(new Product().setProductId(Integer.parseInt(request.getParameter("productId")))));

    ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("product");

    request.setAttribute("relatedProducts", new BusinessLogic.FrontOffice.Product.BllFo_GetRelated().businessLogic(new Product()
            .setProductId(Integer.parseInt(request.getParameter("productId")))
            .setCategory(products.get(0).getCategory())
            .setPrice(products.get(0).getPrice())
    )
    );


%>


<%--<jsp:useBean id="product" class="Model.Product" scope="session"/>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nike Simple | Product Details</title>      
        <%@include file="../Fo.Header.jsp" %>
        <link href="${pageContext.servletContext.contextPath}/StyleSheets/FrontOffice/Product/Fo.ProductView.css" rel="stylesheet" type="text/css" />

    </head>
    <body>
        <!------------------- Outer Container ------------------->
        <div class="container p-3 bg-white mt-3">
            <!------------- Small Nav ------------->


            <nav class="navbar navbar-expand-lg mb-3">
                <div class="container-fluid px-3">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb text-muted">
                            <li class="breadcrumb-item">Product</li>
                            <li class="breadcrumb-item">${product[0].category}</li>
                            <li class="breadcrumb-item active" aria-current="page">${product[0].productName}</li>
                        </ol>
                    </nav>
                </div>
            </nav>
            <!------------- Small Nav ------------->

            <!------------- 1st Inner Container ------------->
            <div class="row">
                <!-------- Product Images -------->
                <div class="col-xs-12 col-md-6 mt-3 mb-5">
                    <div id="carouselMDExample" class="carousel slide carousel-fade" data-mdb-ride="carousel">
                        <!----- Slides ----->
                        <div class="carousel-inner mb-5 shadow-1-strong rounded-3">

                            <div class="carousel-item active">
                                <img src="data:image/png;base64,${product[0].productImage[0].imageAsBase64}" class="d-block w-100" alt="..." 
                                     style="object-fit: cover;"/>
                            </div>

                            <pre:set var="productImg" value="${product[0]}"/>
                            <pre:forEach items="${productImg.productImage}" var="productImages" begin="1">
                                <div class="carousel-item">
                                    <img src="data:image/png;base64,${productImages.imageAsBase64}" class="d-block w-100"
                                         alt="..." style="object-fit: cover;"/>
                                </div>
                            </pre:forEach>
                        </div>
                        <!----- Slides ----->

                        <!----- Controls ----->
                        <button class="carousel-control-prev text-muted" type="button" data-mdb-target="#carouselMDExample"
                                data-mdb-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next text-muted" type="button" data-mdb-target="#carouselMDExample"
                                data-mdb-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                        <!----- Controls ----->

                        <!----- Thumbnails ----->
                        <div class="carousel-indicators" style="margin-bottom: -20px;">
                            <button type="button" data-mdb-target="#carouselMDExample" data-mdb-slide-to="0" class="active"
                                    aria-current="true" style="width: 100px;">
                                <img class="d-block w-100 shadow-1-strong rounded"
                                     src="data:image/png;base64,${product[0].productImage[0].imageAsBase64}" class="img-fluid" style="object-fit: cover;"/>
                            </button>


                            <pre:set var="productImg2" value="${product[0]}"/>
                            <pre:forEach items="${productImg2.productImage}" var="productImages" begin="1" varStatus="loop">
                                <button type="button" data-mdb-target="#carouselMDExample" data-mdb-slide-to="${loop.index}"
                                        style="width: 100px;">
                                    <img class="d-block w-100 shadow-1-strong rounded"
                                         src="data:image/png;base64,${productImages.imageAsBase64}" class="img-fluid" style="object-fit: cover;"/>
                                </button>
                            </pre:forEach>
                        </div>
                        <!----- Thumbnails ----->
                    </div>     
                </div>
                <!-------- Product Images -------->

                <!-------- Product Details -------->
                <div class="col-xs-12 col-md-6 mt-2">
                    <h1>${product[0].productName}</h1>
                    <h3>RM <fmt:formatNumber value="${product[0].price}" type="number" minFractionDigits="2"/></h3>
                    <div class="border-top pt-3 mb-3" style="min-height: 138px;">
                        <p>${product[0].productDesc}</p>
                    </div>
                    <!----- Colors ----->
                    <div class="row d-flex align-items-center mb-3">
                        <div class="col">
                            <h6>Color - Size:</h6>
                            <pre:forEach items="${product}" var="productDetails">
                                <pre:forEach items="${productDetails.productDetail}" var="details">
                                    <input type="radio" class="btn-check" name="details-option" id="${details.productDetailId}" autocomplete="off" checked>
                                    <label class="btn btn-outline-info mt-1" for="${details.productDetailId}">${details.color} - ${details.size}</label>

                                    <!--                            <input type="radio" class="btn-check" name="color-option" id="color2" autocomplete="off">
                                                                <label class="btn btn-outline-info mt-1" for="color2">Pink</label>
                                    
                                                                <input type="radio" class="btn-check" name="color-option" id="color3" autocomplete="off">
                                                                <label class="btn btn-outline-info mt-1" for="color3">White</label>-->
                                </pre:forEach>
                            </pre:forEach>
                        </div>
                    </div>
                    <!----- Colors ----->      
                    <!----- Size ----->
                    <!--                    <div class="row d-flex align-items-center mb-3">
                                            <div class="col">
                                                <h6>Color - Size:</h6>
                    <pre:forEach items="${product}" var="productDetails">
                        <pre:forEach items="${productDetails.productDetail}" var="details">
                        
                        <input type="radio" class="btn-check" name="size-option" id="${details.size}" autocomplete="off">
                        <label class="btn btn-outline-info" for="${details.size}">
                            ${details.size}
                        </label>
        

                        <input type="radio" class="btn-check" name="size-option" id="size2" autocomplete="off">
                        <label class="btn btn-outline-info" for="size2">38</label>
                        </pre:forEach>
                    </pre:forEach>
               </div>
           </div>-->
                    <!----- Size ----->
                    <!----- Quantity ----->
                    <div class="col-md-12 d-flex justify-content-between align-items-center border-bottom mt-4 pb-4">
                        <div class="col-md-6">
                            <h6 class="mb-0">Quantity: </h6>
                        </div>
                        <%--<pre:forEach items="${product.productDetail}" var="quantity" >--%>
                        <!--- Quantity Input --->
                        <div class="col-md-6 d-flex justify-content-end">
                            <button class="btn btn-link px-2" onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                <i class="fas fa-minus"></i>
                            </button>
                            <input id="quantity" min="1" name="quantity" value="1" type="number"
                                   class="form-control form-control-sm text-center" />
                            <button class="btn btn-link px-2" onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                <i class="fas fa-plus"></i>
                            </button>
                        </div>
                        <%--</pre:forEach>--%>
                        <!--- Quantity Input --->
                    </div>
                    <!----- Quantity ----->
                </div>
                <!-------- Product Details -------->
            </div>
            <!------------- 1st Inner Container ------------->

            <!------------- 1st Sub Container ------------->
            <div class="row mt-3 align-items-center">
                <!----- Back Button ----->
                <div class="col-md-6">
                    <div class="d-grid gap-2 d-md-flex justify-content-md-start">
                        <a href="#" data-mdb-toggle="tooltip" data-mdb-placement="right" title="Back" onclick="window.history.back()">
                            <i class="fas fa-arrow-circle-left fs-1"></i>
                        </a>
                    </div>  
                </div> 
                <!----- Back Button ----->
                <!----- Action Buttons ----->
                <div class="col-md-6 mt-2">
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                        <button class="btn btn-primary" type="button" id="buy-now-btn">Buy Now</button>
                        <button class="btn btn-secondary" id="add-cart-btn" type="button">Add to Cart</button>
                    </div>
                </div>
                <!----- Action Buttons ----->
            </div>
            <!------------- 1st Sub Container ------------->


            <!-------- Related Products -------->
            <div class="container py-5 border-top mt-5" id="relProContainer">
                <h3 class="mb-5"><strong>Related Products</strong></h3>
                <!----- 1st Row ----->
                <div class="row">
                    <!--- First Image (Use Loop) --->
                    <pre:forEach items="${relatedProducts}" var="relatedProduct">
                        <div class="col-lg-4 col-md-12 mb-4 relProducts">
                            <div class="bg-image hover-zoom ripple shadow-1-strong rounded">
                                <img
                                    src="data:image/png;base64,${relatedProduct.productImage[0].imageAsBase64}"
                                    class="w-100"
                                    style="width: 80px; height: 250px; object-fit: cover;"/>
                                <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Product/Fo.ProductView.jsp?productId=${relatedProduct.productId}">
                                    <div class="mask" style="background-color: rgba(0, 0, 0, 0.3);">
                                        <div class="d-flex justify-content-start align-items-end h-100">
                                            <div class="col">
                                                <h5><span class="badge bg-light pt-2 ms-3 text-muted">RM <fmt:formatNumber value="${relatedProduct.price}" type="number" minFractionDigits="2"/></span></h5>
                                                <h5><span class="badge bg-light pt-2 ms-3 mb-2 text-muted">${relatedProduct.productName}</span></h5>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="hover-overlay">
                                        <div
                                            class="mask"
                                            style="background-color: rgba(253, 253, 253, 0.15);"
                                            ></div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </pre:forEach>
                    <!--- First Image (Use Loop) --->
                </div>
                <!----- 1st Row ----->
            </div>
            <!-------- Related Products -------->
        </div>
        <!------------------- Outer Container ------------------->
        <%@include file="../Fo.Footer.jsp" %>
        <script src="<%=request.getContextPath()%>/Scripts/FrontOffice/Product/Fo.ProductView.js" type="text/javascript"></script>
    </body>
</html>
