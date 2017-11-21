package exercise;//java里都是按值传递，在函数处理时都是复制形式参数，在进行处理，所以函数的行为不会改变形参的值。
//但是形参都是引用，所以可以改变引用对象类的域，从而影响形式参数的内容

import java.util.List;

public class Swap {
	static Node do_swap(Node head,Node i,Node j){
		Node t1=new Node(0);
		Node t2=new Node(0);
		Node t3=new Node(0);
		Node k=null,m=null,x=null;
		t1.next=i.next;
		i.next=t1;
		t2.next=j.next;
		j.next=t2;
		t3.next=head;
		head=t3;
		Node h=head;
		while(h!=null) {
			if(h.next==i)k=h;
			if(h.next==j)m=h;
			h=h.next;
		}
		k.next=j;
		x=j.next;
		j.next=i.next;
		m.next=i;
		i.next=x;
		j.next=t1.next;
		i.next=t2.next;
		head=t3.next;
		return head;
	} 
	//测试按引用专递
	public static void inc(int a){
		a++;
	}
	public static void main(String[] args){
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		Node now=do_swap(head, head, head.next.next);
		while(now!=null){
			System.out.println(now.val);
			now=now.next;
		}
		//测试按引用专递
		int a=5;
		inc(a);
		System.out.println(a);
	}
}
