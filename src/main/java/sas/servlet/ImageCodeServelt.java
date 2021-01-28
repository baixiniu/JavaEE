package sas.servlet;

import sas.util.CreateVerificationCode;
import sas.util.CreateVerificationCodeImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ImageCodeServelt",urlPatterns = "/imageCode")
public class ImageCodeServelt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vericode= CreateVerificationCode.getSecurityCode();
        HttpSession session=request.getSession();
        session.setAttribute("verityCode",vericode);
        //设置返回的内容
        response.setContentType("img/jpeg");
        //浏览器不缓存响应内容--验证码图片，点一次就要刷新一次，所以不能有缓存出现
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        //设置验证码失效时间
        response.setDateHeader("Expires",0);
        //以字节流发过去，交给img的src属性去解析即可
        ImageIO.write(new CreateVerificationCodeImage(vericode).createImage(),"JPEG",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
