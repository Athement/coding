package tree;

import java.util.LinkedList;

public class _116 {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        Node rear=root;
        Node cur=null;
        Node pre=null;
        queue.add(root);
        while(!queue.isEmpty()){
            cur=queue.poll();
            if(pre != null){
                pre.next=cur;
            }
            pre=cur;
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
            if(cur == rear){
                cur.next=null;
                pre=null;
                if(!queue.isEmpty()){
                    rear = queue.peekLast();
                }
            }
        }
        return root;
    }
    public Node connect1(Node root) {
        if(root == null) {
            return root;
        }
        root.next = null;
        helper(root.left, root.right);
        return root;
    }

    public void helper(Node root1, Node root2) {
        if (root1 == null && root2==null) {
            return;
        }
        root1.next = root2;
        helper(root1.left, root1.right);
        helper(root1.right, root2.left);
        helper(root2.left, root2.right);
    }
}
