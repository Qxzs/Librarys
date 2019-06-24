<%@page import="po.book"%>
<%@page import="po.users"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
<title>document</title>
<link href="${pageContext.request.contextPath}/css/usermain.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>

</head>
<body>
<%
    users user = (users) session.getAttribute("user");
%>
<div id="usershow">
    <p class="name"><%=user.getUsername()%></p>
    <a href="${pageContext.request.contextPath }/updateusers?id=<%=user.getId()%>">修改个人资料</a>
    <a href="${pageContext.request.contextPath }/checkLend?id=<%=user.getId()%>">查看借书</a>
    <a href="${pageContext.request.contextPath }/outs">退出</a>
    <div id="findbook">
        <p align="center">查找</p>
        <form>
            <input type="text" name="book" id="book" />
            <br />
            <br />
            <span><input type="radio" value="0" name="chos" checked/>书名</span>
            <span><input type="radio" value="1"name="chos"/>作者</span>
            <span><input type="radio" value="2"name="chos"/>出版社</span>
            <br /><br />
            <input type="button" value="搜索" onclick="search()"/>
        </form>
    </div>
</div><%
List<book> list = (List<book>) session.getAttribute("book");%>
	<%--<%   List<book> list = (List<book>) session.getAttribute("book");--%>
         <%--if(list!=null){--%>
          <%--out.print("<table border=1>");--%>
          <%--out.print("<tr>");--%>
          <%--out.print("<th width=50>"+"序号");--%>
          <%--out.print("<th width=100>"+"书名");--%>
          <%--out.print("<th width=50>"+"简介");--%>
          <%--out.print("<th width=100>"+"出版时间");--%>
          <%--out.print("<th width=100>"+"可借数量");--%>
          <%--out.print("<th width=100>"+"出版社");--%>
          <%--out.print("<th width=100>"+"作者");--%>
          <%--out.print("<th width=100>"+"位置");--%>
          <%--out.print("<th width=100>"+"操作");--%>
          <%--out.print("</tr>");--%>
          <%--for(int i =0;i<list.size();i++){--%>
            <%--out.print("<tr>");--%>
            <%--out.print("<td >"+list.get(i).getBook_id()+"</td>"); --%>
            <%--out.print("<td >"+list.get(i).getBook_name()+"</td>");--%>
            <%--out.print("<td >"+list.get(i).getBook_face()+"</td>");--%>
            <%--out.print("<td >"+list.get(i).getBook_create()+"</td>");--%>
            <%--out.print("<td >"+list.get(i).getBook_num()+"</td>");--%>
            <%--out.print("<td >"+list.get(i).getBook_press()+"</td>");--%>
            <%--out.print("<td >"+list.get(i).getBook_author()+"</td>");--%>
            <%--out.print("<td >"+list.get(i).getBook_address()+"</td>");--%>
            <%--out.print("<td >"+list.get(i).getBook_address()+"</td>");--%>
            <%--out.print("</tr>");--%>
          <%--}--%>
          <%--out.print("</table>");--%>
           <%--}--%>
      <%--%>--%>
<c:if test="${!empty sessionScope.book}">
<table border="1" cellpadding="10" cellspacing="0" class="tabbs" id="tab1" style="margin-left: 400px">
    <thead>
    <tr>
        <th>编号</th>
        <th>书名</th>
        <th>简介</th>
        <th>日期</th>
        <th>数量</th>
        <th>作者</th>
        <th>出版社</th>
        <th>位置</th>
        <th>操作</th>

    </tr>
    </thead>
    <c:forEach items="${sessionScope.book}" var="u">
        <tr>
            <td>${u.book_id}</td>
            <td>${u.book_name}</td>
            <td>${u.book_face }</td>
            <td>${u.book_create}</td>
            <td>${u.book_num}</td>
            <td>${u.book_author}</td>
            <td>${u.book_press}</td>
            <td>${u.book_address}</td>
            <td><button onclick=lendBooks(<%=user.getId()%>,'${u.book_name}')>借书</button></td>
        </tr>
    </c:forEach>
    </c:if>
</table>
<%
    List<users> users = (List<users>)session.getAttribute("tbbook");
        if(users!=null){

        out.print("<table border=1 id='tab2'class=\"tabbs\" style=\"margin-left:500px\">");
        out.print("<tr>");
        out.print("<th width=50>"+"姓名");
        out.print("<th width=50>"+"班级");
        out.print("<th width=50>"+"联系方式");
        out.print("<th width=100>"+"书名");
        out.print("<th width=50>"+"借书日期");
        out.print("<th width=50>"+"还书日期");
        out.print("</tr>");
        for(int i =0;i<users.size();i++){
            for (int j=0;j<users.get(i).getLendbooks().size();j++) {
                out.print("<tr>");
                out.print("<td >" + users.get(i).getUsername() + "</td>");
                out.print("<td >" + users.get(i).getClasss() + "</td>");
                out.print("<td >" + users.get(i).getTel() + "</td>");
                out.print("<td >" + users.get(i).getLendbooks().get(j).getBookname() + "</td>");
                out.print("<td >" + users.get(i).getLendbooks().get(j).getLendtime() + "</td>");
                out.print("<td >" + users.get(i).getLendbooks().get(j).getBacktime() + "</td>");
                out.print("</tr>");
            }
          }
        out.print("</table>");
        }
%>
		<script>
			<%--function search(){--%>
			  <%--var name= $("#book").val();--%>
			  <%--var cho = $("input:radio:checked").val();--%>
			  <%--var str = encodeURI(name);--%>
			  <%--var cno = encodeURI(cho);--%>
			  <%--var urls ="${pageContext.request.contextPath}/search?name="+str+"&cno="+cno;--%>
			  <%--$.ajax({   --%>
			  	<%--url:urls,--%>
			  	<%--type:"get",--%>
			  	<%--contentType:"application/json;charset=utf-8",--%>
			  	<%--success:function(data){--%>
			  	    <%--if (data!=null){--%>
                        <%--window.location.href = data;--%>
                    <%--}--%>
			  	  <%--else{--%>
			  	      <%--alert("没有找到，请重新输入");--%>
                    <%--}--%>
			  	<%--}--%>
			  <%--});--%>
			<%--}--%>

			<%--function lendBooks(userid,bookname) {--%>
               <%--var mydate = new Date();--%>
               <%--var lendTime = mydate.toLocaleDateString();--%>
               <%--var backMouth = mydate.getMonth()+2;--%>
               <%--var backYear = mydate.getFullYear();--%>
               <%--var backDay = mydate.getDate();--%>
               <%--var backTime = new Date(backYear,backMouth,backDay).toLocaleDateString();--%>
               <%--var lendbook = {--%>
                   <%--"userid":userid,--%>
                   <%--"bookname":bookname,--%>
                   <%--"lendtime":lendTime,--%>
                   <%--"backtime":backTime--%>
               <%--}--%>
               <%--$.ajax({--%>
                   <%--url:"${pageContext.request.contextPath}/lend",--%>
                   <%--type:"post",--%>
                   <%--data:JSON.stringify(lendbook),--%>
                   <%--contentType:"application/json",--%>
                   <%--success:function (data) {--%>
                       <%--if (data != "1") {--%>
                           <%--alert("借书成功");--%>
                           <%--window.location.href = data;--%>
                       <%--}--%>
                       <%--else{--%>
                           <%--alert("你可能已经借了该书");--%>
                           <%--window.location.href = "../librarys/usermain.jsp";--%>
                       <%--}--%>
                   <%--}--%>

               <%--})--%>
            <%--}--%>
		</script>
<script src="../js/rootmain.js"></script>
</body>
</html>