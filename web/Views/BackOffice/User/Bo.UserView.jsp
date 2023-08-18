<%-- 
    Document   : Bo.ViewUser
    Created on : Feb 23, 2022, 9:32:37 AM
    Author     : Tan Lin Yi
--%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            request.setAttribute("users", new BusinessLogic.BackOffice.User.BllBo_Get().businessLogic(new User().setUsername(request.getParameter("username"))));

        %>
        <title>Nike Office | View User</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>


    </head>
    <body>
        <div class="cont">
            <div class="cont2">
                <div>
                    <h2>View User</h2>
                </div>
                <form>
                    <pre:forEach items="${users}" var="user">

                        <!------------ User Name ----------->
                        <div class="row mb-4">
                            <div class="col-md-5">
                                <div class="form-outline">

                                    <input type="text" id="username" class="form-control " value="${user.username}" disabled/>
                                    <label class="form-label" for="username">Username  </label>
                                </div>
                            </div>

                            <!------------ Name ----------->
                            <div class="col-md-5">
                                <div class="form-outline">

                                    <input type="text" id="name" class="form-control" value="${user.name}" disabled/>
                                    <label class="form-label" for="name">Name  </label>
                                </div>
                            </div>
                        </div>


                        <!------------ email ----------->
                        <div class="row mb-4">
                            <div class="col-md-5">
                                <div class="form-outline">

                                    <input type="email" id="userEmail" class="form-control" value="${user.mail}" disabled/>
                                    <label class="form-label" for="userEmail">Mail  </label>

                                </div>
                            </div>

                            <!------------Phone ----------->
                            <div class="col-md-5">
                                <div class="form-outline">

                                    <input type="text" id="userPhone" class="form-control" value="${user.phone}" disabled/>
                                    <label class="form-label" for="userPhone">Phone  </label>
                                </div>
                            </div>
                        </div>

                        <!------------ Group ----------->
                        <div class="row mb-4">
                            <div class="col-md-5">
                                <div class="form-outline">

                                    <input type="text" id="userGroup" class="form-control" value="${user.userGroup.userGroupName}"  disabled/>
                                    <label class="form-label" for="userGroup">User Group  </label>
                                </div>
                            </div>

                            <!------------ Status ----------->
                            <div class="col-md-5">
                                <div class="form-outline">

                                    <input type="text" id="viewUserStatus" class="form-control" value="${user.status}" disabled/>
                                    <label class="form-label" for="viewUserStatus">Status  </label>
                                </div>
                            </div>
                        </div>
                        <div class="row mt-3 mb-5">
                            <div class="col d-flex justify-content-end">
                                <!-- Cancel button -->
                                <a class="btn btn-secondary" 
                                   href="${pageContext.servletContext.contextPath}/Views/BackOffice/User/Bo.UserSummary.jsp">Back</a>
                            </div>
                        </div>
                    </pre:forEach>
                </form>
            </div>          
        </div>

        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/User/Bo.UserView.js" type="text/javascript"></script>
    </body>


</html>

