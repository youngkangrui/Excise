package mypack;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;;
public class RequestInfoServletsssss extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>res</title></head>");
		out.println("<body>");
		out.println("hello young,it's joey!");
		out.println("</body></html>");
		out.close();
	}
}
