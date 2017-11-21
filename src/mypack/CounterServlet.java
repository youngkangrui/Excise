package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		ServletContext context=getServletContext();
		Counter counter=(Counter) context.getAttribute("counter");
		if(counter==null){
			counter=new Counter();
			context.setAttribute("counter",counter);
		}
		counter.add(1);
		response.setContentType("text/html;charset=GB2312");
	    //response.addHeader("Pragma", "no-cache");
	    //response.setHeader("Cache-Control", "no-cache");
	    //response.setHeader("Expires", "0");
	    /*���HTML�ĵ�*/
	    PrintWriter out = response.getWriter();
	    out.println("<html><head><title>Request</TITLE></head>");
	    out.println("<body>");
	    out.println("���ǵ�"+counter.getNum()+"λ���ʸ�servlet�Ŀ���");
	    out.println("</body></html>");
	    //�ر������
	    out.close();
	}
}
