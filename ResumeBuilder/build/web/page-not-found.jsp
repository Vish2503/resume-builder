<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Not Found</title>
        <%@include file="link-css.html" %>
        <style>
            *{
                transition: all 0.6s;
            }

            html {
                height: 100%;
            }

            body{
                font-family: 'Rubik', sans-serif;
                color: #888;
                margin: 0;
            }

            body * {
                font-weight: bold;
            }

            #main{
                display: table;
                width: 100%;
                height: 100vh;
                text-align: center;
            }

            .fof{
                display: table-cell;
                vertical-align: middle;
            }

            .fof h1{
                font-size: 50px;
                display: inline-block;
                padding-right: 12px;
                animation: type .5s alternate infinite;
            }
            
            svg {
                margin-bottom: -10px;
                margin-right: 10px;
            }

            @keyframes type{
                from{box-shadow: inset -3px 0px 0px #888;}
                to{box-shadow: inset -3px 0px 0px transparent;}
            }
        </style>
    </head>
    <body>
        <!--https://codepen.io/akashrajendra/pen/JKKRvQ-->
        <div id="main">
            <div class="fof">
                <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-error-404-off" width="60" height="60" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
                <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                <path d="M3 7v4a1 1 0 0 0 1 1h3"/>
                <path d="M7 7v10"/>
                <path d="M10 10v6a1 1 0 0 0 1 1h2a1 1 0 0 0 1 -1v-2m0 -4v-2a1 1 0 0 0 -1 -1h-2"/>
                <path d="M17 7v4a1 1 0 0 0 1 1h3"/>
                <path d="M21 7v10"/>
                <path d="M3 3l18 18"/>
                </svg>
                <h1>Page Not Found</h1>
            </div>
        </div>
    </body>
</html>
