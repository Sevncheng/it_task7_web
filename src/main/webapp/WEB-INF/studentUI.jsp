<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017\10\12 0012
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
<html>
<script  type="text/javascript">
    function sendnum() {
        var studentEmail = document.getElementById("studentEmail").value;
        if(studentEmail!=""){
            $.ajax({
                url:"${pageContext.request.contextPath}/email",
                data:{"studentEmail":studentEmail},
                type:"post",
                success: function(){
                    alert("发送验证码成功!");
                    document.getElementById("state").innerHTML = "抓紧时间输入,不然要过期了!"
                }
            });
        }else {
            alert("请输入您的邮箱地址");
        }
    }
</script>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">Hi!${loginstudent.studentName},这是你的个人主页</h1>
<hr/>
    <form action="${pageContext.request.contextPath}/student/{loginstudent.studentId}" method="post">
        <table align="center" border="2" cellpadding="0" cellspacing="0">
            <tr>
                <td align="center">用户名</td>
                <td align="center"><input type="text" name="studentName" value="${loginstudent.studentName}"></td>
            </tr>
            <tr>
                <td align="center">用户密码</td>
                <td align="center"><input type="text" name="studentPassword" value="${loginstudent.studentPassword}"></td>
            </tr>
            <tr>
                <td align="center">用户头像</td>
                <td align="center"><img src="${loginstudent.studentHead}" width="300" height="200"></td>
            </tr>
            <tr><td colspan="2" align="center"><input type="submit" value="保存"></td></tr>
            <input type="hidden" name="studentId" value="${loginstudent.studentId}">
            <input type="hidden" name="_method" value="put">
        </table>
    </form>
    <div align="center">
        <form action="${pageContext.request.contextPath}/student/head" method="post" enctype="multipart/form-data">
            <input type="file" name="file" width="120px">
            <input type="hidden" name="studentId" value="${loginstudent.studentId}">
            <input type="submit" value="上传头像">
        </form>
    </div>
<c:choose>
    <c:when test="${loginstudent.studentEmail==''||loginstudent.studentEmail==null}">
        <div align="center">
            <form action="${pageContext.request.contextPath}/student/email" method="post" >
                <table align="center" border="2" cellpadding="0" cellspacing="0">
                    <tr>
                        <td>邮箱地址</td>
                        <td><input type="text" name="studentEmail" id="studentEmail"></td>
                    </tr>
                    <tr>
                        <td id="state" colspan="2" align="center"><input type="button" value="发送验证码" onclick="sendnum()"></td>
                    </tr>
                    <tr>
                        <td>验证码</td>
                        <td><input type="text" name="checkNumber"></td>
                    </tr>
                    <tr><td colspan="2" align="center"><input type="submit" value="验证邮箱"></td></tr>
                    <input type="hidden" name="studentId" value="${loginstudent.studentId}">
                </table>
            </form>
        </div>
    </c:when>
    <c:otherwise>
        <div align="center">尊敬的会员用户您好,您的邮箱为${loginstudent.studentEmail},已安全绑定!</div>
    </c:otherwise>
</c:choose>
<hr/>
    <div align="center"><a href="${pageContext.request.contextPath}/">返回首页!</a></div>
</table>
</body>
</html>
