<%--
  Created by IntelliJ IDEA.
  User: maria
  Date: 2019-03-17
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>
<form action="WalidacjaDanych" method="get">
    Login: <input type="text" required name="imie"/>
    Haslo: <input type="text" required name="haslo" size="2"/>
    <input type="submit" value="Zaloguj się"/>
</form>
    <%
        if(request.getParameter("valid")!=null && request.getParameter("valid").equals(true)){
        out.println("<p>Błędne dane logowania!</p>");
    }
%>
</body>
</html>
