package c21_thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Lift implements Runnable {
	private int floor;
	//private int[] end;//�ͻ�Ŀ������飻
	private ArrayList<Customer> wait_up;//�ȴ��Ķ���
	private ArrayList<Customer> wait_down;
	///private ArrayList<Customer> c_inside;//�����ڵĿͻ�
	private ArrayList<Customer> targets;//�����ڿͻ��Լ���Ӧ����Ҫ
	private final int max_floor=10;
	private boolean up=true;
	private int next_target=0;
	Lift(){
		wait_up=new ArrayList<Customer>();
		wait_down=new ArrayList<Customer>();
		targets=new ArrayList<Customer>();
		floor=1;
	}
	public int get_floor(){
		return floor;
	}
	public void inc(){
		floor++;
	}
	public void dec(){
		floor--;
	}
	public List<Customer> get_up(){
		return wait_up;
	}
	public List<Customer> get_down(){
		return wait_down;
	}
	public List<Customer> get_list(){
		return targets;
	}
	public void show(){
		System.out.println(get_floor());
	}
	public void up(int target) throws InterruptedException{
		for(int now=get_floor();now==target;now++){
			TimeUnit.MILLISECONDS.sleep(1);
			inc();
			show();
		}
	}
	public void down(int target) throws InterruptedException {
		for(int now=get_floor();now==target;now--){
			TimeUnit.MILLISECONDS.sleep(1);
			dec();
			show();
		}
	}
	public void on(int target) throws InterruptedException{
		notifyAll();
		if(get_floor()<target) up(target);
		else if(get_floor()==target) down(1);
		else down(target);
	}
	//�������Ϸ��Ƿ����˵ȴ���������-��up�й�
	public boolean people_allow_up(){
		int i=0,max=0;
		while(i<wait_up.size()){
			max=max>wait_up.get(i).get_now()?max:wait_up.get(i).get_now();
		}
		return floor<max?true:false;
	}
	//�������Ϸ�����Ҫ��¥����-��up�й�
	public boolean people_allow_down(){
		int i=0,max=0;
		while(i<wait_down.size()){
			max=max>wait_down.get(i).get_now()?max:wait_down.get(i).get_now();
		}
		return floor<max?true:false;
	}
	//�������·��Ƿ����˵ȴ������½�-��down�й�
		public boolean people_allow_up_1(){
			int i=0,min=20;
			while(i<wait_down.size()){
				min=min<wait_down.get(i).get_now()?min:wait_down.get(i).get_now();
			}
			return floor>min?true:false;
		}
	//�������·�����Ҫ��¥����-��down�й�
		public boolean people_allow_down_1(){
			int i=0,min=20;
			while(i<wait_up.size()){
				min=min<wait_up.get(i).get_now()?min:wait_up.get(i).get_now();
			}
			return floor>min?true:false;
		}
	//���е���ͻ��Ƿ�ȫ���������
	public boolean customer_standby(){
		if(up){
			if(wait_up.isEmpty())return true;
			for(Customer c:wait_up){
				if (c.get_now()==floor) return false;
			}
		}else{
			if(wait_down.isEmpty())return true;
			for(Customer c:wait_down){
				if (c.get_now()==floor) return false;
			}
		}
		return true;
	}
	public int next_up(){
		//ȷ�����ݵ���һ��ͣ��λ��
		int i=0,next=0;
		if(people_allow_up()||!targets.isEmpty()){
			if(people_allow_up()&&!targets.isEmpty()){
				int min=20;//��֤��һ������������ֵһ���ȳ�ʼminС���Ӷ����min��
				while(i<wait_up.size()){
					if(wait_up.get(i).get_now()>floor){
						min=min<wait_up.get(i).get_now()?min:wait_up.get(i).get_now();
					}
					i++;
				}
				next=min<targets.get(0).get_target()?min:targets.get(0).get_target();
			}else if(people_allow_up()&&targets.isEmpty()){
				int min=20;
				while(i<wait_up.size()){
					if(wait_up.get(i).get_now()>floor){
						min=min<wait_up.get(i).get_now()?min:wait_up.get(i).get_now();
					}
					i++;
				}
				next=min;
			}else {
				next=targets.get(0).get_now();
			}
			
		}else{
			int max=0;
			while(i<wait_down.size()){
				if(wait_down.get(i).get_now()>floor){
					max=max>wait_up.get(i).get_now()?max:wait_up.get(i).get_now();
				}
				i++;
			}
			next=max;
		}
		return next;
	}
	public int next_down(){
		//ȷ�����ݵ���һ��ͣ��λ��
		int i=0,next=0;
		if(people_allow_down_1()||!targets.isEmpty()){
			if(people_allow_down_1()&&!targets.isEmpty()){
				int max=0;//��֤��һ������������ֵһ���ȳ�ʼminС���Ӷ����min��
				while(i<wait_up.size()){
					if(wait_up.get(i).get_now()<floor){
						max=max>wait_up.get(i).get_now()?max:wait_up.get(i).get_now();
					}
					i++;
				}
				next=max>targets.get(targets.size()-1).get_target()?max:targets.get(targets.size()-1).get_target();
			}else if(people_allow_down_1()&&targets.isEmpty()){
				int max=0;//��֤��һ������������ֵһ���ȳ�ʼminС���Ӷ����min��
				while(i<wait_up.size()){
					if(wait_up.get(i).get_now()<floor){
						max=max>wait_up.get(i).get_now()?max:wait_up.get(i).get_now();
					}
					i++;
				}
				next=max;
			}else {
				next=targets.get(targets.size()-1).get_now();
			}
			
		}else{
			int min=20;
			while(i<wait_up.size()){
				if(wait_up.get(i).get_now()<floor){
					min=min<wait_up.get(i).get_now()?min:wait_up.get(i).get_now();
				}
				i++;
			}
			next=min;
		}
		return next;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			//����������,�������е�����
			while(!wait_up.isEmpty()||!wait_down.isEmpty()||!targets.isEmpty()){
//				while(!customer_standby()){
//					try {
//						wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
				//������������ֹ����
				while(people_allow_up()||!targets.isEmpty()||people_allow_down()){
					while(!customer_standby()){
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					next_target=next_up();//�����һ��ͣ��λ��
					//��������
					try {
						up(next_target);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					notifyAll();//����Ŀ�ĵغ�֪ͨ�����ͻ����ȴ��ͻ�ȫ���������
					
				}//��������
				up=false;
				//�����½�����ֹ����
				while(people_allow_down_1()||!targets.isEmpty()||people_allow_up_1()){
					next_target=next_down();//�����һ��ͣ��λ��
					try {
						down(next_target);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//�����½�
					notifyAll();//����Ŀ�ĵغ�ȴ��ͻ�ȫ���������
					while(!customer_standby()){
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}//�½�����
				up=true;
			}System.out.println("young");
		}
	}

}
