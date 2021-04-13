package dp.backpack;

import java.util.Arrays;

public class _416 {
    public boolean canPartition(int[] nums) {
        int total= Arrays.stream(nums).sum();
        if(total%2!=0){
            return false;
        }
        int cap=total/2;
        boolean[] dp=new boolean[cap+1];
        dp[0]=true;
        for(int i=1;i<=nums.length;i++){
            for(int j=nums[i-1];j<=cap;j++){
                if(dp[j-nums[i-1]]){
                    dp[j]=true;
                }
            }

        }
        return dp[cap];
    }
}
