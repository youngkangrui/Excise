package exercise;

import java.util.HashMap;
import java.util.Map;
//��ǰ���������������лָ���������
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
  //��ǰ�����е�s_pre-e_pre,�Լ��������е�s_in-e_in�лָ�������
    public TreeNode construct(int s_pre,int e_pre,int s_in,int e_in){
    	//��s_pre>e_pre||s_in>e_inʱ˵��û�����������п��������ָ�����������˷���null
    		if(s_pre>e_pre||s_in>e_in)return null;
            TreeNode root=new TreeNode(pre[s_pre]);
          //��s_in==e_inʱ˵������ֻ��һ��Ԫ�أ�ֱ����Ϊ��Ԫ�ط��ؼ���
            if(s_pre==e_pre)return root;
            //s_pre+1��ʼ��in_m.get(pre[s_pre])-s_in+s_pre�����������п���֪�����������ȣ��ӵ�ǰ���п��Եõ�ǰ��ķָ�㣩
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
	


