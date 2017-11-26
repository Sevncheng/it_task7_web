<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017\10\12 0012
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script>
</script>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">欢迎来到登录页面</h1>
<hr/>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <table align="center" border="2" cellpadding="0" cellspacing="0">
            <tr>
                <td  align="center">用户名</td>
                <td  align="center"><input type="text" name="studentName"></td>
            </tr>
            <tr>
                <td  align="center">用户密码</td>
                <td  align="center"><input type="password" name="studentPassword"></td>
            </tr>
            <tr><td colspan="2" align="center"><input type="submit" value="登录!"></td></tr>
        </table>
    </form>
    <hr/>
    <div align="center"><a href="${pageContext.request.contextPath}/studentUI">前往注册!</a></div>
    <div align="center"><a href="${pageContext.request.contextPath}/">返回首页!</a></div>
</table>
</body>
</html>
