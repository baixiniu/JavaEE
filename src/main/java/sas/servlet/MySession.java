package sas.servlet;

import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "MySession",urlPatterns = "/MySession")
public class MySession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        session.setAttribute("sessionID",session.getId());
        //System.out.println(session.getId());
        String sessionID=session.getId();
        System.out.println(sessionID);
        Cookie cookie2=new Cookie("sessionID",sessionID);
        cookie2.setPath("/jsp/sessionDemo");
        cookie2.setMaxAge(3600);
        cookie2.setSecure(true);
        //关于这个属性的设置详见百度，我个人认为有阅读的必要
        response.addCookie(cookie2);
        //response.getWriter().write("success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
