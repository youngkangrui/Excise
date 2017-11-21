package c21_thread;

public class T2 implements Runnable{
	private Num n;
	T2(Num nn){
		n=nn;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			n.dec();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
