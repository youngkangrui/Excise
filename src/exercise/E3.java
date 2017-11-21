package exercise;

public class E3 implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E3[] x=new E3[10];
		for(E3 e:x){
			e=new E3();
			Thread t=new Thread(e);
			t.start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		E2 e=E2.get_instance();
		System.out.println(e);
	}

}
