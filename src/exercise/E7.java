package exercise;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E7 {
    public int distance(int y,int x,int[][] matrix){
        Queue<int[]> queue=new LinkedList<int[]>();
        int[] first=new int[]{y,x};
        int dis=0;
        while(queue.size()!=0){
            first=queue.poll();
            if(first[0]<matrix.length&&first[0]>-1&&first[1]<matrix[0].length&&first[1]>-1){
                if(matrix[first[0]][first[1]]==0)return dis;
                else{
                    first=new int[]{y+1,x};
                    queue.offer(first);
                    first=new int[]{y-1,x};
                    queue.offer(first);
                    first=new int[]{y,x+1};
                    queue.offer(first);
                    first=new int[]{y,x-1};
                    queue.offer(first);
                    dis++;
                }
            }
        }
        return dis;
    }
    public int[][] updateMatrix(int[][] matrix) {
        for(int y=0;y<matrix.length;y++){
            for(int x=0;x<matrix[0].length;x++){
                matrix[y][x]=distance(y,x,matrix);
            }
        }
        return matrix;
    }
    public static int distance(int y,int x,int[][] matrix,Integer[][] ints){
        Queue<Integer> queue=new LinkedList<Integer>();
        boolean[][] visited=new boolean[matrix.length][matrix[0].length];
        Integer first=ints[y][x];
        visited[y][x]=true;
        queue.offer(first);
        int dis=0,now=1,next=0;
        while(!queue.isEmpty()){
            first=queue.poll();
            if(now==0){
                now=next;
                next=0;
                dis++;
            }
            if(first==0)return dis;
            else{
                now--;
            	if(x<matrix[0].length-1&&!visited[y][x+1]){
                    queue.offer(ints[y][x+1]);
                    visited[y][x+1]=true;
                    next++;
                }
                if(x>0&&!visited[y][x-1]){
                    queue.offer(ints[y][x-1]);
                    visited[y][x-1]=true;
                    next++;
                }
                if(y>0&&!visited[y-1][x]){
                    queue.offer(ints[y-1][x]);
                    visited[y-1][x]=true;
                    next++;
                }
                if(y<matrix.length-1&&!visited[y+1][x]){
                    queue.offer(ints[y+1][x]);
                    visited[y+1][x]=true;
                    next++;
                }
            }

        }
        return -1;
    }
    public static void main(String[] args){
//    	Queue<Integer> q=new LinkedList<Integer>();
//    	q.offer(new Integer(1));
//    	q.offer(new Integer(2));
//    	boolean[] x=new boolean[5];Integer xx=6;
//    	while(!q.isEmpty()){
//    		Integer temp=q.poll();
//    		if(temp==1)System.out.println(temp);
//    	}
    	int[][] matrix={{0,0,0},{0,1,0},{1,1,1}};
    	Integer[][] ints={{0,0,0},{0,1,0},{1,1,1}};
//        for(int y=0;y<matrix.length;y++){
//            for(int x=0;x<matrix[0].length;x++){
//                matrix[y][x]=distance(y,x,matrix,ints);
//            }
//        }    
    	System.out.println(distance(2,1,matrix,ints));
    }
}
