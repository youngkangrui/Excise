package c21_thread;

public class T1 implements Runnable{
	private Num n;
	T1(Num nn){
		n=nn;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			n.inc();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
