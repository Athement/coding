package dp.intervalDP;

import java.util.Arrays;

public class MaxSubarry3 {
    public int maxSubArray(int[] nums, int k){
        int[][] dp=new int[k+1][nums.length+1];
        int[][] max=new int[nums.length][nums.length+1];


        for(int i=0;i<nums.length;i++){
            Arrays.fill(max[i],Integer.MIN_VALUE);
        }

        int sum=0;
        for(int i=1;i<k+1;i++){
            sum+=nums[i-1];
            dp[i][i]=sum;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=i;j<dp[0].length;j++){
                for(int m=i;m<j;m++){
                    dp[i][j]=Math.max(dp[i][j],dp[i][m]+max[m][j]);
                }
            }
        }
        return dp[k][nums.length];
    }

    public static void main(String[] args) {
        MaxSubarry3 test=new MaxSubarry3();
        System.out.println(test.maxSubArray(new int[]{1,2,-2,3,-2,4},3));
    }
}
