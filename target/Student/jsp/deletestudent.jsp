<%@ page import="sas.model.studentExtraInfo" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/1
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("UTF-8");
    //此方法对GET无效，对解决提交方式中文乱码问题，更多的是使用过滤器，这里暂不考虑
%>
<html>
<head>
    <title>JSP删除学生信息</title>
</head>
<body>
    <%
        String stuno=request.getParameter("stuno");
        studentExtraInfo infos=new studentExtraInfo();
        if(infos.deleteStudent(stuno))
        {
            out.print("<script>alert('学生信息删除成功');window.location.href='/jsp/listStudents.jsp'</script>");
        }
        else{
            out.print("<script>alert('学生信息删除失败');window.location.href='/jsp/listStudents.jsp'</script>");
        }
    %>
</body>
</html>
