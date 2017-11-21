package exercise;

import java.util.HashMap;
import java.util.Map;
//从前序遍历和中序遍历中恢复出二叉树
public class Solution {
    public int[] pre,in;
    public Map<Integer,Integer> in_m=new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre=preorder;
        in=inorder;
        for(int i=0;i<pre.length;i++){
            in_m.put(in[i],i);
        }
        return construct(0,pre.length-1,0,pre.length-1);
    }
  //从前序序列的s_pre-e_pre,以及后序序列的s_in-e_in中恢复二叉树
    public TreeNode construct(int s_pre,int e_pre,int s_in,int e_in){
    	//当s_pre>e_pre||s_in>e_in时说明没有这样的序列可以用来恢复二叉树，因此返回null
    		if(s_pre>e_pre||s_in>e_in)return null;
            TreeNode root=new TreeNode(pre[s_pre]);
          //当s_in==e_in时说明序列只有一个元素，直接作为根元素返回即可
            if(s_pre==e_pre)return root;
            //s_pre+1起始，in_m.get(pre[s_pre])-s_in+s_pre结束（中序中可以知道左子树长度，加到前序中可以得到前序的分割点）
            root.left=construct(s_pre+1,in_m.get(pre[s_pre])-s_in+s_pre,s_in,in_m.get(pre[s_pre])-1);
            root.right=construct(in_m.get(pre[s_pre])-s_in+s_pre+1,e_pre,in_m.get(pre[s_pre])+1,e_in);
            return root;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Solution s=new Solution();
    	s.buildTree(new int[]{1,2},new int[]{1,2});
	}
}
	


