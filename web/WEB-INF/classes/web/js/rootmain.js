var tab = document.getElementById("tts");
if (null != tab) {
    tab.onchange = function () {
        var index = tab.selectedIndex;
        var value = tab.options[index].value;
        // alert(value);
        value = parseInt(value)
        var findUrl = "/finduser?x=" + value;
        $.ajax({
            url: findUrl,
            type: "post",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                window.location.href = data;
            }
        })
    }
}
function searchs(){
    var name= $("#name").val();
    var cho = $("input:radio:checked").val();
    var str = encodeURI(name);
    var cno = encodeURI(cho);
    var urls ="/searchs?name="+str+"&cno="+cno;
    $.ajax({
        url:urls,
        type:"get",
        contentType:"application/json;charset=utf-8",
        success:function(data){
            if (data!=null){
                window.location.href = data;
            }
            else{
                alert("没有找到，请重新输入");
            }
        }
    });
}

//查找书本
function findBooks() {
    var  btnVal = $("#find").val();

    var findUrl = "/findbook";
    $.ajax({
        url:findUrl,
        type:"post",
        contentType:"application/json;charset=utf-8",
        success:function(data){
            window.location.href =data;
        }
    })
}
//删除书
function delBooks(id) {
    var delUrl = "/delBook?id="+id;
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
    var updateUrl = "/updateBooks?id="+is;
    $.ajax({
        url:updateUrl,
        type:"post",
        contentType:"application/json;charset=utf-8",
        success:function(data){
            window.location.href = data;

        }
    })
}

function toIndex() {
    window.location.href = "../librarys/insertIndex.jsp";
}
function toIndex1() {
    window.location.href = "../librarys/insertIndex1.jsp";
}
function findUser(){
    var furl = "/finduser";
    alert(furl);
    $.ajax({
        url:furl,
        type:"post",
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            window.location.href =data;
        }

    })
}
function delusers(id) {
    var delUrl = "/deluser?id="+id;
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
function updateuserss(id) {
    var updateUrl = "/updateuserss?id="+id;
    $.ajax({
        url:updateUrl,
        type:"post",
        contentType:"application/json;charset=utf-8",
        success:function(data){
            alert("授权成功");
            window.location.href = data;

        }
    })
}

var t = document.getElementById("ttts");
if (null!=t){
    t.onchange=function() {
        var index = t.selectedIndex;
        var value = t.options[index].value;
        // alert(value);
        value = parseInt(value)
        var findUrl = "/findbook?x="+value;
        $.ajax({
            url:findUrl,
            type:"post",
            contentType:"application/json;charset=utf-8",
            success:function (data) {
                window.location.href=data;
            }
        })
    }
}
function search(){
    var name= $("#book").val();
    var cho = $("input:radio:checked").val();
    var str = encodeURI(name);
    var cno = encodeURI(cho);
    var urls ="/search?name="+str+"&cno="+cno;
    $.ajax({
        url:urls,
        type:"get",
        contentType:"application/json;charset=utf-8",
        success:function(data){
            if (data!=null){
                window.location.href = data;
            }
            else{
                alert("没有找到，请重新输入");
            }
        }
    });
}

function lendBooks(userid,bookname) {
    var mydate = new Date();
    var lendTime = mydate.toLocaleDateString();
    var backMouth = mydate.getMonth()+2;
    var backYear = mydate.getFullYear();
    var backDay = mydate.getDate();
    var backTime = new Date(backYear,backMouth,backDay).toLocaleDateString();
    var lendbook = {
        "userid":userid,
        "bookname":bookname,
        "lendtime":lendTime,
        "backtime":backTime
    }
    $.ajax({
        url:"/lend",
        type:"post",
        data:JSON.stringify(lendbook),
        contentType:"application/json",
        success:function (data) {
            if (data != "1") {
                alert("借书成功");
                window.location.href = data;
            }
            else{
                alert("你可能已经借了该书");
                window.location.href = "../librarys/usermain.jsp";
            }
        }

    })
}

    $(".tabbs").mouseenter(function () {

        var x = $(this).attr("id");
        var tab = document.getElementById(x);
        var rows = tab.getElementsByTagName("tr");
        for (var i = 0; i < rows.length; i++) {
            rows[i].onmouseover = function () {
                this.style.color = "yellow";

            };
            rows[i].onmouseout = function () {
                this.style.color = "";
            };
        }


    })
// changeTabColor("table2")
// changeTabColor("tab2");
// changeTabColor("tab1");

