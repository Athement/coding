package tree.segmentTree;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class _327 {
    //zwkÏß¶ÎÊ÷
//    int[] seg;
//
//    public int countRangeSum(int[] nums, int lower, int upper) {
//        long[] preSum = new long[nums.length + 1];
//        for (int i = 0; i < nums.length; i++) {
//            preSum[i + 1] = preSum[i] + nums[i];
//        }
//
//        TreeSet<Long> ts = new TreeSet<>();
//        for (Long i : preSum) {
//            ts.add(i);
//            ts.add(i - lower);
//            ts.add(i - upper);
//        }
//        int len = ts.size();
//        seg = new int[len << 2];
//        HashMap<Long, Integer> helper = new HashMap<>();
//
//        int idx = 0;
//        for (long i : ts) {
//            helper.put(i, idx++);
//        }
//        int res = 0;
//        for (long x : preSum) {
//            res += query(helper.get(x - upper), helper.get(x - lower), 0, len - 1, 1);
//            update(helper.get(x), 1, 0, len - 1, 1);
//        }
//        return res;
//
//    }
//
//    private void pushup(int k) {
//        seg[k] = seg[k << 1] + seg[k << 1 | 1];
//    }
//
//    private void update(int idx, int v, int l, int r, int k) {
//        if (l == r) {
//            seg[k] += v;
//        } else {
//            int m = l + ((r - l) >> 1);
//            if (idx <= m) {
//                update(idx, v, l, m, k << 1);
//            } else {
//                update(idx, v, m + 1, r, k << 1 | 1);
//            }
//            pushup(k);
//        }
//    }
//
//    private int query(int left, int right, int l, int r, int k) {
//        if (left <= l && right >= r) {
//            return seg[k];
//        } else {
//            int res = 0;
//            int m = l + ((r - l) >> 1);
//            if (left <= m) {
//                res += query(left, right, l, m, k << 1);
//            }
//            if (right >= m + 1) {
//                res += query(left, right, m + 1, r, k << 1 | 1);
//            }
//            return res;
//        }
//    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        int len = nums.length;
        // avoid duplicated preSum
        Set<Long> set = new TreeSet<>();
        set.add(0l);
        // store preSum
        long[] preSum = new long[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            set.add(preSum[i + 1]);
        }
        // set to long[]
        long[] sorted = set.stream().mapToLong(a -> {
            return a + 0l;
        }).toArray();
        // build segment tree
        Node root = build(sorted, 0, sorted.length - 1);
        for (int i = 0; i < preSum.length; i++) {
            // range query
            count += query(root, preSum[i] - upper, preSum[i] - lower);
            // update
            update(root, preSum[i]);
        }
        return count;
    }

    private int query(Node node, long l, long r) {
        if (l <= node.lb && r >= node.rb) {// return result if range of node in [l,r]
            return node.count;
        } else if (l > node.rb || r < node.lb) {// return 0 if range of node doesn't intersect [l,r]
            return 0;
        } else {// query in the children of node
            if (node.left != null && node.right != null) {
                return query(node.left, l, r) + query(node.right, l, r);
            } else {
                return 0;
            }

        }
    }

    private void update(Node node, long val) {
        if (val >= node.lb && val <= node.rb) {// only update node where val settle
            if (node.left != null && node.right != null) {
                update(node.left, val);
                update(node.right, val);
                // push up the update operation
                pushup(node);
            } else {
                // directly update the leaf
                node.count++;
            }
        }
        TreeMap<Integer, Integer> tm = new TreeMap<>();
    }

    private Node build(long[] preSum, int l, int r) {
        Node node = new Node();
        if (l == r) {// build the leaf node
            node.lb = preSum[l];
            node.rb = preSum[r];
            return node;
        }
        int len = preSum.length;
        int m = l + ((r - l) >> 1);
        // build the left child and right child
        node.left = build(preSum, l, m);
        node.right = build(preSum, m + 1, r);
        // update child
        node.lb = node.left.lb;
        node.rb = node.right.rb;
        pushup(node);
        return node;
    }

    private void pushup(Node node) {
        // update count
        node.count = node.left.count + node.right.count;
    }

    class Node {
        Node left;
        Node right;
        long lb;
        long rb;
        int count;
    }

    public static void main(String[] args) {
        _327 test = new _327();
        System.out.println(test.countRangeSum(new int[]{0}, 0, 0));
    }


}
