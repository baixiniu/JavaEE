package sas.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyCookie")
public class MyCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Cookie cookie=new Cookie(username,password);
        System.out.println(username+","+password);
        /*这里将账号和密码存放了进了cookie，且没有经过加密
        *之后在客户端是可以查看到cookie的
        * 但实际上就是经过加密后的密码存放在客户端也是不安全的
        * 因此一般而是把sessionID加入cookie，发送给客户端
        * sessionID是cookie较为常装载的信息，但实际上你可以定义不超过大小限制信息
         */
        //response.getWriter().write(username+","+password);
        cookie.setMaxAge(3600);


        cookie.setPath("/jsp/cookieDemo.jsp");
        //cookie.setDomain(".www.baidu.com");
        response.addCookie(cookie);
        response.sendRedirect("html/index.html");
        response.getWriter().write(cookie.getPath());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
