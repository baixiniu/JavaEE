<%@ page import="java.util.Map" %>
<%@ page import="sas.model.studentExtraInfo" %>
<%@ page import="sas.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/1
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("UTF-8");
    //此方法对GET无效，对解决提交方式中文乱码问题，更多的是使用过滤器，这里暂不考虑
%>
<html>
<head>
    <title>JSP增加学生信息</title>
</head>
<body>
    <%
        studentExtraInfo infos=new studentExtraInfo();
        //引入相关信息列表，需要注意的是，需要提供缓存，不然每次都得请求
        //pageContext.setAttribute("infos",infos);
    %>
    <div>
        <form action="addstudent.jsp" method="post">
        学号：<input type="text" name="stuno"><br>
        姓名：<input type="text" name="stuname"><br>
        班级：<select name="classes">
            <%
                Map<Integer,String> temp=infos.getClasses();
                for(Integer integer:temp.keySet()){
            %>
                <option><%=temp.get(integer)%></option>
            <%
                }
            %>
            </select>
            <br>
        性别：<select name="gender">
            <%
                temp=infos.getGender();
                for(Integer integer:temp.keySet()){
            %>
            <option><%=temp.get(integer)%></option>
            <%
                }
            %>
            </select>
            <br>
        专业：<select name="major">
            <%
                temp=infos.getMajor();
                for(Integer integer:temp.keySet()){
            %>
            <option><%=temp.get(integer)%></option>
            <%
                }
            %>
            </select>
            <br>
        电话：<input type="text" name="tel"><br>
        宿舍号：<select name="dormno">
            <%
                temp=infos.getDormno();
                for(Integer integer:temp.keySet()){
            %>
            <option><%=temp.get(integer)%></option>
            <%
                }
            %>
            </select>
            <br>
        <input type="submit" name="submit">
        </form>
    </div>
<%
    String str=request.getParameter("submit");
    System.out.println(str);
    if(str!=null){
        //这里先不考虑异常情况，如学号，电话号码等重复
        Student student=new Student(request.getParameter("stuno"),
                request.getParameter("stuname"),
                request.getParameter("classes"),
                request.getParameter("gender"),
                request.getParameter("major"),
                request.getParameter("tel"),
                request.getParameter("dormno"),
                "aaaa"
                );
        if(infos.saveStudent(student))
        {
            out.print("<script>alert('学生信息添加成功');window.location.href='/jsp/listStudents.jsp'</script>");
        }
        else{
            out.print("<script>alert('学生信息添加失败');window.location.href='/jsp/listStudents.jsp'</script>");
        }
    }
%>
</body>
</html>
