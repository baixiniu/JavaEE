package sas.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "Filter_01")
public class Filter_01 implements Filter {
    public void destroy() {
        System.out.println("过滤器被销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException{
        HttpServletRequest request = (HttpServletRequest) req;
        String url=request.getRequestURI();
       if(url.equals("/jsp/password.jsp"))
       {
           req.getRequestDispatcher("/html/index.html").forward(req,resp);
           System.out.println("successs");
       }
        else{
            req.getRequestDispatcher("/Filter_02").forward(req,resp);
       }
        //chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        String info=config.getInitParameter("info");
        //这个值在web.xml文件中设置
        System.out.println(info);
    }

}
