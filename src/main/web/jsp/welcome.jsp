<%--
  ~ Copyright (c) 2020.
  ~ This file was created by Soundmate organization Lorenzo Pantano & Matteo D'Alessandro
  ~ Last Modified: 28/11/20, 13:33
  --%>

<%--
  Created by IntelliJ IDEA.
  User: lpant
  Date: 28/11/2020
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Welcome to Soundmate</title>
</head>
<body>

    <h1>Welcome <%out.print(session.getAttribute("firstName"));%> <%out.print(session.getAttribute("lastName"));%></h1>

</body>
</html>
