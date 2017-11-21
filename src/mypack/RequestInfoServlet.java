package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class RequestInfoServlet extends HttpServlet {

  /** 响应客户请求*/
  public void doGet(HttpServletRequest request,HttpServletResponse response)
         throws ServletException, IOException {
    //设置HTTP响应的正文的数据类型
    response.setContentType("text/html;charset=GB2312");
    response.addHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Expires", "0");
    /*输出HTML文档*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>Request</TITLE></head>");
    out.println("<body>");
    //打印服务器端的IP地址
    out.println("hello young it's <b>joey</b> from New York");
    out.println("<br><b>we<b> are all living in New York");
    out.println("</body></html>");
    //关闭输出流
    out.close();
  }
}
