package c21_thread;

import java.util.concurrent.TimeUnit;

public class Liftoff implements Runnable{
	private static int num=1;
	private int id=num++;
	private int countdown=10;
	Liftoff(){
		
	}
	Liftoff(int countdown){
		this.countdown=countdown;
		System.out.println(this);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(countdown-->0){
			if(countdown!=0){
				System.out.println("#"+id+"("+countdown+")");
				try {
					TimeUnit.MILLISECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			else System.out.println("#"+id+"Liftoff");
		}
	}

}
