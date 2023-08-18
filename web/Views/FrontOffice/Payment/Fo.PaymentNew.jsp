<%-- 
    Document   : Fo.PaymentNew
    Created on : 19 Feb 2022, 10:51:10 pm
    Author     : Lim En Xi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("customerId") == null) {
        response.setStatus(500);
        throw new Exception("Access Restricted. Please login before proceed.");
    }

    int orderId = Integer.parseInt(request.getParameter("orderId"));

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../Fo.Header.jsp" %>
    </head>
    <body>
        <div class="float-end m-3">
            <a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Product/Fo.ProductSummary.jsp" data-mdb-toggle="tooltip" data-mdb-placement="right" title="Back and pay later">
                <i class="fas fa-arrow-circle-left fs-1"></i>
            </a>
        </div> 
        <!-- Tabs navs -->
        <ul class="nav nav-tabs nav-justified mb-3" id="ex1" role="tablist">
            <li class="nav-item" role="presentation">
                <a
                    class="nav-link active"
                    id="tng-tab"
                    data-mdb-toggle="tab"
                    href="#tng-tabs"
                    role="tab"
                    aria-controls="tng-tabs"
                    aria-selected="true"
                    >
                    <i class="fas fa-wallet"></i>
                    touch n go e-wallet</a
                >
            </li>
            <li class="nav-item" role="presentation">
                <a
                    class="nav-link"
                    id="online-banking-tab"
                    data-mdb-toggle="tab"
                    href="#online-banking-tabs"
                    role="tab"
                    aria-controls="online-banking-tabs"
                    aria-selected="false"
                    >
                    <i class="fas fa-piggy-bank"></i>
                    online banking</a
                >
            </li>
            <li class="nav-item" role="presentation">
                <a
                    class="nav-link"
                    id="card-tab"
                    data-mdb-toggle="tab"
                    href="#card-tabs"
                    role="tab"
                    aria-controls="card-tabs"
                    aria-selected="false"
                    >
                    <i class="fab fa-cc-mastercard"></i>
                    Card</a
                >
            </li>
        </ul>
        <!-- Tabs navs -->

        <!-- Tabs content -->
        <div class="tab-content" id="ex2-content">
            <div
                class="tab-pane fade show active"
                id="tng-tabs"
                role="tabpanel"
                aria-labelledby="tng-tab"
                >
                <!-- tng-->
                <div class="container my-5">
                    <div class="row d-flex justify-content-center">
                        <div class="col-md-7 col-lg-5 col-xl-4">
                            <div class="card">
                                <div class="card-body p-4">
                                    <form>
                                        <div class="d-flex justify-content-between align-items-center mb-3">
                                            <div class="form-outline ">
                                                <p class="badge bg-info p-2 fs-6">
                                                    <i class="fas fa-exclamation-circle"></i>
                                                    Scan with Touch 'n Go E-Wallet. 
                                                </p>
                                                <p>
                                                    Press button to complete process.
                                                </p>
                                                <img
                                                    src="../../Images/nike-payment-qr-code.png"
                                                    alt="Nike QR Code"
                                                    class="img-fluid"
                                                    />
                                            </div>
                                        </div>
                                        <div class="d-flex  mb-4 w-auto">
                                            <button type="button" class="btn btn-primary float-end" onclick="submitPayment('TNG E-wallet')">pay</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div
                class="tab-pane fade"
                id="online-banking-tabs"
                role="tabpanel"
                aria-labelledby="online-banking-tab"
                >
                <!--online banking -->
                <div class="container my-5">
                    <div class="row d-flex justify-content-center">
                        <!--<div class="col-md-7 col-lg-5 col-xl-4">-->
                        <div class="card">
                            <div class="card-body p-4">
                                <form>
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                        <div class="form-outline">
                                            <p class="badge bg-info p-2 fs-6 text-break">
                                                <i class="fas fa-exclamation-triangle "></i>
                                                Note: After clicking on the button, you will be directed to a secure gateway for payment. 
                                            </p>
                                        </div>
                                    </div>

                                    <div class="d-flex justify-content-between align-items-center mb-4 w-auto">
                                        <div class="form-outline">
                                            <input
                                                list="banks" 
                                                name="txt-bank"
                                                id="txt-bank"
                                                class="form-control form-control-lg border-bottom border-3"
                                                size="30"
                                                placeholder="Public Bank"
                                                />
                                            <datalist id="banks">
                                                <option value="Public Bank"></option>
                                                <option value="MayBank"></option>
                                                <option value="CIMB Bank"></option>
                                                <option value="RHB Bank"></option>
                                            </datalist>
                                            <label class="form-label text-capitalize" for="txt-bank">select bank*</label>
                                        </div>
                                        <button type="button" class="btn btn-primary" onclick="submitPayment('Online Banking')">pay</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--</div>-->
                    </div>
                </div>
            </div>
            <div
                class="tab-pane fade"
                id="card-tabs"
                role="tabpanel"
                aria-labelledby="card-tab"
                >
                <!-- card -->
                <div class="container my-5">
                    <div class="row d-flex justify-content-center ">
                        <div class="col-md-7 col-lg-5 col-xl-4">
                            <div class="card">
                                <div class="card-body p-4">
                                    <form>
                                        <div class="d-flex justify-content-between align-items-center mb-3">
                                            <div class="form-outline">
                                                <p class="badge bg-info p-2 fs-6 text-break">
                                                    <i class="fas fa-exclamation-circle "></i>
                                                    Please fill in the card information. 
                                                </p>
                                            </div>
                                        </div>

                                        <div class="d-flex justify-content-between align-items-center mb-3">
                                            <div class="form-outline">
                                                <input
                                                    type="text"
                                                    id="txt-card-number"
                                                    class="form-control form-control-lg border-bottom border-3"
                                                    siez="17"
                                                    placeholder="1234 5678 9012 3457"
                                                    minlength="16"
                                                    maxlength="19"
                                                    />
                                                <label class="form-label text-capitalize" for="txt-card-number">card number*</label>
                                            </div>
                                        </div>

                                        <div class="d-flex justify-content-between align-items-center mb-4">
                                            <div class="form-outline">
                                                <input
                                                    type="text"
                                                    id="txt-card-holder-name"
                                                    class="form-control form-control-lg border-bottom border-3"
                                                    siez="30"
                                                    placeholder="Michael Jordan"
                                                    />
                                                <label class="form-label text-capitalize" for="txt-card-holder-name">cardholder's name*</label>
                                            </div>
                                        </div>

                                        <div class="d-flex justify-content-between align-items-center pb-2">
                                            <div class="form-outline">
                                                <input
                                                    type="text"
                                                    id="txt-exp"
                                                    class="form-control form-control-lg border-bottom border-3"
                                                    placeholder="MM/YYYY"
                                                    size="7"
                                                    id="exp"
                                                    minlength="7"
                                                    maxlength="7"
                                                    />
                                                <label class="form-label text-capitalize" for="txt-exp">expiration*</label>
                                            </div>
                                            <div class="form-outline">
                                                <input
                                                    type="password"
                                                    id="txt-cvv"
                                                    class="form-control form-control-lg border-bottom border-3"
                                                    placeholder="&#9679;&#9679;&#9679;"
                                                    size="1"
                                                    minlength="3"
                                                    maxlength="3"
                                                    />
                                                <label class="form-label text-uppercase" for="txt-cvv">cvv*</label>
                                            </div>
                                            <button type="button" class="btn btn-primary" onclick="submitPayment('Master Card')">pay</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Tabs content -->
        <%@include file="../Fo.Footer.jsp" %>
        <script src="../../../Scripts/FrontOffice/Payment/Fo.PaymentNew.js" type="text/javascript"></script>
    </body>
</html>
