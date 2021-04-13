package tree;

import java.util.Stack;

public class _99 {
    public void recoverTree(TreeNode root) {
        //找到逆序的两个节点
        TreeNode p = root;
        TreeNode pre = null;
        TreeNode first=null;
        TreeNode second=null;

        Stack<TreeNode> stack = new Stack<>();
        while(p != null || !stack.empty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                if(pre != null && pre.val >= p.val){
                    if(first == null) {
                        first = pre;
                    }
                    second = p;
                }
                pre=p;
                p = p.right;
            }
        }
        first.val^=second.val;
        second.val^=first.val;
        first.val^=second.val;
    }
}
