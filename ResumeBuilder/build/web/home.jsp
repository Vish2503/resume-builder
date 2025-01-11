<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resume</title>
        <%@ include file="link-css.html" %> 
        <link rel='stylesheet' type='text/css' href='resume-style.css'>
    </head>
    <body> 
        <%@ include file="nav.html" %> 
        
        <div class="resume-header">
            <h2>Resume</h2>
            <div class="options">       
                <a href="edit"><button>Edit</button></a>
                <a href="print" target="_blank"><button>Save as PDF</button></a>
            </div>
        </div>
        <%@ include file="resume.jsp" %> 
    </body>
</html>
