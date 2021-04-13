package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> partRes = new ArrayList<>();
        TreeNode rear = root;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            partRes.add(cur.val);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
            if(cur == rear){
                res.add(partRes);
                partRes=new ArrayList<>();
                if(!queue.isEmpty())
                    rear=queue.getLast();
            }
        }
        return res;
    }
}
