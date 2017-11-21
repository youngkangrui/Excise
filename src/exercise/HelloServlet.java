package exercise;

import java.io.OutputStream;

public class HelloServlet implements Servlet{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("servlet has been initialed");
	}

	@Override
	public void service(byte[] buffer, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		String request=new String(buffer);
		String firstline=request.substring(0, request.indexOf("\r\n"));
		String[] parts=firstline.split(" ");
		String method=parts[0];
		String uri=parts[1];
		String username=null;
		if(method.equalsIgnoreCase("Get")&&uri.indexOf("?")!=-1){
			String parameters=uri.substring(uri.indexOf("?"), uri.length());
			parts=parameters.split("&");
			username=parts[0].split("=")[1];
		}
		if(method.equalsIgnoreCase("post")){
			String content=request.substring(request.indexOf("\r\n\r\n")+4, request.length());
			if(content.indexOf("username=")!=-1){
				parts=content.split("&");
				username=parts[0].split("=")[1];
			}
		}
		out.write("HTTP1/1 200 ok\r\n".getBytes());
		out.write("Content_type:text/html\r\n\r\n".getBytes());
		out.write("<html><head><title>who is the bitch? </title></head><body>".getBytes());
		out.write(new String("<h1>GO HELL<br>"+username+"</h1></body></html>").getBytes());
	}

}
