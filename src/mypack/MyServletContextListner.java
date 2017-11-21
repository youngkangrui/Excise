package mypack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListner implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext context=sce.getServletContext();
		Counter counter=(Counter) context.getAttribute("counter");
			try {
				if(counter!=null){
					String filepath=context.getRealPath("/count");
					filepath+="/count.txt";
					PrintWriter pw=new PrintWriter(filepath);
					pw.println(counter.getNum());
					pw.close();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("应用已经启动");
		ServletContext context=sce.getServletContext();
		BufferedReader reader=new BufferedReader(new InputStreamReader(context.getResourceAsStream("/count/count.txt")));
		try {
			int count=Integer.parseInt(reader.readLine());
			reader.close();
			Counter counter=new Counter(count);
			context.setAttribute("counter", counter);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
