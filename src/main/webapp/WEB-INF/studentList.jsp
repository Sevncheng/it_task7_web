<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<html>
<script type="text/javascript">
</script>
<body>
<h2>亲!欢迎你   ${loginstudent.studentName}  登录</h2>
<table align="center" border="3" cellspacing="0">
    <tr>
        <td align="center">用户头像</td>
        <td align="center">用户姓名</td>
        <td align="center">用户类型</td>
        <td align="center">用户手机</td>
        <td align="center">用户邮箱</td>
    </tr>
    <c:forEach items="${studentList}" var="sl" varStatus="st">
    <tr>
        <td><img src="${sl.studentHead}" width="300" height="200"></td>
        <td width="100" align="center">${sl.studentName}</td>
        <td width="100" align="center">${sl.studentState==0?"普通用户":"至尊会员"}</td>
        <td width="100" align="center">${sl.studentPhone}</td>
        <td width="100" align="center">${sl.studentEmail==null||sl.studentEmail==""?"未绑定邮箱":sl.studentEmail}</td>
    </tr>
    </c:forEach>
</table>
<hr/>
<div align="center"><a href="${pageContext.request.contextPath}/">返回首页!</a></div>
</body>
</html>
