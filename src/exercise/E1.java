package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E1 {
		private int x=0;
		public void add() throws InterruptedException{
			x++;
			x++;
			Thread.sleep(1100);
		}
		public void dec(){
			x++;
			x++;
		}
		private int getnum() {
			// TODO Auto-generated method stub
			return x;
		}
		public static void main(String[] ags) throws InterruptedException, IOException{
			class A implements Runnable{
				private E1 e;
				A(E1 e){
					this.e=e;
				}
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int j=1;
					while((j--)>0){
						try {
							e.add();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							System.out.println("hi");
						}
					}
				}
			}
			class B implements Runnable{
				private E1 e;
				B(E1 e){
					this.e=e;
				}
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int j=1;
					while((j--)>0){
						e.dec();
					}
				}
			}
			/*E1 e=new E1();
			A a=new A(e);
			B b=new B(e);
			ExecutorService exe=Executors.newCachedThreadPool();
			exe.execute(a);
			exe.execute(b);
			Thread.sleep(5000);
			System.out.println(e.getnum());
		    exe.shutdownNow(); */
			String s="username=youngkangrui\r\npassword=123456";
			System.out.println(s.indexOf("oun"));
			System.out.println(s.substring(2,4));
			System.out.println(s.length());
			//System.out.println(s.split("b")[0]);
			System.out.println(s);
			System.out.println(s.indexOf("\r\n"));
			BufferedReader br=new BufferedReader(new StringReader(s));
			System.out.println(br.readLine());
			//System.out.println(br.readLine());
		}
		
}



