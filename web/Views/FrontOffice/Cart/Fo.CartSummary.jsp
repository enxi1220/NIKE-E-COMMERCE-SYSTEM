<%-- 
    Document   : CartSummary
    Created on : 21 Feb 2022, 3:46:31 pm
    Author     : Lim En Xi
--%>

<%@page import="Model.Customer"%>
<%@page import="Model.ProductDetail"%>
<%@page import="Model.CartDetail"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Cart"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <%
        if (session.getAttribute("customerId") == null) {
            response.setStatus(500);
            throw new Exception("Access Restricted. Please login before proceed.");
        }
        
        request.setAttribute("carts", new BusinessLogic.FrontOffice.Cart.BllFo_GetFull().businessLogic(
                new Cart().setCustomer(new Customer().setUsername((String) session.getAttribute("username")))));
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../Fo.Header.jsp" %>
        <%@include file="Fo.CartModal.jsp" %>
    </head>
    <body style="background-color: #ddd">
        <section class="h-100">
            <div class="container h-100 py-5">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-10">

                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <h3 class="fw-normal mb-0 text-black">Shopping Cart</h3>
                            <div>
                                <!--todo: OrderNew.jsp -->
                                <button class="btn btn-primary" type="button" onclick="placeOrder(${carts[0].cartId})">place order</button>
                            </div>
                        </div>
                        <!--loop-->
                        <pre:forEach items="${carts}" var="cart">
                            <pre:forEach items="${cart.cartDetail}" var="cartDetail">
                                <pre:set value="${cartDetail.product}" var="product"/>
                                <pre:set value="${cartDetail.product.productImage[0]}" var="productImage"/>
                                <pre:forEach items="${cartDetail.product.productDetail}" var="productDetail">
                                    <div class="card rounded-3 mb-4">
                                        <div class="card-body p-4">
                                            <div class="row d-flex justify-content-between align-items-center">
                                                <div class="col-md-2 col-lg-2 col-xl-2">
                                                    <img src="data:image/png;base64,${productImage.imageAsBase64}"
                                                         class="img-fluid rounded-3" alt="${product.productName}" />
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-3">
                                                    <p class="lead fw-normal mb-2" name="product-name">${product.productName}</p>
                                                    <p><span class="text-muted">Color: </span>${productDetail.color} 
                                                        <span class="ml-5 text-muted">Size: </span>${productDetail.size}
                                                    <p>
                                                        <a href="../Product/Fo.ProductView.jsp?productId=${product.productId}" class="text-capitalize link-secondary" type="button">view product</a>
                                                    </p>
                                                </div>
                                                <input id="cart-detail-id" value="${cartDetail.cartDetailId}" hidden/>
                                                <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                    <button class="btn btn-link px-2"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                        <i class="fas fa-minus"></i>
                                                    </button>

                                                    <input id="txt-quantity" min="1" name="quantity" value="${cartDetail.quantity}" type="number"
                                                           class="form-control form-control-sm text-center"
                                                           onchange="calcPrice(${product.price})"
                                                           />

                                                    <button class="btn btn-link px-2"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                                <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                    <h5 class="mb-0" id="price">RM <fmt:formatNumber value="${product.price * cartDetail.quantity}" type="number" minFractionDigits="2"/></h5>
                                                </div>
                                                <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                    <a class="link-danger"
                                                       onclick="deleteCartDetail(${cartDetail.cartDetailId})"
                                                       value="${cartDetail.cartDetailId}"
                                                       id="cartDetail"
                                                       data-mdb-toggle="tooltip" 
                                                       title="Remove from cart"><i class="fas fa-trash fa-lg"></i>
                                                    </a>
                                                    <p></p>
                                                    <button class="btn btn-secondary" data-mdb-toggle="tooltip" 
                                                            title="Save quantity changes" type="button" id="editCart" 
                                                            onclick="editCart('${cartDetail.cartDetailId}')">save
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </pre:forEach>
                            </pre:forEach>
                        </pre:forEach>
                        <!-- js loop-->
                    </div>
                </div>
            </div>
        </section>
        <%@include file="../Fo.Footer.jsp" %>
        <script src="${pageContext.servletContext.contextPath}/Scripts/FrontOffice/Cart/Fo.CartSummary.js" type="text/javascript"></script>
    </body>
</html>
