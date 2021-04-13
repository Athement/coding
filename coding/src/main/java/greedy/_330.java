package greedy;

public class _330 {
    public int minPatches(int[] nums, int n) {
        int res=0;
        int total=0;
        int index=0;
        while(total<n){
            if(index>=nums.length||index<nums.length&&total+1<nums[index]){
                res++;
                total+=total+1;
            }else{
                total+=nums[index];
            }
        }
        return res;
    }
}