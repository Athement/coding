package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode p=root;
        while(!stack.isEmpty()||p!=null){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }else{
                p=stack.pop();
                res.add(p.val);
                p=p.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str="[1,3,null,null,2]";
        TreeNode root= TreeNode.treeFromString(str);
        System.out.println(new _94().inorderTraversal(root));
    }
}



