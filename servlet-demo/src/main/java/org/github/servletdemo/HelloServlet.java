package org.github.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hewenji
 * @Date 2022/10/16 17:20
 * 打开IDE的edit configuration, 然后选择tomcat, 配置tomcat: D:\Project\apache-tomcat-9.0.55, 然后就能部署运行了。
 * 这个技术没啥用，过时了。用不上
 */
public class HelloServlet extends HttpServlet {

    private String message;

    @Override
    public void init() throws ServletException
    {
        // 执行必需的初始化
        message = "Hello World";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>" + message + "</h1>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
