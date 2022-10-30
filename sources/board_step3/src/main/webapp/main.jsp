<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>NHN Board</title>
</head>
<body>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
<h1><fmt:message key="mainPageH1"/></h1>
  <c:choose>
    <c:when test="${sessionScope.id == 'admin'}">
      <a href="/users/view.do"><fmt:message key="userlist"/></a><br />
      <a href="/userRegister.jsp"><fmt:message key="userregister"/></a><br />
      <a href="/posts/view.do"><fmt:message key="postlist"/></a><br />
      <a href="/postRegister.jsp"><fmt:message key="postregister"/></a><br />
    </c:when>
    <c:otherwise>
      <a href="/posts/view.do"><fmt:message key="postlist"/></a><br />
      <a href="/postRegister.jsp"><fmt:message key="postregister"/></a><br />
    </c:otherwise>
  </c:choose>
<a href="/change-lang"><fmt:message key="change-lang"/></a><br/>
<a href="/logout.do"><fmt:message key="logout"/></a><br />

<p><fmt:message key="visitcount"/>: ${applicationScope.counter}</p>
<p><fmt:message key="sessioncount"/>: ${applicationScope.loginUserCount}</p>
<p><fmt:message key="currentlang"/>: ${applicationScope.lang}</p>
</fmt:bundle>
</body>
</html>
