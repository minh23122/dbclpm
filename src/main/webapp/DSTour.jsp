<%-- 
    Document   : DSTour.jsp
    Created on : Jul 30, 2023, 10:04:43 PM
    Author     : AD
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.LichTrinh"%>
<%@page import="controller.LichTrinhDAO"%>
<%@page import="controller.TourDAO"%>
<%@page import="model.Tour"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        *{
            box-sizing: border-box;
        }
        table,th,td{
            border: 1px solid black;
            text-align: center;
        }
    </style>
    <%
        LichTrinhDAO ltdao = new LichTrinhDAO();
        List<LichTrinh> list = ltdao.getAllLTTours();
    %>
    <body>
        <h1>Danh sách Tour!</h1>
        <table>
            <thead>
            <td>id</td> 
            <td>tên</td>
            <td>nơi đến</td>
            <td>nơi xuất phát</td>
            <td>mô tả</td>
            <td>Lịch trình</td>
        </thead>
        <%!
            public void lenLich() {
        %>
        <script>window.location.href = './TimDDDV.jsp'</script>
        <%!
            }
        %>
        <%  for (LichTrinh lt : list) {
        %>
        <tr>
            <td><%=lt.getTour().getId()%></a></td>
            <td><%=lt.getTour().getName()%></td>
            <td><%=lt.getTour().getNoiden().getTen()%></td>
            <td><%=lt.getTour().getNoixuatphat().getTen()%></td>
            <td><%=lt.getTour().getMota()%></td>
            <td><%=lt.getId() == 0 ? "chưa có" : lt.getId()%></td>
            <td><input type="submit" onclick="<%ltdao.themLT();%>">Lên lịch</button></td>
        </tr>
        <%}%>
    </table>
</body>
</html>
