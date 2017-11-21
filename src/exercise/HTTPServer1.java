package exercise;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class HTTPServer1 {
	private static Map Servletcache=new HashMap<String,Servlet>();
	HTTPServer1(){
		Servletcache.put("HelloServlet", new HelloServlet());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ServerSocket serversocket;
			try {
				serversocket=new ServerSocket(8080);
				System.out.println("正在监听8080端口");
				while(true){
					try{
						final Socket socket=serversocket.accept();
						System.out.println("已经建立tcp链接，该客户ip地址是："+socket.getInetAddress()+":"+socket.getPort());
						service(socket);
					}catch(Exception e){e.printStackTrace();}	
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	// 响应客户的http请求
	private static void service(Socket socket) throws Exception {
		//读入请求
			InputStream socketin=socket.getInputStream();
			Thread.sleep(500);
			int size=socketin.available();
			byte[] buffer=new byte[size];
			socketin.read(buffer);
			String request=new String(buffer);
			System.out.println(request);
			//解析请求
			String firstline=request.substring(0, request.indexOf("\r\n"));
			String[] parts=firstline.split(" ");
			String uri=parts[1];
			if(uri.indexOf("servlet")!=-1){
				String servletname=null;
				if(uri.indexOf("?")!=-1)
					servletname=uri.substring(uri.indexOf("servlet/")+8, uri.indexOf("?"));
				else
					servletname=uri.substring(uri.indexOf("servlet/")+8, uri.length());
				Servlet servlet=(Servlet) Servletcache.get(servletname);
				if(servlet==null){
					servlet=(Servlet)Class.forName("exercise."+servletname).newInstance();
					servlet.init();
					Servletcache.put(servletname, servlet);
				}
				servlet.service(buffer,socket.getOutputStream());
				Thread.sleep(500);
				socket.close();
				return;
			}
			//解析响应的正文类型
			String content_type;
			if(uri.indexOf("htm")!=-1||uri.indexOf("html")!=-1)content_type="text/html";
			else if(uri.indexOf("jpg")!=-1||uri.indexOf("jpeg")!=-1)content_type="img/jpeg";
			else if(uri.indexOf("gif")!=-1)content_type="img/gif";
			else content_type="application/octet-stream";
			//响应的正文
			String responseFirstline="HTTP1.1 200 OK"+"\r\n";
			String responsehead="content_type:"+content_type+"\r\n\r\n";
			InputStream in=HTTPServer.class.getResourceAsStream("root/"+uri);
			OutputStream socketout=socket.getOutputStream();
			socketout.write(responseFirstline.getBytes());
			socketout.write(responsehead.getBytes());
			//正文
			int len=0;
			buffer=new byte[128];
			while((len=in.read(buffer))!=-1){
				socketout.write(buffer, 0, len);
			}
			Thread.sleep(1000);
			socket.close();
	}

}
