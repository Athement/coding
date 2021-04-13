package dp.listDP;

import java.util.Arrays;

public class _45 {
    public int jump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1,nums.length,Integer.MAX_VALUE);
        int longest=0;
        for(int i=0;i<nums.length;i++){
            if(i+nums[i]>longest){
                longest=i+nums[i];
                for(int j=i+1;j<=longest&&j<nums.length;j++){
                    dp[j]=Math.min(dp[j],dp[i]+1);
                }
            }

        }
        return dp[nums.length-1];
    }


}
