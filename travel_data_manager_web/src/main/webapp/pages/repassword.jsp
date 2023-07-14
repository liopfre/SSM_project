<%--
  Created by IntelliJ IDEA.
  User: YoriStar
  Date: 2023/7/11
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
 <form action="/user/repassword" method="post">

        用户名:<input readonly="readonly" name="password" type="text" value='<security:authentication property="principal.username"/>'>
        旧密码：
        新密码:
    </form>
</body>
</html>
