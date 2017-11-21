package mypack;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet{


	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer num11=(Integer) request.getAttribute("num11");
		Integer num22=(Integer) request.getAttribute("num22");
		Integer total=num11+num22;
		request.setAttribute("sum", total);
		ServletContext context=getServletContext();
		RequestDispatcher dispatcher=context.getRequestDispatcher("/Servlet3");
		dispatcher.forward(request, response);
	}
 
}
