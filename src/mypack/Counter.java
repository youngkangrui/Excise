package mypack;

public class Counter {
	private int num;
	Counter(){
		this(0);
	}
	Counter(int n){
		num=n;
	}
	public int getNum(){
		return num;
	}
	public void add(int i) {
		// TODO Auto-generated method stub
		num+=i;
	}
}
