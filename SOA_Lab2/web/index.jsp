<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: maria
  Date: 2019-03-17
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>To jest moja pierwsza aplikacja w Javie EE</h1>
  <p>Wyświetlamy na razie stronę JSP</p>
  <%Date tmp=new Date();
  out.print("<h2>"+tmp.toString()+"</h2>");
  %>
  $END$
  </body>
</html>
