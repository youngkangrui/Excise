package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	VNode[] vertices;
	Graph(int vexNum,int[][] arcs){
		vertices=new VNode[vexNum];
		for(int i=0;i<vexNum;i++){
			vertices[i]=new VNode();
		}
		visited=new int[vexNum];
		
		ArcNode first=null;
		for(int y=0;y<arcs.length;y++){
			first=vertices[arcs[y][0]].firstArc;
			vertices[arcs[y][0]].firstArc=new ArcNode(arcs[y][1]);
			vertices[arcs[y][0]].firstArc.nextArc=first;
			first=vertices[arcs[y][1]].firstArc;
			vertices[arcs[y][1]].firstArc=new ArcNode(arcs[y][0]);
			vertices[arcs[y][1]].firstArc.nextArc=first;
		}
	}
	public void showGraph(){
		DFSTrav();
	}
	int[] visited;
	//图的深度优先遍历
	public void DFSTrav(){		
		for(int i=0;i<vertices.length;i++){
			if(visited[i]==0)
				DFS(i);			
		}
	}
	//对某一个点开始深度优先搜索
	public void DFS(int v){
		if(visited[v]==0){
			visited[v]=1;
			System.out.print(v+" ");
			for(ArcNode arc= vertices[v].firstArc;arc!=null;arc=arc.nextArc){
				DFS(arc.adjvex);
			}
		}
	}
	public void findAticul(Graph g){
		int[] low=new int[g.vertices.length];
		int[] visited=new int[g.vertices.length];
		visited[0]=1;
		//boolean[] isAticul=new boolean[g.vertices.length];
	    int[] count=new int[]{2};
	    ArcNode arc=g.vertices[0].firstArc;
	    int p=arc.adjvex;
	    DFSAticul(p, count, low, visited);
	    if(count[0]<g.vertices.length){
	    	System.out.println("0 号节点（根节点）是关节点");
	    	while(arc.nextArc!=null){
	    		arc=arc.nextArc;
	    		if(visited[arc.adjvex]==0){
	    			DFSAticul(arc.adjvex, count, low, visited);
	    		}
	    	}
	    }

	}
	public static void main(String[] args){
		int[][] arcs=new int[][]{{0,2},{0,1},{1,4},{1,3},{2,6},{2,5},{3,7},{4,7},{5,6},{8,9}};
		Graph g=new Graph(10,arcs);
		//g.showGraph();
//		g.DFSAticul(0);
//		int[] low=new int[g.vertices.length];
//		int[] visited=new int[g.vertices.length];
//		boolean[] isAticul=new boolean[g.vertices.length];
		g.findAticul(g);
//		int[] i=new int[]{8};
//		change(i);
//		System.out.println(i[0]);
		//System.out.println(g.lengthOfLongestSubstring("abcabcdbb"));
	}
	public static void change(int[] i){
		i[0]+=1;
	}
//	int[] low;
//	int count=0;
	//改变新参值
	public void DFSAticul(int v,int[] count,int[] low,int[] visited){
	    int min;
		visited[v]=min=count[0]++;
		for(ArcNode arc=vertices[v].firstArc;arc!=null;arc=arc.nextArc){
			if(visited[arc.adjvex]==0){
				DFSAticul(arc.adjvex,count,low,visited);
				if(low[arc.adjvex]<min)min=low[arc.adjvex];
				if(low[arc.adjvex]>=visited[v]) {
					System.out.println(v+" 号节点是关节点");
					
				}
			}else{
				min=visited[arc.adjvex]<min?visited[arc.adjvex]:min;
			}
		}
		low[v]=min;
	}
	//最长的不重复子数组
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        int maxlen=0,rs=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)).intValue()+1>=i-maxlen)
                	maxlen=i-map.get(s.charAt(i));    
                else 
                    maxlen++;

            }else{
                maxlen++;
            }
            map.put(s.charAt(i),i);   
        	rs=maxlen>rs?maxlen:rs;
        }
        return rs;  
    }
    
}
