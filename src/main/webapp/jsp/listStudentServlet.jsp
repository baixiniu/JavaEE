<%@ page import="java.util.List" %>
<%@ page import="sas.model.Student" %>
<%@ page import="sas.dao.impl.StudentDaoImpl" %>
<%@ page import="com.google.gson.Gson" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/2
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("UTF-8");
    //此方法对GET无效，对解决提交方式中文乱码问题，更多的是使用过滤器，这里暂不考虑
%>

<%
    StudentDaoImpl sdao=(StudentDaoImpl) request.getAttribute("studentdao");
    List<Student> students=null;
    String submit = request.getParameter("submit");
    if (submit != null && submit.equals("确定")) {
        //查询处理,这是对应了用户点击了查询按钮的情况
        //获取字符串
        String userName = request.getParameter("userName");
        System.out.println(userName);
        //调用查询结果
        students = sdao.getStudentsByName(userName);
        Gson json=new Gson();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json.toJson(students));
        //System.out.println(json.toJson(students));
    } else {
        students = sdao.getAllStudent();
        Gson json=new Gson();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json.toJson(students));
    }
%>
<%--
<html>
<head>
    <title>servlet实现返回学生信息列表</title>
</head>
<body>

</body>
</html>
--%>
