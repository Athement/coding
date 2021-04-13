package dp.backpack;

import java.util.Arrays;

public class _322 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length+1][amount+1];
        Arrays.fill(dp[0],amount+1);
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);
                }

            }
        }
        for(int i=0;i<dp.length;i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
        }
        return dp[coins.length][amount]==amount+1?-1:dp[coins.length][amount];
    }

    public static void main(String[] args) {
        _322 test=new _322();
        test.coinChange(new int[]{2},3);
    }
}
