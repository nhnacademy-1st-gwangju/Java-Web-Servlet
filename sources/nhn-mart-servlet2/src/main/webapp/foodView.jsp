<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<html>
<head>
    <title>NHN Mart - 상품 목록</title>
</head>
<body>
<h3>현재 상품 재고</h3>
양파: ${requestScope.onionCount}개(1000원)<br/>
계란: ${requestScope.eggCount}판(5000원)<br/>
파: ${requestScope.greenOnionCount}개(500원)<br/>
사과: ${requestScope.appleCount}개(2000원)<br/>
<br/>
<br/>

<form method="post" action="/cart.do">
    양파: <input type="number" name="cart"><br/>
    계란: <input type="number" name="cart"><br/>
    파: <input type="number" name="cart"><br/>
    사과: <input type="number" name="cart"><br/>
    <input type="submit" value="장바구니 담기">
    </form>
</body>
</html>
