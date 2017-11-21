package exercise;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-geneated method stub
			ServerSocket serversocket;
			try {
				serversocket=new ServerSocket(8082);
				System.out.println("服务器开始侦听");
				while(true){
					try{
						final Socket socket=serversocket.accept();
						System.out.println("正在监听"+socket.getInetAddress()+":"+socket.getPort());
						service(socket);
					}catch(IOException e){e.printStackTrace();}	
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	// ��Ӧ�ͻ���http����
	private static void service(Socket socket) throws IOException, InterruptedException {
		//��������
			InputStream socketin=socket.getInputStream();
			Thread.sleep(500);
			int size=socketin.available();
			byte[] buffer=new byte[size];
			socketin.read(buffer);
			String request=new String(buffer);
			System.out.println(request);
			//��������
			String firstline=request.substring(0, request.indexOf("\r\n"));
			String[] parts=firstline.split(" ");
			String uri=parts[1];
			//������Ӧ����������
			String content_type;
			if(uri.indexOf("htm")!=-1||uri.indexOf("html")!=-1)content_type="text/html";
			else if(uri.indexOf("jpg")!=-1||uri.indexOf("jpeg")!=-1)content_type="img/jpeg";
			else if(uri.indexOf("gif")!=-1)content_type="img/gif";
			else content_type="application/octet-stream";
			//��Ӧ������
			String responseFirstline="HTTP1.1 200 OK"+"\r\n";
			String responsehead="content_type:"+content_type+"\r\n\r\n";
			InputStream in=HTTPServer.class.getResourceAsStream("root/"+uri);
			OutputStream socketout=socket.getOutputStream();
			socketout.write(responseFirstline.getBytes());
			socketout.write(responsehead.getBytes());
			//����
			int len=0;
			buffer=new byte[128];
			while((len=in.read(buffer))!=-1){
				socketout.write(buffer, 0, len);
			}
			Thread.sleep(1000);
			socket.close();
		
	}

}
