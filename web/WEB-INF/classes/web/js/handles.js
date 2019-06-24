function testJson(){
    var username = $("#username").val();
    var pwd = $("#pwd").val();
    var statue = $("input:radio:checked").val();
    var ver = $("#verifyCode").val();
    var urls = "/logins?username="+username+"&pwd="+pwd+"&statue="+statue+"&verifiCode="+ver;
    alert(123123);
    alert(urls)
    $.ajax({
        url:urls,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            if(data==1){
                window.location.href = "../librarys/usermain.jsp";
            }
            else if(data ==2){
                window.location.href = "../librarys/rootmain.jsp";
            }
            else if(data == 3){
                alert("验证码错误");
                window.location.href = "../librarys/login.jsp";
                $('#verifyCodeImage').attr('src', "${pageContext.request.contextPath }/getVerifyCode"+'?t='+new Date().getTime()).show();
            }
            else{
                alert("密码或用户名错误");

                window.location.href = "../librarys/login.jsp";
            }
        }
    })

}
function changeImage() {
    $('#verifyCodeImage').attr('src', "/getVerifyCode"+'?t='+new Date().getTime()).show();
}
function toAdd() {
    window.location.href = "../librarys/insertIndex1.jsp"
}