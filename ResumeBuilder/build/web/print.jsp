<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Print</title>
        <%@ include file="link-css.html" %> 
        <link rel='stylesheet' type='text/css' href='resume-style.css'>
    </head>
    <body>
        <%@ include file="resume.jsp" %> 
        <script>
            window.print();
        </script>
    </body>
</html>
