package tree.segmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _315 {
    public List<Integer> countSmaller(int[] nums) {
        int[] res=new int[nums.length];
        Node[] nodes=new Node[nums.length];
        int[] arr=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            nodes[i]=new Node(nums[i],i);
        }
        Arrays.sort(nodes);
        for(int i=0;i<nodes.length;i++){
            update(nodes[i].idx+1,1,arr);
            res[nodes[i].idx]=(sum(arr.length-1,arr)-sum(nodes[i].idx+1,arr));
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
    class Node implements Comparable<Node>{
        int num;
        int idx;

        public Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return this.num-o.num;
        }
    }

    public void update(int index,int val,int[] arr){
        for(;index<arr.length;arr[index]+=val,index+=lowbit(index));
    }

    public int sum(int index,int[] arr){
        int res=0;
        for(;index>0;res+=arr[index],index-=lowbit(index)){}
        return res;
    }

    private int lowbit(int index) {
        return index&(-index);
    }

    public static void main(String[] args) {
        _315 test = new _315();
        test.countSmaller(new int[]{3,1,5,4,2}).stream().forEach(System.out::println);
    }
}
