package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet3 extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer sum=(Integer) request.getAttribute("sum");
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Request</TITLE></head>");
	    out.println("<body>");
	    out.write("num1£º"+request.getAttribute("num11")+"/nnum2£º"+request.getAttribute("num22")+"/nsum£º"+sum);
	    out.println("</body></html>");
		out.close();
	}
 
}
