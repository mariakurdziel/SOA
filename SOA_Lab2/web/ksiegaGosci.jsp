<%@ page import="Ksiega.Wpis" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: maria
  Date: 2019-03-17
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Księga Gosci</title>
</head>
<body>
<form action="DodajWpis" method="get">
    Imie: <input type="text" required name="name"/>
    Email: <input type="text" required name="mail" size="2"/>
    Wpis: <input type="text" required name="comment" size="2"/>
    <input type="submit" value="Dodaj wpis"/>
</form>
<%
    Vector<Wpis> comments = (Vector<Wpis>) session.getAttribute("comments");

    if(!comments.isEmpty()){
        for(Wpis x: comments){
            out.print("<p>"+x.name+"</p><p>"+x.email+"</p><p>"+x.comment+"</p><br><br><br>");
        }
    }
    %>
</body>
</html>
