package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class E8 {
//	给你六种面额1、5、10、20、50、100的纸币，假设每种币值的数量足够多，编写程序求组成N元的不同组合的个数
//	自己的解法：用int[n+1][6] rs来存储每一步的结果，rs[i][]表示组成i元有多少不同组合个数，rs[i][0]表示组合中含有bases[0]
//	纸币有多少不同组合个数，rs[i][1]表示组合中不含有bases[0]但是含有bases[1]的不同组合个数，
//	总之rs[i][x]表示组合中不含有bases[0]....bases[x-1]但是含有bases[x]的不同组合个数
//	转移方程rs[i][x]=rs[i-bases[x]][x....5];
//	标准解决方法：参照完全背包问题。
	public static int solution(int n){
		int[] bases=new int[]{1,5,10,20,50,100};
		int[][] rs=new int[n+1][6];
		for(int i=0;i<6;i++){
			rs[0][i]=1;
		}
		for(int y=1;y<n+1;y++){
			for(int x=0;x<6;x++){
				if(y>=bases[x]){
					int yy=y-bases[x];
					rs[y][x]=rs[yy][x];
				}
			}
			for(int i=4;i>-1;i--){
				rs[y][i]+=rs[y][i+1];
			}
		}
		return rs[n][0];
	}
    public static boolean judgeSquareSum(int c) {
        int cc=c;
        c=c/2;
        int end=c,start=0,mid=0,mid2=0;
        while(end>=start){
            mid=(start+end)/2;
            if(mid*mid>c)end=mid-1;
            else if(mid*mid<c)start=mid+1;
            else return true;
        }
        for(int i=mid;i>=0;i--){
            end=c;
            start=mid;
        while(end>=start){
            mid2=(start+end)/2;
            if(mid2*mid2+i*i>cc)end=mid2-1;
            else if(mid2*mid2+i*i<cc)start=mid2+1;
            else return true;
        }           
        }
        return false;  
    }
    //找出两个节点的最低公共祖先
    public static void LCA(TreeNode root,TreeNode s,TreeNode t){
    	List<TreeNode> rs=new ArrayList<TreeNode>();
    	preorder(root,s,t,rs);
    	for(TreeNode tt:rs){
    		System.out.print(tt.val);
    	}
    }
    public static void preorder(TreeNode root,TreeNode s,TreeNode t,List<TreeNode> rs){
    	
    	if(root!=null){
    		rs.add(root);
    		if(root==s||root==t)return;
    		else{
    			preorder(root.left,s,t,rs);
    			preorder(root.right,s,t,rs);
    		}
    	}
    }
    public static void postorder(TreeNode root,TreeNode s,TreeNode t,List<TreeNode> rs){
    	
    	if(root!=null){
    		preorder(root.left,s,t,rs);
    		preorder(root.right,s,t,rs);
    		rs.add(root);
    		if(root==s||root==t)return;
    	}
    }
    
    public static String nextClosestTime(String time) {
        HashSet<Integer> s=new HashSet<Integer>();
        int sum=0;
       
        for(int i=0;i<time.length();i++){
        	Character c=time.charAt(i);
        	if(!c.equals(new Character(':'))){
                sum=sum*10+Character.digit(time.charAt(i),10);
                s.add(Character.digit(time.charAt(i),10));      		
        	}
        }
        Integer[] x=new Integer[3];
        x[0]=sum;
        x[1]=Integer.MAX_VALUE;
        x[2]=0;
        put(s,new ArrayList<Integer>(),x);
        String rs=x[2].toString().substring(0,2)+":"+x[2].toString().substring(2);
        return rs;
    }
    public static void put(HashSet<Integer> set,ArrayList<Integer> rs,Integer[] max){
        if(rs.size()==4){
            int sum=0;
            for(int i=0;i<rs.size();i++){
                sum=sum*10+rs.get(i);
            }
            if(max[0]<sum){
                max[1]=sum-max[0]<max[1]?sum-max[0]:max[1];
        	    max[2]=sum;
            }
            else if(max[0]>sum){
                max[1]=(sum+2400-max[0])<max[1]?sum+2400-max[0]:max[1];
        	    max[2]=sum; 
            }
            return;
        }
        for(Integer n : set){
            if(rs.size()==0){
                if(n<3){
                    rs.add(n);
                    put(set,rs,max);
                    rs.remove(rs.size()-1);
                }
            }else if(rs.size()==1){
                if((rs.get(0)==1&&n<10)||(rs.get(0)==2&&n<5)){
                    rs.add(n);
                    put(set,rs,max);
                    rs.remove(rs.size()-1);
                }
            }else if(rs.size()==2){
                if(n<6){
                    rs.add(n);
                    put(set,rs,max);
                    rs.remove(rs.size()-1);
                }
            }else{
                if(n<10){
                    rs.add(n);
                    put(set,rs,max);
                    rs.remove(rs.size()-1);
                }
            }
        }

    }
	public static int maxProfit(int[] prices, int fee){
		int buy=Integer.MAX_VALUE,profit=0;
		int[] p=new int[prices.length+2];
		p[0]=Integer.MAX_VALUE;
		p[p.length-1]=Integer.MIN_VALUE;
		for(int i=0;i<prices.length;i++){
			p[i+1]=prices[i];
		}
		prices=p;
		boolean findbuy=true;
		for(int i=1;i<prices.length-1;i++){
			if(findbuy){
				if(prices[i]<prices[i-1]){
					buy=prices[i]<buy?prices[i]:buy;
					if(prices[i]<prices[i+1]){
						buy=prices[i];
						findbuy=false;
					}else{
						continue;
					}
				}
			}else{
				if(prices[i]>prices[i-1]){
					if(prices[i]>prices[i+1]){
						if(prices[i]-buy>fee){
							profit+=prices[i]-buy-fee;
							findbuy=true;
							buy=Integer.MAX_VALUE;
						}
					}else{
						continue;
					}
				}else{
					buy=prices[i]<buy?prices[i]:buy;
				}
			}
		}
		return profit;
	}
	public int rob(TreeNode root) {
        HashMap<TreeNode, int[]> maps=new HashMap<TreeNode,int[]>();
        robbin(root,maps);
        return maps.get(root)[0]>maps.get(root)[1]?maps.get(root)[0]:maps.get(root)[1];
    } 
	public void robbin(TreeNode root,HashMap<TreeNode, int[]> maps){
		if(root==null)return;
		if(root.left==null&&root.right==null){
			maps.put(root, new int[]{0,root.val});
			return;
		}
		robbin(root.left,maps);
		robbin(root.right,maps);
		int dischoose=0,choose=0;
		if(root.left!=null){
			dischoose+=Math.max(maps.get(root.left)[0], maps.get(root.left)[1]);
			choose+=maps.get(root.left)[0];
		}
		if(root.right!=null){
			dischoose+=Math.max(maps.get(root.right)[0], maps.get(root.right)[1]);
			choose+=maps.get(root.right)[0];
		}
		choose+=root.val;
		maps.put(root,new int[]{dischoose, choose});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(solution(16));
//		System.out.println(judgeSquareSum(1));
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(4);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(3);
		root.right =new TreeNode(5);
		root.right.right=new TreeNode(1);
		
//		LCA(root,root.left  ,root);
//		nextClosestTime("23:59");
//		System.out.print(maxProfit(new int[]{6,5,4,3,2,1},2));
		E8 e8=new E8();
		System.out.print(e8.rob(root));
	}

}
