<%-- 
    Document   : Bo.ProductNew
    Created on : Mar 17, 2022, 9:09:20 PM
    Author     : Tham Jun Yuan
--%>

<%@page import="Helper.Constant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%request.setAttribute("kids", Helper.Constant.getCategory(Constant.CategoryEnum.Kids));%>
<%request.setAttribute("men", Helper.Constant.getCategory(Constant.CategoryEnum.Men));%>
<%request.setAttribute("unisex", Helper.Constant.getCategory(Constant.CategoryEnum.Unisex));%>
<%request.setAttribute("women", Helper.Constant.getCategory(Constant.CategoryEnum.Women));%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nike Office | Add Product</title>
        <%@include file="../Bo.HeaderANDNav.jsp" %>
        <%@include file="Bo.ProductModal.jsp" %>
        <link href="../../../StyleSheets/BackOffice/Product/Bo.Product.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="cont">
            <div class="ms-5 mt-4">
                <h4 class="m-0">Add Product</h4>
            </div>

            <form class="mx-5 my-4 form" method="post" id="addProductForm">
                <div class="row">
                    <div class="col">
                        <!-- Name input -->
                        <div class="form-outline">
                            <input type="text" id="productName" class="form-control" name="productName"/>
                            <label class="form-label" for="productName">Product Name</label>
                        </div>
                    </div>

                    <div class="col">
                        <!-- Price input -->
                        <div class="form-outline">
                            <input type="number" id="productPrice" class="form-control" min="10.00" name="productPrice" onkeypress="return validateAlpha(event)" />
                            <label class="form-label" for="productPrice">Price</label>
                        </div>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col">
                        <div class="form-outline">
                            <textarea class="form-control" id="productDesc" rows="3" style="resize: none;" name="productDesc" ></textarea>
                            <label class="form-label" for="productDesc">Description</label>
                        </div>
                    </div>

                    <div class="col">
                        <div class="row">
                            <div class="col">
                                <select class="form-control" id="productCategory" name="productCategory">
                                    <option selected hidden>Category</option>
                                    <option value="${kids}">${kids}</option>
                                    <option value="${women}">${women}</option>
                                    <option value="${men}">${men}</option>
                                    <option value="${unisex}">${unisex}</option>
                                   
                                </select>
                            </div>
                        </div>

                        <div class="col">
                            <div class="row">
                                <div class="col mt-3">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" name="isFeatured" />
                                        <label class="form-check-label" for="flexCheckDefault">Is Featured?</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row mt-3 mb-5">
                        <div class="col d-flex justify-content-end">
                            <!-- Cancel button -->
                            <a class="btn btn-secondary" 
                               href="${pageContext.servletContext.contextPath}/Views/BackOffice/Product/Bo.ProductSummary.jsp">Cancel</a>
                            <!-- Submit button -->
                            <button type="submit" class="btn btn-primary ms-4" name="product_add" >Save</button>
                        </div>
                    </div>
                </div>           

            </form>  

        
    </div>

    <!--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>-->

    <%@include file="../Bo.Footer.jsp" %>
    <script src="<%=request.getContextPath()%>/Scripts/BackOffice/Product/Bo.ProductNew.js" type="text/javascript"></script>
</body>
</html>

