package exercise;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;

public class UploadServlet implements Servlet {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("has been initialed");
	}

	@Override
	public void service(byte[] buffer, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		String request=new String(buffer);
		String headrequest=request.substring(request.indexOf("\r\n")+2, request.indexOf("\r\n\r\n"));
		BufferedReader br=new BufferedReader(new StringReader(headrequest));
		String data=null;
		String boundary=null;
		while((data=br.readLine())!=null){
			if(data.indexOf("Content-Type")!=-1){
				boundary=data.substring(data.indexOf("boundary=")+9, data.length())+"\r\n";
				break;
			}
		}
		if(boundary==null){
			out.write("HTTP/1.1 200 OK\r\n".getBytes());
			out.write("Content-Type:text/html\r\n\r\n".getBytes());
			out.write("Upload failed".getBytes());
			return;
		}
		int index1=request.indexOf(boundary);
		int index2=request.indexOf(boundary, index1+boundary.length());
		int index3=request.indexOf(boundary, index2+boundary.length());
		int beforefile=request.indexOf("\r\n\r\n",index2)+3;
		int afterfile=index3-4;
		int line1=request.indexOf("\r\n",index2+boundary.length());
		String filepart=request.substring(index2+boundary.length(),line1);
		String name=filepart.substring(filepart.lastIndexOf("\\")+1, filepart.length()-1);
		int len1=request.substring(0, beforefile+1).getBytes().length;
		int len2=request.substring(afterfile,request.length()).getBytes().length;
		int filelen=request.length()-len1-len2;
		FileOutputStream f=new FileOutputStream("D:\\a");
		f.write(buffer,len1,filelen);
		f.close();
		
		out.write("HTTP1/1 200 ok\r\n".getBytes());
		out.write("Content_type:text/html\r\n\r\n".getBytes());
		out.write("<html><head><title>who is the bitch? </title></head><body>".getBytes());
		out.write(new String("<h1>Uploading is finished.<br></h1>").getBytes());
		out.write(new String("<h1>Filename:"+name+"<br></h1>").getBytes());
		out.write(new String("<h1>Filelength"+filelen+"<br></h1></body></html>").getBytes());
		
}
}
