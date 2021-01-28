<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/15
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie演示</title>
</head>
<body>
    <h1>
        cookie
    </h1>
</body>
</html>
<script>
    alert("提交了cookie："+"<%=request.getCookies()[0].getName()%>"+","+"<%=request.getCookies()[0].getValue()%>");
</script>
