package tree;

import java.util.Arrays;

public class _105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        if(preorder.length == 1){
            return new TreeNode(preorder[0],null,null);
        }
        int i = 0;
        for(; i < inorder.length ;i++ ){
            if(preorder[0] == inorder[i]){
                break;
            }
        }
        //不创建新对象，使用索引的速度会更快
        return new TreeNode(preorder[0],buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i)),
                buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,preorder.length)));
    }
}
