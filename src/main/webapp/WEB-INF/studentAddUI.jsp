<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017\10\13 0013
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    function sendnum() {
        var studentPhone = document.getElementById("studentPhone").value;
        if(studentPhone!=""){
          $.ajax({
              url:"${pageContext.request.contextPath}/code",
              data:{"studentPhone":studentPhone},
              type:"post",
              success: function(){
                alert("发送验证码成功!");
                document.getElementById("state").innerHTML = "抓紧时间输入,不然要过期了!"
              }
            });
        }else {
            alert("请输入您的手机号码");
        }
    }



    function check() {
        var pwd = document.getElementById("pwd").value;
        var cpwd =document.getElementById("cpwd").value;
        if(pwd!=cpwd){
            alert("两次输入密码不一致,请重新输入！");
        }
    }
    
</script>
<body>
<table>
    <h1 align="center">欢迎来到用户注册页面</h1>
    <hr/>
    <form action="${pageContext.request.contextPath}/student" method="post">
        <table align="center" border="2" cellpadding="0" cellspacing="0">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="studentName"></td>
            </tr>
            <tr>
                <td>设置密码</td>
                <td><input type="password" name="studentPassword" id="pwd"></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="checkPassword" onblur="check()" id="cpwd"></td>
            </tr>
            <tr>
                <td>手机号码</td>
                <td><input type="text" name="studentPhone" id="studentPhone"></td>
            </tr>
            <tr>
                <td id="state" colspan="2" align="center"><input type="button" value="发送验证码" onclick="sendnum()"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkNumber"></td>
            </tr>
            <tr><td colspan="2" align="center"><input type="submit" value="注册" ></td></tr>
        </table>
    </form>
    <hr/>
    <div align="center"><a href="${pageContext.request.contextPath}/">返回首页!</a></div>
</table>
</body>
</html>
