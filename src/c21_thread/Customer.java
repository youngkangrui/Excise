package c21_thread;

import java.util.Collections;

public class Customer implements Comparable<Customer>,Runnable {
	private int target;
	private int now;
	private boolean up;
	private Lift lift;
	public int get_target(){
		return target;
	}
	public int get_now(){
		return now;
	}
	Customer(int now,int x,Lift li){
		target=x;
		lift=li;
		this.now=now;
		if(now<target) {
			up=true;
			lift.get_up().add(this);
		}
		else {
			up=false;
			lift.get_down().add(this);
			}
		  
	}
	public void enter_and_press(){
		if(up) lift.get_up().remove(this);
		else   lift.get_down().remove(this);
		lift.get_list().add(this);
		Collections.sort(lift.get_list());
	}
	public void getout(){
		lift.get_list().remove(this);
	}
	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		return target>o.target?1:(target==o.target?0:-1);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(lift.get_floor()!=now&&lift.get_list().size()>10){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		enter_and_press();
		notifyAll();
		while(lift.get_floor()!=target){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getout();
	}
}
