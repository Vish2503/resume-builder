<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exception</title>
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
                <svg height="60px" width="60px" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" 
                         viewBox="0 0 54.264 54.264" xml:space="preserve">
                <g>
                        <g>
                                <g>
                                        <path style="fill:#888;" d="M52.021,49.561c-0.011-0.001-0.02-0.001-0.029,0H2.244c-0.813,0-1.563-0.439-1.959-1.15
                                                c-0.397-0.71-0.378-1.579,0.049-2.271L25.207,5.769c0.408-0.663,1.132-1.066,1.911-1.066c0.777,0,1.502,0.403,1.91,1.066
                                                l24.704,40.098c0.332,0.392,0.532,0.897,0.532,1.451C54.265,48.556,53.261,49.561,52.021,49.561z M6.263,45.073h41.709
                                                L27.118,11.224L6.263,45.073z"/>
                                </g>
                                <g>
                                        <path style="fill:#888;" d="M27.116,38.89c0.584,0,1.082,0.205,1.492,0.612c0.408,0.412,0.613,0.907,0.613,1.49
                                                c0,0.586-0.217,1.081-0.648,1.493c-0.434,0.406-0.919,0.612-1.457,0.612c-0.537,0-1.022-0.206-1.455-0.612
                                                c-0.432-0.412-0.646-0.907-0.646-1.493c0-0.583,0.203-1.078,0.613-1.49C26.036,39.094,26.532,38.89,27.116,38.89z M28.589,35.945
                                                h-2.944V18.062h2.944V35.945z"/>
                                </g>
                        </g>
                </g>
                </svg>
                <h1>Page Under Construction</h1>
            </div>
        </div>
    </body>
</html>
