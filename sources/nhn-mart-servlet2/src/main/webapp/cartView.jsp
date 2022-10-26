<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>NHN Mart - 장바구니 목록</title>
</head>
<body>

<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
    <p><fmt:message key="list"/>: <fmt:message key="onionName"/> ${applicationScope.cartOnion} <fmt:message key="ea"/>,
        <fmt:message key="eggName"/> ${applicationScope.cartEgg} <fmt:message key="box"/>,
        <fmt:message key="greenOnionName"/> ${applicationScope.cartGreenOnion} <fmt:message key="ea"/>,
        <fmt:message key="appleName"/> ${applicationScope.cartApple} <fmt:message key="ea"/>
    </p><br/>
    <p><fmt:message key="totalPrice"/>: ${requestScope.sum}</p><br/>
    <p>----<fmt:message key="paymodal"/>----</p>
    <form method="post" action="/pay.do">
        <fmt:message key="onionName"/>: <input type="text" name="pay" value="${applicationScope.cartOnion}"
                                               readonly><br/>
        <fmt:message key="eggName"/>: <input type="text" name="pay" value="${applicationScope.cartEgg}" readonly><br/>
        <fmt:message key="greenOnionName"/>: <input type="text" name="pay" value="${applicationScope.cartGreenOnion}"
                                                    readonly><br/>
        <fmt:message key="appleName"/>: <input type="text" name="pay" value="${applicationScope.cartApple}"
                                               readonly><br/>
        <fmt:message key="totalPrice"/>: <input type="text" name="pay" value="${requestScope.sum}" readonly><br/>
        <br/>
        <input type="submit" value="<fmt:message key="doPay"/>">
    </form>
    <a href="/foods.do"><fmt:message key="foodList"/></a>
</fmt:bundle>
</body>
</html>
