<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NHN Mart - 로그인 성공</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession(false);
    String id = httpSession.getAttribute("id").toString();
    String money = config.getServletContext().getAttribute("money").toString();
%>
<p>로그인 성공</p><br />
<p><%= id %> 님 환영합니다.</p><br />
<p>잔고: <%= money %></p><br />
<a href="/logout.do">로그아웃</a><br />
<a href="/init">초기화</a><br />
<a href="/foods.do">상품 목록</a><br />
</body>
</html>
