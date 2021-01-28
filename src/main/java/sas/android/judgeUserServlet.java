package sas.android;

import com.google.gson.Gson;
import sas.dao.User;
import sas.dao.impl.StudentDaoImpl;
import sas.dao.userDao;
import sas.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "judgeUserServlet",urlPatterns = "/judgeUserServlet")
public class judgeUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("userName");
        String password=request.getParameter("passWord");

        //System.out.println(username+","+password);

        userDao userdao=new userDao();
        if(userdao.checkLogin(new User(username,password))){
            //类似管理员登录之后，直接查看学生信息
            StudentDaoImpl sdao = new StudentDaoImpl();
            List<Student> students=sdao.getAllStudent();
            Gson json=new Gson();
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json.toJson(students));
            //response.getWriter().write(students.toString());
            //System.out.println(username+","+password);
        }else {
            response.setContentType("application/json;charset=utf-8");
            //Gson json=new Gson();
            response.getWriter().write("fail");
            //System.out.println(json.toJson("fail"));555
        }
    }
}
