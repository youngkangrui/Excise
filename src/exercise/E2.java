package exercise;

public class E2 implements Runnable {
	private static E2 e=null;
	private E2(){
		
	}
	public synchronized static E2  get_instance(){
		if(e==null){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e=new E2();
		}
		return e;
	}
	public void f(int x){
		x=1;
	}
	public static void main(String[] args){
		int x=0;Integer y=new Integer(9);
		System.out.println(x);
		E2 e=new E2(),e2=new E2();
		e.f(x);
		String s1=new String("x");
		String s2=new String("x");
		System.out.println(s1==s2);
		System.out.println(e+" "+e2);
		
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
