package tree;

import java.util.*;

public class _95 {
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        Map<Integer,List<TreeNode>> map=new HashMap<>();
        List<TreeNode> lst0=new ArrayList<>();
        lst0.add(null);
        map.put(0,lst0);
        for(int i=1;i<=n;i++){
            List<TreeNode> lst=new ArrayList<>();
            for(int j=1;j<=i;j++){
                List<TreeNode> lefts=map.get(j-1);
                List<TreeNode> rights=map.get(i-j);
                for(TreeNode right : rights){
                    right=treeNodesPlus(right,j);
                    for(TreeNode left:lefts){
                        TreeNode node=new TreeNode(j,left,right);
                        lst.add(node);
                    }
                }
            }
            map.put(i,lst);
        }
        return map.get(n);
    }
    public TreeNode treeNodesPlus(TreeNode root,int delta){
        if(root==null){
            return null;
        }
        return new TreeNode(root.val+delta,treeNodesPlus(root.left,0),treeNodesPlus(root.right,0));
    }
}
