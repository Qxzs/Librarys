<%@ page import="po.book" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html; charset=gb2312" %>
<html>
<head>
<title>document</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>
    <button id="find" onclick="findBooks()" value="book">书本管理</button>
    <%
        List<book> book = (List<book>)session.getAttribute("listbook");
        if (book!=null) {
            out.print("<table border=1>");
            out.print("<tr>");
            out.print("<th width=50>"+"序号");
            out.print("<th width=100>"+"书名");
            out.print("<th width=50>"+"简介");
            out.print("<th width=100>"+"出版时间");
            out.print("<th width=100>"+"可借数量");
            out.print("<th width=100>"+"作者");
            out.print("<th width=100>"+"位置");
            out.print("<th width=100>"+"操作");
            out.print("<th width=100>"+"操作");
            out.print("</tr>");

            for(int i =0;i<book.size();i++){

                out.print("<tr>");
                out.print("<td >"+book.get(i).getBook_id()+"</td>");
                out.print("<td >"+book.get(i).getBook_name()+"</td>");
                out.print("<td >"+book.get(i).getBook_face()+"</td>");
                out.print("<td >"+book.get(i).getBook_create()+"</td>");
                out.print("<td >"+book.get(i).getBook_num()+"</td>");
                out.print("<td >"+book.get(i).getBook_author()+"</td>");
                out.print("<td >"+book.get(i).getBook_address()+"</td>");
                out.print("<td ><button onclick=updateBooks("+book.get(i).getBook_id()+")>更新</button></td>");
                out.print("<td ><button onclick=delBooks("+book.get(i).getBook_id()+")>删除</button></td>");

                out.print("</tr>");
            }
            out.print("</table>");
        }
    %>
    <a href="insertIndex.jsp">添加</a>
<script>
    //查找书本
    function findBooks() {
        var  btnVal = $("#find").val();
        var findUrl = "${pageContext.request.contextPath}/findbook?type="+btnVal;
        $.ajax({
            url:findUrl,
            type:"post",
            contentType:"application/json;charset=utf-8",
            success:function(data){
                window.location.href = "../librarys/rootmain.jsp";
            }
        })
    }
    //删除书
    function delBooks(id) {
        var delUrl = "${pageContext.request.contextPath}/delBook?id="+id;
        $.ajax({
            url:delUrl,
            type:"post",
            contentType:"application/json;charset=utf-8",
            success:function(data){
                alert("删除成功");
                window.location.href = "../librarys/rootmain.jsp";
            }
        })
    }
    //更新书本
    function updateBooks(is) {
        var updateUrl = "${pageContext.request.contextPath}/updateBooks?id="+is;
        alert(typeof (is));
        alert(updateUrl);
        $.ajax({
            url:updateUrl,
            type:"post",
            contentType:"application/json;charset=utf-8",
            success:function(data){
                alert(data);
                window.location.href = "../librarys/rootmain.jsp";

            }
        })
    }
</script>
</body>
</html>