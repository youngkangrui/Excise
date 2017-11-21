package tree;

import java.util.ArrayList;
import java.util.List;

public class BackTracking {
	private static int num=200;
	//回溯法求解幂集
	static void GetPowerSet(int i,Integer[] A,List<Integer> B){
		if(i>A.length-1) {
			for(Integer e:B){
				System.out.print(e);
			}
			System.out.println("end");
		}
		else{
			int k=B.size();//先处理根节点 
			B.add(k, A[i]);GetPowerSet(i+1,A,B);
			B.remove(k);GetPowerSet(i+1,A,B);
		}
	}
	//皇后问题判断当前布局是否合理,0-y行的矩阵是否合法
	public static boolean isLegal(int y,int[][] rs){
		int[][] p=new int[y+1][2];
		for(int yy=y;yy>-1;yy--){
			for(int x=0;x<rs[0].length;x++){
				if(rs[yy][x]==1){
					p[yy][0]=yy;
					p[yy][1]=x;
					break;
				}
			}
		}
		for(int yy=y-1;yy>-1;yy--){
			if(p[yy][0]==p[y][0]||p[yy][1]==p[y][1]||Math.abs(p[yy][0]-p[y][0])==Math.abs(p[yy][1]-p[y][1])){
				return false;
			}
		}
		return true;
	}
	//四皇后求解，在第i行放入皇后，前i-1行合理放置
	public static void Trial(int i,int n,int[][] rs){
		if(i>n-1)printsolution(rs);
		else for(int x=0;x<n;x++){
			rs[i][x]=1;
			if(isLegal(i,rs))Trial(i+1,n,rs);
			rs[i][x]=0;
		}
	}
	//输出棋盘
	public static void printsolution(int[][] rs){
		for(int[] y:rs){
			for(int x:y){
				System.out.print(x);
			}
			System.out.println("");
		}
		System.out.println("end");
	}
	public static void f(){
		if(num-->0)f();
	}
	//1,100,0,0

	public static void main(String[] args){
//		List<Integer> B=new ArrayList<Integer>();
//		Integer[] A={1,2,3};
//		GetPowerSet(0, A, B);
		int[][] rs={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
//		printsolution(rs);
//		Trial(0,4,rs);
		
	}
}
