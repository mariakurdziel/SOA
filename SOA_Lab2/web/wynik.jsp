<%@ page import='Piwo.EkspertPiwny' %>
<%--
  Created by IntelliJ IDEA.
  User: maria
  Date: 2019-03-17
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wynik formularza</title>
</head>
<body>
<p>Podany przez ciebie kolor:</p>
<%
    out.print("<p>"+EkspertPiwny.getColor()+"</p>");
%>
<p>Wybrane dla ciebie piwo:</p>
<%
    String beer=EkspertPiwny.getBeer();
    out.print("<p>"+beer+"</h2>");
%>
</body>
</html>
