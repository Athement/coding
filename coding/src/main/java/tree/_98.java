package tree;

import java.util.Stack;

public class _98 {
    public boolean isValidBST(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        Integer preVal=null;
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                p=stack.pop();
                if(preVal != null&&preVal >= p.val){
                    return false;
                }
                preVal = p.val;
                p = p.right;
            }
        }
        return true;
    }
}