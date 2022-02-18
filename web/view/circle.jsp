<%-- 
    Document   : circle
    Created on : Jan 11, 2022, 10:33:17 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Circle"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       
    </head>
    <body onload="setup()">
        
            <%
                ArrayList<Circle> circles = (ArrayList<Circle>) request.getAttribute("circleL");
            int width = (Integer) request.getAttribute("width");
            int height = (Integer) request.getAttribute("height");
            %>
        <canvas id="myCanvas" width="<%=width%>" height="<%=height%>" style="border:1px solid #d3d3d3;"></canvas>
        <script>
            const circleListX = [];
            const circleListY = [];
            const circleListSpdX = [];
            const circleListSpdY = [];
            var r =<%=(Integer) request.getAttribute("radius")%>;
            var context;
            function setup() {
                context = myCanvas.getContext('2d');
                <%for (Circle circle : circles) {%>
                        circleListX.push(<%=circle.getX()%>);
                        circleListY.push(<%=circle.getY()%>);
                        circleListSpdX.push(<%=circle.getSpdX()%>);
                        circleListSpdY.push(<%=circle.getSpdY()%>);
                    <%}%>
                setInterval(draw, 10);
            }
            function draw() {
                context.clearRect(0, 0, <%=width%>, <%=height%>);
                context.beginPath();               
                for (var i=0;i<circleListX.length;i++){
                context.arc(circleListX[i], circleListY[i], r, 0, Math.PI * 2, true);           
                context.closePath();
                context.fill();
                
                if (circleListX[i] - r < 0 || circleListX[i] + r > <%=width%>)
                    circleListSpdX[i] = -circleListSpdX[i];
                if (circleListY[i] - r < 0 || circleListY[i] + r > <%=height%>)
                    circleListSpdY[i] = -circleListSpdY[i];
                circleListX[i] += circleListSpdX[i];
                circleListY[i] += circleListSpdY[i];
            }
            }
        </script>
    </body>
</html>
