<%-- 
    Document   : Bo.Footer
    Created on : 21 Feb 2022, 9:30:25 pm
    Author     : Alvin Chan Ee Aun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bo Footer</title>
        
    </head>
    <body>
        
    <footer id="boFooter" class="footer text-center text-lg-start">
      <!-- Copyright -->
      <div class="text-center p-3 footerColor">
        © 2022 Copyright:
        <a class="text-light" href="http://www.nike.com">Nike</a>
      </div>
      <!-- Copyright -->
    </footer>
        <%@include file="../JS_Resources.jsp" %>
        <script src="<%=request.getContextPath()%>/Library/Bootstrap5/vendor/jquery-easing/jquery.easing.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/Library/Bootstrap5/vendor/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/Scripts/BackOffice/User/Bo.User.js" type="text/javascript"></script>

    </body>
</html>
