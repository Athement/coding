package tree;

public class _124 {
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return res;
    }
    public int maxPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int lval=Math.max(maxPath(root.left),0);
        int rval=Math.max(maxPath(root.right),0);
        res=Math.max(res,lval+rval+root.val);
        return  Math.max(lval,rval)+root.val;
    }
}
