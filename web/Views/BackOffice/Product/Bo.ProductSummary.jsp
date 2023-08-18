<%-- 
    Document   : Bo.ProductSummary
    Created on : Mar 3, 2022, 3:57:09 PM
    Author     : Tham Jun Yuan
--%>
<%@page import="Model.Product"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%
        request.setAttribute("products", new BusinessLogic.BackOffice.Product.BllBo_GetFull().businessLogic(new Product()));
        %>
        <title>Nike Office | Product</title>
         <%@include file="../Bo.HeaderANDNav.jsp"%>
         <%@include file="Bo.ProductModal.jsp"%>
    </head>
    <body>
        <main class="cont">
            <div class="m-4">
                    <h2>Product Summary</h2>
                </div>
             <div class="cont1">
            
            <!--the id will be used in js file-->
            <table id="table-product-summary" class="table table-striped border">
                <thead>
                    <tr>
                        <a class="btn btn-primary btn-lg btn-floating btn-sm bg-primary float-end" 
                            data-mdb-toggle="tooltip" title="Add"  href="Bo.ProductNew.jsp" role="button">
                            <i class="fas fa-plus"></i>
                        </a>
                    </tr>
                    <tr>
                        <th class="text-capitalize">Action</th>
                        <th class="text-capitalize">Product No</th>
                        <th class="text-capitalize">product name</th>
                        <th class="text-capitalize">category</th>
                        <th class="text-capitalize">feature</th>
                        <th class="text-capitalize">status</th>
                        <th class="text-capitalize">created date</th>
                        <th class="text-capitalize">created by</th>
                        <th class="text-capitalize">updated date</th>
                        <th class="text-capitalize">updated by</th>
                    </tr>
                </thead>
                <tbody>
                    <pre:forEach items="${products}" var="product">
                    <tr>
                        <td>
                            <a class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                               data-mdb-toggle="tooltip" title="View"  href="Bo.ProductView.jsp?productId=<pre:out value='${product.productId}' />" role="button">
                                <i class="fas fa-solid fa-eye" ></i>
                            </a>
                            <a class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                               data-mdb-toggle="tooltip" title="Edit"  href="Bo.ProductEdit.jsp?productId=<pre:out value='${product.productId}'/>" role="button">
                                <i class="fas fa-pen" ></i>
                            </a>
                            <a class="btn btn-primary btn-lg btn-floating btn-sm" data-mdb-toggle="tooltip" title="Add Detail" 
                                 href="Bo.ProductNewDetail.jsp?productId=<pre:out value='${product.productId}'/>" role="button"  >
                                <i class="fas fa-plus"></i>
                            </a>
                            <button type="button" class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                    data-mdb-toggle="tooltip" title="Activate"
                                    onclick="productActivate('${product.productId}')">
                              <i class="fas fa-check"></i>
                            </button>
                            <button type="button" class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                    data-mdb-toggle="tooltip" title="Deactivate"
                                    onclick="productDeactivate('${product.productId}')">
                              <i class="fas fa-times"></i>
                        </td>
                        <td><pre:out value="${product.productNo}" /></td>
                        <td><pre:out value="${product.productName}" /></td>
                        <td><pre:out value="${product.category}" /></td>
                        <td>
                        <pre:if test="${product.isFeatured == 1}">Yes</pre:if>
                        <pre:if test="${product.isFeatured == 0}">No</pre:if>
                        </td>
                        <td><pre:out value="${product.status}" /></td>
                        <td><pre:out value="${product.createdDate}" /></td>
                        <td><pre:out value="${product.createdBy}" /></td>
                        <td><pre:out value="${product.updatedDate}" /></td>
                        <td><pre:out value="${product.updatedBy}" /></td>
                    </tr>
                     </pre:forEach>
                </tbody>
            </table>
        </div>
        </main>
        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Product/Bo.ProductSummary.js" type="text/javascript"></script>
    </body>
</html>
