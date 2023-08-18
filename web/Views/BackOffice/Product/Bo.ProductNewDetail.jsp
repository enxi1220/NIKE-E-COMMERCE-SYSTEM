<%-- 
    Document   : Bo.ProductNew
    Created on : Mar 17, 2022, 9:09:20 PM
    Author     : Tham Jun Yuan
--%>

<%@page import="Model.Product"%>
<%@page import="Model.ProductImage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int productId = Integer.parseInt(request.getParameter("productId"));
    request.setAttribute("images", new BusinessLogic.BackOffice.ProductImage.BllBo_Get().businessLogic(new ProductImage().setProductId(productId)));
    request.setAttribute("products", new BusinessLogic.BackOffice.Product.BllBo_GetFullDetail().businessLogic(new Product().setProductId(productId)));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nike Office | Add Product Detail</title>
        <%@include file="../Bo.HeaderANDNav.jsp" %>
        <%@include file="Bo.ProductModal.jsp" %>
        <link href="../../../StyleSheets/BackOffice/Product/Bo.Product.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="cont">
            <div class="ms-5 mt-4">
                <h4 class="m-0">Add Product Detail</h4>
            </div>

            <form class="mx-5 my-4 form" action="#" method="post" id="addProductDetailForm">

                <div class="row">
                    <div class="col">
                        <!-- Name input -->
                        <div class="form-outline">
                            <input type="text" id="color" class="form-control" name="productColor" onkeypress="return validateAlpha(event)" />
                            <label class="form-label" for="color">Color</label>
                        </div>
                    </div>

                    <div class="col">
                        <div class="form-outline">
                            <input type="text" id="size" class="form-control" name="productSize"/>
                            <label class="form-label" for="size">Size</label>
                        </div>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col">
                        <div class="form-outline">
                            <input type="number" id="phyQty" class="form-control" step="1" min="1" name="phyQty" onkeypress="return validateNumber(event)" />
                            <label class="form-label" for="phyQty">Physical Quantity</label>
                        </div>
                    </div>

                    <div class="col">
                        <div class="form-outline">
                            <input type="number" id="minQty" class="form-control" step="1" min="1" name="minQty" onkeypress="return validateNumber(event)" />
                            <label class="form-label" for="minQty">Minimum Quantity</label>
                        </div>
                    </div>
                </div> 

                <div class="row mt-3 mb-5">
                    <div class="col d-flex justify-content-end">

                        <button type="submit" class="btn btn-primary ms-4" name="product_add">Save</button>
                    </div>
                </div>

            </form>  



            <div class="container mt-3 w-100">
                <div class="card shadow-sm w-100">
                    <div class="card-header d-flex justify-content-between">
                        <h4>Image Uploading</h4>
                        <form id="form">
                            
                            <input type="file" name="productImage" id="productImage" class="d-none" onchange="picPreview(this)">
                            <button class="btn btn-sm btn-primary" type="button" onclick="document.getElementById('productImage').click()">Choose Images</button>
                       
                        </form>
                        
                    </div>
                    <div class="card-body d-flex flex-wrap justify-content-start" id="container">
                       <div class="image_container d-flex justify-content-center position-relative" >
   	  	  	  	  <img src="" id="productImgPre">
   	  	  	  	 
   	  	  	</div> 
                        	  
                    </div>
                </div>
            </div>


            <div class="row mt-3 mb-5">
                <div class="col d-flex justify-content-end">
                    <!-- Submit button -->
                    <button type="button" class="btn btn-primary ms-4" name="product_add" onclick="image_insert()" >Save</button>
                </div>
            </div>
        </div> 



        <!--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>-->
        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Product/Bo.ProductNewDetail.js" type="text/javascript"></script>
        <!--<script src="../../../Scripts/BackOffice/Product/Bo.ProductNew.js" type="text/javascript"></script>-->

    </body>
</html>

