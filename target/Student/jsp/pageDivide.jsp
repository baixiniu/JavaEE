<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/1
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("UTF-8");
    //此方法对GET无效，对解决提交方式中文乱码问题，更多的是使用过滤器，这里暂不考虑
%>
<html>
<head>
    <title>JSP分页</title>
</head>
<body>
    <div class="paging">
        <a class="button" href="">上一页</a>
        <a href="#">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a class="button" href="">下一页</a>
        <p>共<span>5</span>页&nbsp到第
            <input type="text" name="">
            <p style="margin:2px -1px 0 10px;">页</p>
            <input class="button" type="submit" value="确认">
        </p>
    </div>
</body>
</html>
