<%--
  Created by IntelliJ IDEA.
  User: lbqljl
  Date: 2019/4/17
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <form method="post" action="${pageContext.request.contextPath}/insert">
     书名:<input type="text" name="name"><br>
     简介:<textarea rows="10" cols="10" name="face"></textarea><br>
     出版时间:<input type="text" name="create"><br>
     数量:<input type="text" name="num"><br>
     作者:<input type="text" name="author"><br>
     存放位置:<input type="text" name="address"><br>
     <input type="submit" value="提交">
 </form>
</body>
</html>
