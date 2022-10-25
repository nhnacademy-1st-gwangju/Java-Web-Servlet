<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title><%= "Title" %>
    </title>
</head>
<body>
<%= "Hello, Servlet!" %>
<c:out value="Hello, Servlet!"/>
${"Hello, Servlet!"}
<c:set var="name">Ramos</c:set>

<br />
<br />

<fmt:setLocale value="ko" />
<br/>
<fmt:setBundle basename="message" var="message" />
<br/>
<fmt:message key="greeting" bundle="${message}" />
<br/>

<fmt:bundle basename="message">
  i say dooray, you say <fmt:message key="greeting" />
</fmt:bundle>
</body>
</html>
