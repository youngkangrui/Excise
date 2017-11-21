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

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num1=request.getParameter("num1");
		String num2=request.getParameter("num2");
		Integer num11;
		Integer num22;
		if(num1!=null&num2!=null){
			num11=Integer.parseInt(num1); 
			num22=Integer.parseInt(num2);
			ServletContext context=getServletContext();
			RequestDispatcher dispatcher=context.getRequestDispatcher("/Servlet2");
			request.setAttribute("num11", num11);
			request.setAttribute("num22", num22);
			dispatcher.forward(request, response);
		}else{
			response.setContentType("text/html;charset=GB2312");
			PrintWriter out=response.getWriter();
			out.println("<html><head><title>Request</TITLE></head>");
		    out.println("<body>");
		    out.write("输入参数有误，请重新输入！");
		    out.println("</body></html>");
			out.close();
		}
		
	}

}
