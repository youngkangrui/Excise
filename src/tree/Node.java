package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Node {
	private int data;
	private Node Lchild;
	private Node Rchild;
	Node(){
		Lchild=null;
		Rchild=null;
	}
	Node(int t){
		data=t;
	}
	public String toString(){
		Integer x=new Integer(data);
		return x.toString();
	}
	public void set_L(Node t){
		Lchild=t;
	}
	public void set_R(Node t){
		Rchild=t;
	}
	public static void preorder_(Node t){
		Node p=t;Stack<Node> s=new Stack<Node>();s.push(p);
		while(!s.isEmpty()){
			while(p!=null){
				System.out.println(p.data);
				p=p.Lchild;
				s.push(p);
				
			}
			s.pop();
			if(!s.isEmpty()){
				p=s.pop();
				s.push(p.Rchild);
				p=s.peek();
			}
		}
	}
	public static void postorder_(Node t){
		Node p=t;Stack<Node> s=new Stack<Node>();s.push(p);Node pre;
		while(!s.isEmpty()){
			p=s.peek();
			while(p!=null){
				p=p.Lchild;
				s.push(p);
			}
			s.pop();
			if(!s.isEmpty()){
				p=s.peek();
				if(p.Rchild==null){
					p=s.pop();
					System.out.println(p.data);
					pre=s.peek();
					while(pre.Rchild==p){
						s.pop();
						System.out.println(pre.data);
						p=pre;
						if(!s.isEmpty())
							pre=s.peek();
						else
							break;
					}
					s.push(null);
				}else{
					p=p.Rchild;
					s.push(p);
				}
			}	
		}
	}
	public static void inorder(Node t){
		if(t!=null){
			inorder(t.Lchild);
			System.out.println(t);
			inorder(t.Rchild);
		}
	}
	
	public static void inorder_(Node t){
		Node top=t;Stack<Node> s=new Stack<Node>();s.push(top);
		while(!s.isEmpty()){
			while(top!=null){
				s.push(top.Lchild);
				top=top.Lchild;
			}
			s.pop();
			if(!s.isEmpty()){
				top=s.pop();
				System.out.println(top);
				top=top.Rchild;
				s.push(top);
			}
		}	
	}
	public static void create(Node_c t,Queue<Integer> a){
		if(a.peek()==0){
			t.n=null;
		}
		else{
			t.n=new Node();
			t.n.data=a.poll();
			create(new Node_c(t.n.Lchild),a);
			create(new Node_c(t.n.Rchild),a);
		}
	}
	public static Node f(Node t,int i,Queue<Integer> a){
		t=new Node(100);
		i=100;
		a.poll();
		return t;
	}
	public static void main(String args[]){
		//System.out.println(new Node<String>("young"));
		Node root=new Node(1);
		root.set_L(new Node(2));
		root.set_R(new Node(3));
		root.Lchild.Lchild=new Node(4);
		root.Lchild.Rchild=new Node(5);
		//inorder(root);
		Queue<Integer> a=new LinkedList<Integer>();
		a.offer(1);
		a.offer(2);
		a.offer(0);
		a.offer(0);
		a.offer(3);
		a.offer(0);
		a.offer(0);
		//System.out.println(a.size());
		Node_c root1=new Node_c(null);
		create(root1,a);
		postorder_(root);
//		int i=1;
//		root1=f(root1,i,a);
//		System.out.println(root1+" "+i+" "+a.peek()+" "+f(root1,i,a));
//		Scanner s=new Scanner(System.in);
//		while(s.next()!="youngkangrui"){
//			System.out.println(s.next());
//		}
		
	}
}
