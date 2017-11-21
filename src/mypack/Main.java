package mypack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;




class Node{
    int val;
    Node father=null;
    int len=1;
    Boolean color=false;
    int drawable=0;
    int childnum=0;
//    List<Node> path=new LinkedList<Node>();
    Node(Node f){
        father=f;
    }
    Node(){
    	
    }
}
public class Main {
	public static void E1(){
		float s=System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
        int len1 = sc.nextInt();
        int[] nums1= new int[len1];
        for(int i=0;i<len1;i++){
            nums1[i]=sc.nextInt();
        }
        int len2 = sc.nextInt();
        int[] nums2= new int[len2];
        for(int i=0;i<len2;i++){
            nums2[i]=sc.nextInt();
        }
        int rs=0,sum=0,min=Integer.MAX_VALUE;
        for(int i = 0; i < len2-len1+1; i++){
            for(int j = 0; j < len1; j++){
                rs=nums1[j]-nums2[j+i];
                rs=rs*rs;
                sum+=rs;
            }
            min=Math.min(sum,min);
            sum=0;
        } 
        System.out.println(min);
        float e=System.currentTimeMillis();
        System.out.println(e-s);
	}
	public static void E2(){
		Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(),fucker=sc.nextInt(),now=0,count=1;
        for(int i=1;i<len;i++){
        	now=sc.nextInt();
        	if(now<=fucker){
        		count++;
        	}
        }
        int cur=0,last=0;
        while(count!=0){
        	cur++;
        	if(count%2==1)last=cur;
        	count=count>>1;
        }
        System.out.println(last-1);
	}
//	找到当前种类优惠券上一个记录的位置,s是优惠券编号
	public static int getLast(String s,Map<String,Stack<String>> ps){
		if(ps.containsKey(s)){
			return Integer.parseInt(ps.get(s).peek());
		}else{
			return -1;
		}
	}
//	找到last以后第一个？在list中的位置
	public static int getNext(int last,List<String> list){
		for(int i=0;i<list.size();i++){
			if(Integer.parseInt(list.get(i))>last){
				return i;
			}
		}
		return -1;
	}
	//计算子树中有多少没有被染色的节点
	public static int DFS(int root,int[][] parent_child,Node[] nodes){
		int sum=0;
		if(parent_child[root][0]==0){
//			if(!nodes[root].color)sum=1;
		}else{
//			if(!nodes[root].color)sum++;
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
//            father.childnum++;
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
        int max=Integer.MIN_VALUE,index=0;
        while(colorTime<n){
        	for(int i=1;i<n+1;i++){
        		if(!nodes[i].color){
        			Node temp=nodes[i];
        			nodes[i].drawable=0;
        			for(int j=0;temp!=null&&j<nodes[i].val;j++){
        				if(!temp.color)nodes[i].drawable++;
        				temp=temp.father;
        			}
            		if(nodes[i].drawable>=max){
            			if(nodes[i].drawable==max){
            				if(nodes[i].len==nodes[index].len){
            					index=DFS(i,parent_child,nodes)<DFS(index,parent_child,nodes)?i:index;
            				}else{
            					index=nodes[i].len>nodes[index].len?i:index;
            				}
            			}else{
                   			max=nodes[i].drawable;
                			index=i;
            			}
            		}
        		}
        	}
           	ans++;
            Node temp=nodes[index];
           	for(int j=0;temp!=null&&j<nodes[index].val;j++){
               	if(!temp.color){
               		temp.color=true;
               		colorTime++;
               	}
               	temp=temp.father;
            }
        	max=Integer.MIN_VALUE;
        	index=0;
        }
        System.out.println(ans);
	}
}
