package c21_thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService exec=Executors.newCachedThreadPool();
//		for(int i=5;i>0;i--)
//		exec.execute(new Liftoff());
//		exec.shutdown();
		Thread t=new Thread(new Liftoff(5));
//		t.setDaemon(true);
		t.setPriority(Thread.MAX_PRIORITY);
		t.setName("NO.1");
//		t.start();
//		t.setDaemon(true);
//		exec.execute(new Liftoff(5));
//		exec.execute(new Liftoff(5));
		//exec.shutdown();
		Thread.currentThread().setName("i'm the main function");
		System.out.println(Thread.currentThread());
		//System.out.println(exec.shutdownNow());
//		exec.shutdown();
		//TimeUnit.MILLISECONDS.sleep(100);
//		List<Customer> a=new ArrayList<Customer>();
//		a.add(new Customer(1,7));
//		a.add(new Customer(1,9));
//		a.add(new Customer(1,3));
//		for(Customer c:a){System.out.println(c.get_target());}
//		Collections.sort(a);
//		for(Customer c:a){System.out.println(c.get_target());}
//		System.out.println(a);
		List<String> a=new ArrayList<String>();
		//a.add("young");
		a.add("kang");
		String x="young";
		a.add(x);
		a.remove(x);
		for(String s:a)System.out.println(s);
		Lift L=new Lift();
		Liftoff l=new Liftoff(5);
		System.out.println(L.get_up());
		Customer c1=new Customer(1,4,L);
		System.out.println(L.get_list());
		//exec.execute(c1);
		//exec.execute(c1);
		Num n=new Num();
//		exec.execute(new T1(n));
//		exec.execute(new T2(n));
//		exec.execute(new T2(n));
//		TimeUnit.SECONDS.sleep(1);
		int[] a1={1};
		System.out.println(a1.length);
		a1[1]=5;
	}

}
