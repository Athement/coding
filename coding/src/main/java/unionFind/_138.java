package unionFind;

import java.util.HashMap;

public class _138 {
    public int longestConsecutive(int[] nums) {
       int res=0;
       UnionFind uf=new UnionFind(nums);
       for(int v:nums){
           uf.union(v,v+1);
       }
       for(int v:nums){
           res=Math.max(res,uf.find(v)-v+1);
       }
       return res;
    }
    class UnionFind{
        HashMap<Integer,Integer> hm=new HashMap<>();
        public UnionFind(int[] nums){
            for(int v:nums){
                hm.put(v,v);
            }
        }
        public void union(int p,int q){
            Integer pRoot=find(p);
            Integer qRoot=find(q);
            if(pRoot==null||qRoot==null||pRoot==qRoot){
                return;
            }
            hm.put(p,q);
        }

        public Integer find(int n) {
            if(!hm.containsKey(n)){
                return null;
            }
            int root=n;
            while(hm.get(root)!=root){
                root=hm.get(root);
            }
            while(hm.get(n)!=n){
                int parent=hm.get(n);
                hm.put(n,root);
                n=parent;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        int[] nums={0,3,7,2,5,8,4,6,0,1};
        _138 test=new _138();
        System.out.println(test.longestConsecutive(nums));
    }
}
