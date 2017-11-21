package exercise;

public class Pack {
//	01背包问题，物品总体积不能超过背包即可（初始化都为零）
//	things 表示物品数量；weight表示各个物品的体积；value表示各个物品的价值，cap表示背包体积
	public static int pack01_1(int things,int[] weight,int[] value,int cap){
		int[] stat=new int[cap+1];
		for(int range=0;range<things;range++){
			for(int cap1=cap;cap1>=weight[range];cap1--){
				stat[cap1]=Math.max(stat[cap1], stat[cap1-weight[range]]+value[range]);
			}
		}
		return stat[cap];
	}
//	01背包问题，物品总体积必须等于背包体积（初始化stat[0]=0,其余为负无穷（第三种状态表示当前解法不存在））
	public static int pack01_2(int things,int[] weight,int[] value,int cap){
		int[] stat=new int[cap+1];
		for(int cap1=cap;cap1>0;cap1--){
			stat[cap1]=Integer.MIN_VALUE;
		}
		for(int range=0;range<things;range++){
			for(int cap1=cap;cap1>=weight[range];cap1--){
				if(stat[cap1-weight[range]]!=Integer.MIN_VALUE){
					stat[cap1]=Math.max(stat[cap1], stat[cap1-weight[range]]+value[range]);
				}
					
			}
		}
		return stat[cap]==Integer.MIN_VALUE?0:stat[cap];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pack01_1(3,new int[]{1,2,10},new int[]{10,5,1},11));
	}

}
