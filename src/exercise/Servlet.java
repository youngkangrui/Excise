package exercise;

import java.io.OutputStream;

public interface Servlet {
	public void init();
	public void service(byte[] buffer,OutputStream out)throws Exception;
}
