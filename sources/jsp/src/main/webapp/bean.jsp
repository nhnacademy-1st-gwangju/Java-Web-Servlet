<%--
  Created by IntelliJ IDEA.
  User: hakhyeonsong
  Date: 2022/10/25
  Time: 3:47 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp bean action tag</title>
</head>
<body>
<jsp:useBean id="user1" scope="request" class="com.nhnacademy.domain.User" />
<jsp:setProperty name="user1" property="name" value="Ramos" />
<jsp:setProperty name="user1" property="age" param="aaa" />

my name is <jsp:getProperty name="user1" property="name"/>.<br />
i am <jsp:getProperty name="user1" property="age"/> years old.<br />
</body>
</html>
