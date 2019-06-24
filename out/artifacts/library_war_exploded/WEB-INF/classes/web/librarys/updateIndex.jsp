<%@ page import="po.book" %><%--
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
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/update2.css">
</head>
<body>
<%
    book book =(book) session.getAttribute("fBook");
%>
<div id="update">
    <h4 align="center">添加图书</h4>
    <form class="form-horizontal" method="get" action="${pageContext.request.contextPath}/update">
        <div class="form-group">
            <label class="col-xs-3 control-label">id</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="book_id" value="<%=book.getBook_id()%>" placeholder="id">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 control-label">书名</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="book_name" value="<%=book.getBook_name()%>" placeholder="书名">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-xs-3 control-label">简介</label>
            <textarea rows="6" cols="68" name="book_face"style="margin-left: 17px;"><%=book.getBook_face()%></textarea>
        </div>
        <div class="form-group">
            <label class="col-xs-3 control-label">出版时间</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" value="<%=book.getBook_create()%>"name="book_create" placeholder="出版时间">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 control-label">数量</label>
            <div class="col-sm-6">
                <input type="text" class="form-control"value="<%=book.getBook_num()%>" name="book_num" placeholder="数量">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 control-label">作者</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="book_author" value="<%=book.getBook_author()%>" placeholder="作者">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 control-label">出版社</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="book_press" value="<%=book.getBook_press()%>" placeholder="作者">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 control-label">位置</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" value="<%=book.getBook_address()%>" name="book_address" placeholder="位置">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="提交" class="btn btn-primary col-sm-1 left1" />
                <input type="reset" value="撤销" class="col-xs-1 left btn btn-primary" />
                <a class="btn btn-primary col-xs-1 left" href="rootmain.jsp">返回</a>
            </div>
        </div>
    </form>
</div>

</body>
</html>
