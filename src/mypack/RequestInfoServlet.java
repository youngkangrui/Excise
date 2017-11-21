package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class RequestInfoServlet extends HttpServlet {

  /** ��Ӧ�ͻ�����*/
  public void doGet(HttpServletRequest request,HttpServletResponse response)
         throws ServletException, IOException {
    //����HTTP��Ӧ�����ĵ���������
    response.setContentType("text/html;charset=GB2312");
    response.addHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Expires", "0");
    /*���HTML�ĵ�*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>Request</TITLE></head>");
    out.println("<body>");
    //��ӡ�������˵�IP��ַ
    out.println("hello young it's <b>joey</b> from New York");
    out.println("<br><b>we<b> are all living in New York");
    out.println("</body></html>");
    //�ر������
    out.close();
  }
}
