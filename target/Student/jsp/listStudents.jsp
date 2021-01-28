<%@ page import="sas.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="sas.dao.impl.StudentDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/30
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("UTF-8");
    //此方法对GET无效，对解决提交方式中文乱码问题，更多的是使用过滤器，这里暂不考虑
%>
<html>
<head>
    <title>JSP实现展示学生列表</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
</head>
<body>
    <h1 align="center">软件工程18级学生信息表</h1>
    <hr>

    <form action="/jsp/listStudents.jsp" method="post">
        请输入姓名：<input type="text" id="userNmae" name="userName">
        <input type="submit" value="确定" id="submit" name="submit">
    </form>
    <hr>

    <table>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>班级</td>
            <td>性别</td>
            <td>专业</td>
            <td>电话</td>
            <td>舍号</td>
            <td>图片路径</td>
            <td>操作</td>
        </tr>
        <%
            String submit=request.getParameter("submit");
            StudentDaoImpl sdao=new StudentDaoImpl();
            List<Student> students=null;
            if(submit!=null&&submit.equals("确定")){
                //查询处理,这是对应了用户点击了查询按钮的情况
                //获取字符串
                String userName=request.getParameter("userName");
                System.out.println(userName);
                //调用查询结果
                students=sdao.getStudentsByName(userName);
            }else{
                students=sdao.getAllStudent();
            }
            for(Student s:students){
        %>
        <tr>
            <td><%out.print(s.getStuNo());%></td>
            <td><%out.print(s.getStuName());%></td>
            <td><%out.print(s.getClasses());%></td>
            <td><%out.print(s.getGender());%></td>
            <td><%out.print(s.getMajor());%></td>
            <td><%out.print(s.getTel());%></td>
            <td><%out.print(s.getDormNo());%></td>
            <td>
                <img src="<%out.print(s.getPhotoPath());%>" style="width: 100px;height: 100px">
            </td>

            <!-- 操作部分-->
            <td>
                <a href="addstudent.jsp?<%=s.getStuNo()%>">增加&nbsp</a>
                <a href="deletestudent.jsp?stuno=<%=s.getStuNo()%>">删除&nbsp</a>
                <a href="updatestudent.jsp?stuno=<%=s.getStuNo()%>">修改&nbsp</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
