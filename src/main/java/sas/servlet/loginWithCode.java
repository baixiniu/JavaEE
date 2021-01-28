package sas.servlet;

import sas.dao.User;
import sas.dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginWithCode",urlPatterns = "/loginWithCode")
public class loginWithCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String vericode=request.getParameter("vericode");
        String generatedCode= (String) request.getSession().getAttribute("verityCode");
        userDao sdao=new userDao();
        if (sdao.checkLogin(new User(name,password))&&vericode.toLowerCase().equals(generatedCode.toLowerCase())){
            response.getWriter().write("登录成功");
        }
        else {
            response.getWriter().write("登录失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
