package c21_thread;
import java.util.*;


class Node{
    int val;
    Node father=null;
    int len=1;
    Boolean color=false;
    int drawable=0;
    int childnum=0;
    Node(Node f){
        father=f;
    }
    Node(){
    	
    }
}

public class E6 {
	
	public static int DFS(int root,int[][] parent_child,Node[] nodes){
		int sum=0;
		if(parent_child[root][0]==0){
			if(!nodes[root].color)sum=1;
		}else{
			if(!nodes[root].color)sum++;
			for(int i=0;parent_child[root][i]!=0;i++){
				sum+=DFS(parent_child[root][i],parent_child,nodes);
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),ans=0,colorTime=0;int[][] parent_child=new int[n+1][n+1];int[] input=new int[n+1];
        Node[] nodes=new Node[n+1];
        nodes[1]=new Node();
        for(int i=2;i<n+1;i++){
            input[i]=sc.nextInt();
        	Node father=nodes[input[i]];
            father.childnum++;
            nodes[i]=new Node(father);
            nodes[i].len=father.len+1;
        }
        for(int i=1;i<n+1;i++){
        	nodes[i].val=sc.nextInt();
        	for(int j=1,x=0;j<n+1;j++){
        		if(input[j]==i){
        			parent_child[i][x++]=j;
        		}
        	}
        }
        System.out.println(DFS(1,parent_child,nodes));
	}

}
