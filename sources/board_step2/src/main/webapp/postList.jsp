<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>NHN Board - 게시글 목록 페이지</title>
</head>
<body>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
<h1><fmt:message key="postlist"/></h1>
<table>
    <tr>
        <th><fmt:message key="posttitle"/></th>
        <th><fmt:message key="postwriter"/></th>
    </tr>
    <c:forEach var="item" items="${requestScope.posts.list}">
        <tr>
            <td><a href="/postInfo.do?id=${item.id}">${item.title}</a></td>
            <td>${item.writerUserId}</td>
        </tr>
    </c:forEach>
</table>
    <c:forEach begin="1"
               end="${requestScope.posts.totalPageCount}" var="idx">
        <li<c:out value="idx" />>
            <a href="/posts/view.do?page=${idx}">${idx}</a>
        </li>
    </c:forEach>
<br />
<a href="/main.jsp"><fmt:message key="home"/></a>
</fmt:bundle>
</body>
</html>
