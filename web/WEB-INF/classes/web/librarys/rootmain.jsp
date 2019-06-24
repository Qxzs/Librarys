<%@ page import="po.users" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
<title>document</title>
    <link href="../css/rootmain.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<%
    users user = (users) session.getAttribute("user");

%>
<div id="rootmain">
    <div class="nav">
        <h3>管理员</h3>
        <p class="name"><%=user.getUsername()%></p>
        <a href="${pageContext.request.contextPath }/outs">退出</a>
    </div>
</div>
<div id="con">
    <div class="sidebar">
        <button id="find" onclick="findBooks()" value="book">图书管理</button>
        <button onclick="findUser()">读者管理</button>
        <button onclick="toIndex()">图书添加</button>
        <%--<button onclick="toIndex1()">读者添加</button>--%>
    </div>
    <div class="action">
        <form>
            <input type="text" name="name" id="name" />
            <span><input type="radio" value="0" name="chos" checked/>书名</span>
            <span><input type="radio" value="1"name="chos"/>用户</span>
            <input type="button" value="搜索" onclick="searchs()"/>
        </form>
    </div>
    <div class="show">
        <c:if test="${!empty sessionScope.book}">
        <table border="1" cellpadding="10" cellspacing="0" class="tabbs" id="tab1">
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
                </tr>
            </c:forEach>
        </table>
            </c:if>

        <c:if test="${!empty sessionScope.listbook}">
            <table border="1" cellpadding="10" cellspacing="0" class="tabbs" id="tabBook">
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
                    <th>操作</th>
                </tr>
                </thead>
                <c:forEach items="${sessionScope.listbook.lists}" var="u">
                    <tr>
                        <td>${u.book_id}</td>
                        <td>${u.book_name}</td>
                        <td>${u.book_face }</td>
                        <td>${u.book_create}</td>
                        <td>${u.book_num}</td>
                        <td>${u.book_author}</td>
                        <td>${u.book_press}</td>
                        <td>${u.book_address}</td>
                        <td><button onclick=updateBooks(${u.book_id})>更新</button></td>
                        <td><button onclick=delBooks(${u.book_id})>删除</button></td>
                    </tr>
                </c:forEach>
            </table>
            <table  border="0" cellspacing="0" cellpadding="0"  width="900px">
                <tr>
                    <td class="td2">
                        <span>第${sessionScope.listbook.currPage }/ ${sessionScope.listbook.totalPage}页</span>
                        <%--<span>总记录数：${sessionScope.listbook.totalCount }  每页显示:${sessionScope.listbook.pageSize}</span>--%>
                        <select id="ttts">
                            <option value="2">2</option>
                            <option value="4">4</option>
                            <option value="6">6</option>
                        </select>
                        <span>

       <c:if test="${sessionScope.listbook.currPage != 1}">
           <a href="${pageContext.request.contextPath }/findbooks?currentPage=1">[首页]</a>
           <a href="${pageContext.request.contextPath }/findbooks?currentPage=${sessionScope.listbook.currPage-1}">[上一页]</a>
       </c:if>

       <c:if test="${sessionScope.listbook.currPage != sessionScope.listbook.totalPage}">
           <a href="${pageContext.request.contextPath }/findbooks?currentPage=${sessionScope.listbook.currPage+1}">[下一页]</a>
           <a href="${pageContext.request.contextPath }/findbooks?currentPage=${sessionScope.listbook.totalPage}">[尾页]</a>
       </c:if>
   </span>
                    </td>
                </tr>
            </table>
        </c:if>
            <c:if test="${!empty sessionScope.listusers}">
            <table border="1" cellpadding="10" cellspacing="0" class="tabbs" id="findTabuser">
                <thead>
                <tr>
                    <th>id</th>
                    <th>用户名</th>
                    <th>地位</th>
                    <th>性别</th>
                    <th>班级</th>
                    <th>联系方式</th>

                </tr>
                </thead>
                <c:forEach items="${sessionScope.listusers}" var="u1">
                    <tr>
                        <td>${u1.id}</td>
                        <td>${u1.username}</td>
                        <td>${u1.statue }</td>
                        <td>${u1.sex}</td>
                        <td>${u1.classs}</td>
                        <td>${u1.tel}</td>

                    </tr>
                </c:forEach>
            </table>
            </c:if>

        <c:if test="${!empty sessionScope.listuser}">
        <table border="1" cellpadding="10" cellspacing="0" id="tabUser" class="tabbs">
            <thead>
            <tr>
                <th>id</th>
                <th>用户名</th>
                <th>地位</th>
                <th>性别</th>
                <th>班级</th>
                <th>联系方式</th>
                <th>授权</th>
                <th>操作</th>
            </tr>
            </thead>
            <c:forEach items="${sessionScope.listuser.lists}" var="u1">
                <tr>
                    <td>${u1.id}</td>
                    <td>${u1.username}</td>
                    <td>${u1.statue}</td>
                    <td>${u1.sex}</td>
                    <td>${u1.classs}</td>
                    <td>${u1.tel}</td>
                    <td><button onclick=updateuserss(${u1.id})>授权</button></td>
                    <td><button onclick=delusers(${u1.id})>删除</button></td>
                </tr>
            </c:forEach>
        </table>
            <table  border="0" cellspacing="0" cellpadding="0"  width="900px" >
                <tr>
                    <td class="td2">
                        <span>第${sessionScope.listuser.currPage }/ ${sessionScope.listuser.totalPage}页</span>
                        <%--<span>总记录数：${sessionScope.listuser.totalCount }  每页显示:${sessionScope.listuser.pageSize}</span>--%>
                        <select id="tts">
                            <option value="2">2</option>
                            <option value="4">4</option>
                            <option value="6">6</option>
                        </select>
                        <span>
       <c:if test="${sessionScope.listuser.currPage != 1}">
           <a href="${pageContext.request.contextPath }/findusers?currentPage=1">[首页]</a>
           <a href="${pageContext.request.contextPath }/findusers?currentPage=${sessionScope.listuser.currPage-1}">[上一页]</a>
           <c:if test="${sessionScope.listuser.currPage == sessionScope.listuser.totalPage}">
           <a readonly="readonly" style="color: gray">[下一页]</a>
           </c:if>
       </c:if>

       <c:if test="${sessionScope.listuser.currPage != sessionScope.listuser.totalPage}">
           <a href="${pageContext.request.contextPath }/findusers?currentPage=${sessionScope.listuser.currPage+1}">[下一页]</a>
           <a href="${pageContext.request.contextPath }/findusers?currentPage=${sessionScope.listuser.totalPage}">[尾页]</a>
       </c:if>
   </span>
                    </td>
                </tr>
            </table>
        </c:if>


    </div>
</div>

<script src="../js/rootmain.js"></script>
</body>
</html>