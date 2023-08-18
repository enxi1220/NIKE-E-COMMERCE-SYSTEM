<%-- 
    Document   : Bo.ProductEdit
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
        <title>Nike Office | Product Edit</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
        <%@include file="Bo.ProductModal.jsp"%>
        <link href="../../../StyleSheets/BackOffice/Product/Bo.Product.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <main class="cont">
            <div class="ms-5 mt-4">
                <h4 class="m-0">Edit Product - ${products[0].productNo}</h4>
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
                                <span class="position-absolute" onclick="deleteProductImage('${image.productImageId}')">&times;</span>
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
                                    <input type="text" id="productName" class="form-control" value="${products[0].productName}"/>
                                    <label class="form-label" for="productName">Product Name</label>
                                </div>
                            </div>

                            <div class="col">
                                <!-- Price input -->
                                <div class="form-outline">
                                    <input type="text" id="price" class="form-control" required="required" value="<fmt:formatNumber value="${products[0].price}" type="number" minFractionDigits="2"/>" onkeypress="return validateNumber(event)"/>
                                    <label class="form-label" for="price">Price</label>
                                </div>
                            </div>
                        </div>

                        <div class="row mt-3">
                            <div class="col">
                                <div class="form-outline" >
                                    <textarea class="form-control" id="productDesc" rows="3" style="resize: none;">${products[0].productDesc}</textarea>
                                    <label class="form-label" for="productDesc">Description</label>
                                </div>
                            </div>

                            <div class="col">
                                <div class="row">
                                    <div class="col">
                                        <select class="form-control" value="${products[0].category}" id="category">
                                            <option selected hidden>Category</option>
                                            <option value="${kids}" <pre:if test="${products[0].category == kids}">selected='selected'
                                                    </pre:if>>${kids}</option>
                                            <option value="${women}" <pre:if test="${products[0].category == women}">selected='selected'
                                                    </pre:if>>${women}</option>
                                            <option value="${men}" <pre:if test="${products[0].category == men}">selected='selected'
                                                    </pre:if>>${men}</option>
                                            <option value="${unisex}" <pre:if test="${products[0].category == unisex}">selected='selected'
                                                    </pre:if>>${unisex}</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col mt-3">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" value=""  <pre:if test="${products[0].isFeatured == 1}">checked='checked'
                                                   </pre:if> id="isFeatured" name="isFeatured" />
                                            <label class="form-check-label" for="flexCheckDefault">Is Featured?</label>
                                        </div>
                                    </div>
                                    <div class="col d-flex justify-content-end">
                                        <button type="button" class="btn btn-primary mt-3" onclick="editProduct()" >Save</button>
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


                    <form class="mx-5 my-4">
                        <div class="row">
                            <div class="col">
                                <!-- Name input -->
                                <div class="form-outline">
                                    <input type="text" id="color" class="form-control" onkeypress="return validateAlpha(event)" />
                                    <label class="form-label" for="color">Color</label>
                                </div>
                            </div>

                            <div class="col">
                                <div class="form-outline">
                                    <input type="text" id="size" class="form-control"/>
                                    <label class="form-label" for="size">Size</label>
                                </div>
                            </div>
                        </div>

                        <div class="row mt-3">
                            <div class="col">
                                <div class="form-outline">
                                    <input type="number" id="phyQty" class="form-control" step="1" min="1" onkeypress="return validateNumber(event)"/>
                                    <label class="form-label" for="phyQty">Physical Quantity</label>
                                </div>
                            </div>

                            <div class="col">
                                <div class="form-outline">
                                    <input type="number" id="minQty" class="form-control" step="1" min="1" onkeypress="return validateNumber(event)"/>
                                    <label class="form-label" for="minQty">Minimum Quantity</label>
                                </div>
                            </div>

                            <div class="col">
                                <div class="form-outline">
                                    <input type="number" id="salesQty" class="form-control" step="1" min="1" readonly/>
                                    <input type="text" name="productDetailId" value="" hidden id="productDetailId"/>
                                    <label class="form-label" for="salesQty">Sales Quantity</label>
                                </div>
                            </div>
                        </div> 

                        <div class="row mt-3">
                            <div class="col d-flex justify-content-end">
                                <button type="button" class="btn btn-primary ms-4" onclick="editProductDetail()"  >Save</button>
                            </div>
                        </div>
                    </form>      
                </div>
            </div>
            <!---------------------           Data table          ------------------------------------->
            <div class="mx-5 my-4">
                <table id="table-product-edit-summary" class="table table-striped border m">
                    <thead>
                        <tr>
                            <th class="text-capitalize">action</th>
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
                                    <td>
                                        <a class="btn btn-primary btn-lg btn-floating btn-sm" data-mdb-toggle="tooltip" title="Edit" 
                                           href="#" role="button" onclick="passData('${productDetail.color}', '${productDetail.size}', '${productDetail.physicalQty}', '${productDetail.minStockQty}', '${productDetail.salesOutQty}', '${productDetail.productDetailId}')" >
                                            <i class="fas fa-edit"></i>
                                        </a>
                                    </td>
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

        <script src="../../../Scripts/BackOffice/Product/Bo.ProductEdit.js" type="text/javascript"></script>
    </body>
</html>
