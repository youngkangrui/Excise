package c21_thread;

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
	
	

	
	public static List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> stack=new LinkedList<TreeNode>();
        List<Double> rs=new ArrayList<Double>();
        stack.offerFirst(root);
        int len_cur=1,len_next=0;double sum=0;TreeNode temp=null;
        while(!stack.isEmpty()){
            len_next=0;
            sum=0;
            for(int i=0;i<len_cur;i++){
                temp=stack.pollFirst();
                sum+=temp.val;
                if(temp.right!=null){
                    stack.offerFirst(temp.right);
                    len_next++;
                }
                if(temp.left!=null){
                    stack.offerFirst(temp.left);
                    len_next++;
                }
            }
            rs.add(sum/len_cur);
            len_cur=len_next;
        }
        return rs;
    }
    public static String solveEquation(String equation) {
        int sub=0,digit=0,sum=0,i=0,num_x=0;
        if(equation.charAt(0)=='-')equation="0"+equation;
        if(equation.charAt(equation.indexOf('=')+1)=='-')equation=equation.substring(0,equation.indexOf('=')+1)+"0"+equation.substring(equation.indexOf('=')+1);
        
        String[] elements=new String[equation.length()/2+1];
//        elements=equation.split("[+-=]");
        int s=0,j=0;
        for(int ii=0;ii<equation.length();ii++){
        	char c=equation.charAt(ii);
        	if(c=='+'||c=='-'||c=='='){
        		elements[j++]=equation.substring(s, ii++);
        		s=ii;
        	}
        }
        elements[j]=equation.substring(s);
        j=0;
        if(elements[j].charAt(elements[j].length()-1)=='x'){
        	if(elements[j].length()==1){
				num_x++;
			}else{
				num_x+=Integer.parseInt(elements[j].substring(0, elements[j].length()-1));
			}
		}else{
			sum-=Integer.parseInt(elements[j]);
			
		}
        j++;
        for(;equation.charAt(i)!='=';i++){
        	if(equation.charAt(i)=='+'||equation.charAt(i)=='-'){
        		if(elements[j].charAt(elements[j].length()-1)=='x'){
        			if(elements[j].length()==1){
        				if(equation.charAt(i)=='+')num_x++;
        				else num_x--;
        				j++;
        				continue;
        			}
        			num_x=equation.charAt(i)=='+'?num_x+Integer.parseInt(elements[j].substring(0, elements[j].length()-1)):num_x-Integer.parseInt(elements[j].substring(0, elements[j].length()-1));
        		}else{
        			sum=equation.charAt(i)=='-'?sum+Integer.parseInt(elements[j]):sum-Integer.parseInt(elements[j]);
        		}
        		j++;
        	}
        }
        if(elements[j].charAt(elements[j].length()-1)=='x'){
        	if(elements[j].length()==1){
				num_x--;
			}else{
				num_x-=Integer.parseInt(elements[j].substring(0, elements[j].length()-1));
			}
		}else{
			sum+=Integer.parseInt(elements[j]);
		}
        j++;
        for(;i<equation.length();i++){
        	if(equation.charAt(i)=='+'||equation.charAt(i)=='-'){
        		if(elements[j].charAt(elements[j].length()-1)=='x'){
        			if(elements[j].length()==1){
        				if(equation.charAt(i)=='+')num_x--;
        				else num_x++;
        				j++;
        				continue;
        			}
        			num_x=equation.charAt(i)=='-'?num_x+Integer.parseInt(elements[j].substring(0, elements[j].length()-1)):num_x-Integer.parseInt(elements[j].substring(0, elements[j].length()-1));
        		}else{
        			sum=equation.charAt(i)=='+'?sum+Integer.parseInt(elements[j]):sum-Integer.parseInt(elements[j]);
        		}
        		j++;
        	}
        }
        if(num_x!=0){
            // return "x="+(double)sum/num_x;
            return "x="+sum/num_x;
        }else if(sum==0){
            return "Infinite solutions";
        }else{
            return "No solution";
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.left.left=new TreeNode(10);
		root.left.right=new TreeNode(10);
		System.out.println(averageOfLevels(root));
		System.out.println(Character.digit('9',10));
		System.out.println(5/2);
		System.out.println(solveEquation("2-x+x+3x=2x-x+x+3"));
	}

}
