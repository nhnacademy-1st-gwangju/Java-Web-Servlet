<%@ page import="java.util.Objects" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<html>
<head>
    <title>NHN Mart</title>
</head>
<body>
<%
    HttpSession session = request.getSession(false);
    String money = null;
    String id = null;
    if (!Objects.isNull(session)) {
        money = config.getServletContext().getAttribute("money").toString();
        id = session.getAttribute("id").toString();
    }
%>
<h1>NHN 마트에 오신 것을 환영합니다.</h1>
<a href="/init">초기화</a><br/>
<a href="/foods.do">상품 목록</a><br/>
<a href="/cart.do">장바구니</a><br/>
<p>현재 언어: </p><br/>
<%
    if (money != null) {
%>
<p><%= id %>님 환영합니다</p><br/>
<p>잔고: <%= money %></p><br/>
<%
    }
%>
</body>
</html>
