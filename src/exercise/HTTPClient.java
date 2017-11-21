package exercise;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class HTTPClient {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String uri="question/563613118.html";
		if(args.length!=0)uri=args[0];
		doGet("zhidao.baidu.com",80,uri);
	}
	private static void doGet(String host, int port, String uri) throws InterruptedException {
		// TODO Auto-generated method stub
		Socket socket=null;
		try {
			socket=new Socket(host,port);
		} 
	    catch (IOException e) {e.printStackTrace();}
		try {
			//��������
			StringBuilder sb=new StringBuilder("GET "+uri+" HTTP/1.1\r\n");//��ͷ
			sb.append("where is my cat?");
			OutputStream socketout=socket.getOutputStream();
			socketout.write(sb.toString().getBytes());
			Thread.sleep(2000);
			InputStream socketin=socket.getInputStream();
			int size=socketin.available();
			byte[] buffer=new byte[size];
			socketin.read(buffer);
			System.out.println(new String(buffer));
		} 
	    catch (IOException e) {e.printStackTrace();}
		finally{
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
