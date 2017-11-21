package exercise;

import java.util.Arrays;

public class E4 {
	public static int maxCount(int m, int n, int[][] ops) {
        if(ops.length==0)return m*n;
        int[] t=new int[ops.length];
        int x=0,y=0,rs=1;
        while(x<ops[0].length){
            while(y<ops.length){
                t[y]=ops[y][x];
                y++;
            }
            y=0;
            Arrays.sort(t);
            rs*=t[0];
            x++;
        }
        return rs;
    }
	//��������n�����n*n�ľ��󣬴�1-n^2һ��˳ʱ����֡�
	public static void sq(int n){
		int sum=n*n,x=0,y=0,vx=1,vy=0;//vx��vy�������з���
		int[][] matrix=new int[n][n];
		for(int i=1;i<=sum;i++){
			matrix[y][x]=i;
			//��ǰ��ʻ�������ң�ͬʱ��һ��·����������߽�����Ѿ������----������ʻ
			if(vx==1&&vy==0&&(x+1==n||matrix[y][x+1]!=0)){
				vx=0;
				vy=1;
			}
			if(vx==0&&vy==1&&(y+1==n||matrix[y+1][x]!=0)){
				vx=-1;
				vy=0;
			}
			if(vx==-1&&vy==0&&(x-1<0||matrix[y][x-1]!=0)){
				vx=0;
				vy=-1;
			}
			if(vx==0&&vy==-1&&(y-1<0||matrix[y-1][x]!=0)){
				vx=1;
				vy=0;
			}
			x+=vx;
			y+=vy;
		}
		x=0;y=0;
		while(y<n){
			while(x<n){
				System.out.print(matrix[y][x++]);
			}
			System.out.println();
			x=0;
			y++;
		}
	}
    public static int arrayNesting(int[] nums) {
        int max=0,l=nums.length;
        for(int i=0;i<l&&nums[i]!=-1;i++){
            int j=i,size=0;
            while(nums[j]!=-1){
                int x=nums[j];
                nums[j]=-1;
                j=x;
                size++;
            } 
            max=Math.max(size,max);
        }
        return max;
    }
    public static int inc_sub_length(int[] nums){
    	int[] rs=new int[nums.length];int len=1;
    	Arrays.fill(rs, 1);
    	for(int i=1;i<nums.length;i++){
    		int max=rs[i];
    		for(int j=i-1;j>=0;j--){
    			if(nums[j]<nums[i]){
    				rs[i]=rs[j]+1;
    				max=Math.max(rs[i], max);
    			}
    		}
    		rs[i]=max;
    		len=Math.max(rs[i], len);
    	}
    	return len;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] ops={{2,2},{3,3}};
//		System.out.println(maxCount(3, 3, ops));
//		long start=System.currentTimeMillis();
//		sq(100);
//		long end=System.currentTimeMillis();
//		System.out.println("����ʱ��:"+(end-start)+"ms");
//		int[]  nums={1,0,3,4,2};
//		System.out.println(arrayNesting(nums));
		int[] nums=new int[]{1,6,2,7};
		System.out.println(inc_sub_length(nums));
	}

}
