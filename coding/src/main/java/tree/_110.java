package tree;

public class _110 {
    public boolean isBalanced(TreeNode root) {
        return balanced(root)>=0;
    }

    public int balanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = balanced(root.left);
        int right = balanced(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }else{
            return Math.max(left,right)+1;
        }
    }
}
