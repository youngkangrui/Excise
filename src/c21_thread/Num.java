package c21_thread;

public class Num {
	private int x=0;
	public synchronized void inc() throws InterruptedException{
		while(true){
			while(x==1){
				wait();
			}
			x++;
			System.out.println("after inc num="+x);
			notifyAll();
		}
	}
	public synchronized void dec() throws InterruptedException{
		while(true){
			while(x==0){
				wait();
			}
			x--;
			System.out.println("after dec num="+x);
			notifyAll();
		}
		
	}
} 
