package dp.gambleDP;

import java.util.Arrays;

public class _1406 {
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        int[][] dp = new int[len+1][2];
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + stoneValue[i];
        }
        for (int i = len - 1; i >= 0; i--) {
            dp[i][0] = sum[i + 1] - sum[i] + dp[i + 1][1];
            dp[i][1] = dp[i][1] = sum[len]-sum[i]-dp[i][0];
            for (int j = 1; j < 3&&i+j+1<=len; j++) {
                if (dp[i][0] < sum[i + j + 1] - sum[i] + dp[i + j + 1][1]) {
                    dp[i][0] = sum[i + j + 1] - sum[i] + dp[i + j + 1][1];
                    dp[i][1] = sum[len]-sum[i]-dp[i][0];
                }
            }

        }
        return dp[0][0] == dp[0][1] ? "Tie" : dp[0][0] > dp[0][1] ? "Alice" : "Bob";
    }

    public static void main(String[] args) {
        _1406 test = new _1406();
        System.out.println(test.stoneGameIII(new int[]{-1,-1,-2,-3}));
    }
}
