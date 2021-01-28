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

@WebServlet(name = "ModifyUserServlet",urlPatterns = "/modifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        userDao userdao=new userDao();
        if(userdao.modifyUser(new User(username,password))){
            Gson json=new Gson();
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json.toJson("success"));
            //response.getWriter().write(students.toString());
            System.out.println(username+","+password);
        }else{
            response.setContentType("application/json;charset=utf-8");
            //Gson json=new Gson();
            response.getWriter().write("fail");
            //System.out.println(json.toJson("fail"));
        }
    }
}
