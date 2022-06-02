package tree;

import java.lang.reflect.Field;

public class _129 {
    int res=0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        sumRoot(root,1);
        return res;
    }
    public void sumRoot(TreeNode root,int base){
        if(root == null){
            res+=base;
        }
        base=base*10+root.val;
        sumRoot(root.left,base);
        sumRoot(root.right,base);
    }
}