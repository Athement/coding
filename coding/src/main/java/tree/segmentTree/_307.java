package tree.segmentTree;

public class _307 {
    class NumArray {
        int nums[];
        int seg[];
        public NumArray(int[] nums) {
            this.nums=nums;
            seg=new int[nums.length*4+1];
            build(1,0,nums.length-1);
        }

        private void build(int k, int l, int r) {
            if(l==r){
                seg[k]=nums[l];
            }else{
                int m=(l+r)>>1;
                build(k<<1,l,m);
                build(k<<1|1,m+1,r);
                pushUp(k);
            }
        }

        private void pushUp(int k) {
            //区间求和
            seg[k]=seg[k<<1]+seg[k<<1|1];
        }

        public void update(int index, int val) {
            update(index,val,0,nums.length-1,0);
        }

        private void update(int index, int val, int l, int r, int k) {
            if(l==r){
                seg[k]=val;
            }else{
                int m=(l+r)>>1;
                if(index>m){
                    update(index,val,m+1,r,k<<1|1);
                }else{
                    update(index,val,l,m,k<<1);
                }
                pushUp(k);
            }
        }

        public int sumRange(int left, int right) {
            return sumRange(left,right,0,nums.length-1,1);
        }

        public int sumRange(int left, int right,int l,int r,int k){
            if(l>=left&&r<=right){
                return seg[k];
            }else{
                int m=(l+r)>>1;
                int res=0;
                if(left<=m){
                    res+=sumRange(left,right,l,m,k<<1);
                }
                if(right>=m+1){
                    res+=sumRange(left,right,m+1,r,k<<1|1);
                }
                return res;
            }
        }
    }

    public static void main(String[] args) {
        NumArray na=new _307().new NumArray(new int[]{1,2,5,7});
        System.out.println(na.sumRange(0,3));
    }
}
