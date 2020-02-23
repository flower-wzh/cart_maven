<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style type="text/css">
        .c1{ text-align:right ;margin-right:50px }
        .c2{ text-align:right ;margin-right:50px ; color:blue; font-size:150% }
        body{ background-image:url("${pageContext.request.contextPath}/image/2.jpg");background-repeat:repeat }
        span{ font-size:30px; color:red; font-weight:bolder;margin-left:200px }
        .f{ width:150px; height:70px}
        .d{ text-align:center; word-spacing:20px;width:70%}
        img{ border:none }
        .b{ background-color:yellow;
            background-image:url("${pageContext.request.contextPath}/image/button12.gif") ;
            width:60px;height:30px; border:none
        }
    </style>
</head>
<body>&nbsp;

<!-- Title -->
<img src="${pageContext.request.contextPath}/image/zgc_px.jpg" align="middle" class="f"/>
<span>欢迎访问我的购物网站</span>
<hr/>

<div class="c2"> 欢迎Luxw </div>

<!--  Menu Bar  -->
<center>
    <div class="d">
        <a href="QueryProductView.html"><img src="${pageContext.request.contextPath}/image/index.gif"/></a>
        <a href="UserManageView.html"><img src="${pageContext.request.contextPath}/image/reg.gif"/></a>
        <a href="${pageContext.request.contextPath}/cart.jsp"><img src="${pageContext.request.contextPath}/image/cart.gif"/></a>
        <a href=""><img src="${pageContext.request.contextPath}/image/order.gif"/></a>
        <a href="LoginView.html"><img src="${pageContext.request.contextPath}/image/exit.gif"/></a>
    </div>
</center>

<!--  按条件搜索表单 -->
<center>
    <form action="" method="post">
        ProductName:<input type="text" name="productName"/>&nbsp;
        Price:<select name="opt">
        <option value="1">小于</option>
        <option value="2">大于</option>
    </select>
        <input type="text" name="price" size="6" /> &nbsp;&nbsp;
        <input type="submit"   value="" class="b"/>
    </form>
</center>

<table border="1" bordercolor="blue" cellspacing=0 align="center" width="70%">
    <tr align="center" bgcolor="lightblue">
        <td><b>Id</b></td>
        <td><b>Name</b></td>
        <td><b>图片</b></td>
        <td><b>Price</b></td>
        <td><b><img src="${pageContext.request.contextPath}/image/car_new.gif"/></b></td>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr align="center">
            <td>${product.product_id}</td>
            <td>${product.name}</td>
            <td><img src="${pageContext.request.contextPath}/image/product/cover.gif"/></td>
            <td>${product.count}</td>
            <td align="center"><a href="${pageContext.request.contextPath}/cart/cart_addProduct?productId=${product.product_id}"><img src="${pageContext.request.contextPath}/image/car_new.gif"/></a></td>
        </tr>
    </c:forEach>
</table>
<p>&nbsp;</p>

<!-- 分页 -->
<center>
    <c:if test="${index>1}">
        <a href="${pageContext.request.contextPath}/product/queryProducts?index=${index-1}">上一页</a>
    </c:if>
    这是第 <font color="red">${index}</font> 页
    &nbsp;
    <c:if test="${index < page}">
        <a href="${pageContext.request.contextPath}/product/queryProducts?index=${index+1}">下一页</a>
    </c:if>
    &nbsp;

</center>

</body>
</html>