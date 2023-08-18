<%-- 
    Document   : Bo.ProductView
    Created on : Mar 24, 2022, 6:43:35 PM
    Author     : Tham Jun Yuan
--%>

<%@page import="Helper.Constant"%>
<%@page import="Model.Product"%>
<%@page import="Model.ProductImage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%request.setAttribute("kids", Helper.Constant.getCategory(Constant.CategoryEnum.Kids));%>
<%request.setAttribute("men", Helper.Constant.getCategory(Constant.CategoryEnum.Men));%>
<%request.setAttribute("unisex", Helper.Constant.getCategory(Constant.CategoryEnum.Unisex));%>
<%request.setAttribute("women", Helper.Constant.getCategory(Constant.CategoryEnum.Women));%>
<%
    int productId = Integer.parseInt(request.getParameter("productId"));
    request.setAttribute("images", new BusinessLogic.BackOffice.ProductImage.BllBo_Get().businessLogic(new ProductImage().setProductId(productId)));
    request.setAttribute("products", new BusinessLogic.BackOffice.Product.BllBo_GetFullDetail().businessLogic(new Product().setProductId(productId)));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nike Office | View Product</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
        <link href="../../../StyleSheets/BackOffice/Product/Bo.Product.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <main class="cont">
            <div class="ms-5 mt-4">
                <h4 class="m-0">View Product - ${products[0].productNo}</h4>
            </div>

            <div class="contain mt-3 w-100">
                <div class="card shadow-sm w-100">
                    <div class="card-header d-flex justify-content-between ms-5 mt-4">
                        <h4 class="m-0">Product Image</h4>
                    </div>

                    <div class="card-body d-flex flex-wrap justify-content-start" id="container">
                        <pre:forEach items="${images}" var="image">
                            <div class="image_container d-flex justify-content-center position-relative">

                                <img src="data:image/png;base64,${image.imageAsBase64}" alt="Image"/>
                            </div>
                        </pre:forEach>
                    </div>

                </div>
            </div>

            <hr />

            <div class="contain w-100">
                <div class="card shadow-sm w-100">
                    <div class="card-header d-flex justify-content-between ms-5">
                        <h4 class="m-0">Product</h4>
                    </div>

                    <form class="mx-5 my-4">
                        <div class="row">
                            <div class="col">
                                <!-- Name input -->
                                <div class="form-outline">
                                    <input type="text" id="productName" class="form-control" value="${products[0].productName}" readonly/>
                                    <label class="form-label" for="productName">Product Name</label>
                                </div>
                            </div>

                            <div class="col">
                                <!-- Price input -->
                                <div class="form-outline">
                                    <input type="text" id="price" class="form-control" value="<fmt:formatNumber value="${products[0].price}" type="number" minFractionDigits="2"/>" readonly/>
                                    <label class="form-label" for="price">Price</label>
                                </div>
                            </div>
                        </div>

                        <div class="row mt-3">
                            <div class="col">
                                <div class="form-outline" >
                                    <textarea class="form-control" id="productDesc" rows="3" style="resize: none;" readonly>${products[0].productDesc}</textarea>
                                    <label class="form-label" for="productDesc">Description</label>
                                </div>
                            </div>

                            <div class="col">
                                <div class="row">
                                    <div class="col">
                                        <div class="form-outline">
                                           <input type="text" class="form-control" value="${products[0].category}" id="category" readonly />
                                        <label class="form-label" for="category">Category</label>
                                        </div>
                                        
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col mt-3">
                                        <div class="form-outline">
                                           <input type="text" class="form-control" value="<pre:if test="${products[0].isFeatured == 1}">Yes</pre:if> <pre:if test="${products[0].isFeatured == 0}">No</pre:if>" id="isFeatured" name="isFeatured" readonly />
                                            <label class="form-label" for="isFeatured">Is Featured?</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>       
                    </form>   


                </div>
            </div>

            <hr />

            <!------------------------------------- Product Detail ------------------------------------------>

            <div class="contain w-100">
                <div class="card shadow-sm w-100">
                    <div class="card-header d-flex justify-content-between ms-5">
                        <h4 class="m-0">Product Detail</h4>
                    </div>
       
                </div>
            </div>
            <!---------------------           Data table          ------------------------------------->
            <div class="mx-5 my-4">
                <table id="table-product-edit-summary" class="table table-striped border m">
                    <thead>
                        <tr>
                            <th class="text-capitalize">color</th>
                            <th class="text-capitalize">size</th>
                            <th class="text-capitalize">physical quantity</th>
                            <th class="text-capitalize">minimum quantity</th>
                            <th class="text-capitalize">sales quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <pre:forEach items="${products}" var="product">
                            <pre:forEach items="${product.productDetail}" var="productDetail">
                                <tr>
                                    <td>${productDetail.color}</td>
                                    <td>${productDetail.size}</td>
                                    <td>${productDetail.physicalQty}</td>
                                    <td>${productDetail.minStockQty}</td>
                                    <td>${productDetail.salesOutQty}</td>
                                </tr>
                            </pre:forEach>
                        </pre:forEach>

                    </tbody>
                   
                </table>
            </div>
        </main>

        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Courier/Bo.ProductView.js" type="text/javascript"></script>
        
    </body>
</html>
