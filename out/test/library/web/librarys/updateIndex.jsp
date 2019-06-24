<%--
  Created by IntelliJ IDEA.
  User: lbqljl
  Date: 2019/4/17
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/update">
    书号：<input type="text" id="boo_id" disabled>
    书名：<input type="text" id="book_name">
     简介：<textarea rows="10" cols="5"></textarea>
    上架时间：<input type="text" id="book_create">
    数量：<input type="text" id="book_num">
    作者：<input type="text" id="book_author">
    位置：<input type="text" id="book_address">

</form>
</body>
</html>
