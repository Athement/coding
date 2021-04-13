package tree;

import org.junit.Test;

import java.util.ArrayList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {}
    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode treeFromString (String str){
        str=str.substring(1,str.length()-1);
        String[] strs=str.split(",");
        ArrayList<TreeNode> lst=new ArrayList<>();
        TreeNode root=null;
        boolean oneTag=true;
        for(int i=0;i<strs.length;i++) {
            TreeNode parent = lst.isEmpty() ? null : lst.get(0);
            TreeNode tn = null;
            if (!"null".equals(strs[i])) {
                tn = new TreeNode(Integer.parseInt(strs[i]), null, null);
                lst.add(tn);
            }
            if (parent == null) {
                root = tn;
            } else {
                if (oneTag) {
                    parent.left = tn;
                } else {
                    parent.right = tn;
                    lst.remove(0);
                }
                oneTag = !oneTag;
            }
        }
        return root;
    }

    @Test
    public void switchTest(){
        TreeNode root=treeFromString("[3,1,4,null,null,2]");
        new _99().recoverTree(root);
        System.out.println(new _94().inorderTraversal(root));
    }
}