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
     ����:<input type="text" name="name"><br>
     ���:<textarea rows="10" cols="10" name="face"></textarea><br>
     ����ʱ��:<input type="text" name="create"><br>
     ����:<input type="text" name="num"><br>
     ����:<input type="text" name="author"><br>
     ���λ��:<input type="text" name="address"><br>
     <input type="submit" value="�ύ">
 </form>
</body>
</html>
