<%--
  Created by IntelliJ IDEA.
  User: hakhyeonsong
  Date: 2022/10/25
  Time: 3:25 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
THIS IS pageContext.jsp.<br />
<%
    String type = request.getParameter("type");
    if ("include".equals(type)) {
        pageContext.include("sub.jsp");
    } else if ("forward".equals(type)) {
        pageContext.forward("sub.jsp");
    } else {
        out.println("type parameter is needed.");
    }
%>
</body>
</html>
