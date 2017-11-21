package exercise;
public class ReverseArray {
	public static Node reverse(Node head){
		Node newhead = null;
		Node pre=null;
		Node now=head;
		Node next;
		while(now!=null){
			next=now.next;
			if(now.next==null) newhead=now;
			now.next=pre;
			pre= now;
			now=next;
			
		}
		return newhead;
	}
	public static Node create(int num){
		Node head=new Node(num);
		Node now=head;
		while(num-->0){
			now.next=new Node(num);
			now=now.next;
		}
		return head;
	}
	public static String arraytostring(Node head){
		Node now=head;
		StringBuilder b=new StringBuilder();
		while(now!=null){
			//b.append();
			now=now.next;
		}
		return null;
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head=create(5);
		Node head2=create(5);
		Node h=reverse(head2);
		System.out.print(h==null);
		while(h!=null){
			System.out.print(h);
			h=h.next;
		}
		StringBuilder b=new StringBuilder();
		String a="young";
	
	}

}
