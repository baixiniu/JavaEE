package sas.servlet;

import com.google.gson.Gson;
import sas.dao.impl.StudentDaoImpl;
import sas.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="listStudentServlet",urlPatterns = "/listStudentServlet")
public class listStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().println("sssss");
        //这种情况对应了最古老的情况，反复的out.print，因此后面引入了JSP
        //现在一般对于后台的处理，即使是前后端分离，往往也是servlet+JSP实现的
        //request.getRequestDispatcher("/jsp/listStudents.jsp").forward(request,response);
        //request.getRequestDispatcher("/jsp/listStudentServlet.jsp").forward(request,response);
        //response.sendRedirect("/jsp/listStudents.jsp");


        StudentDaoImpl sdao = new StudentDaoImpl();
        request.setAttribute("studentdao",sdao);
        request.getRequestDispatcher("/jsp/listStudentServlet.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
