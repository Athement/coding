package dp.gambleDP;

public class _877 {
    public boolean stoneGame(int[] piles) {
        int[][][] dp=new int[piles.length][piles.length][2];
        for(int i=0;i< piles.length;i++){
            dp[i][i][0]=piles[i];
            dp[i][i][1]=0;
        }
        for(int i=1;i<piles.length;i++){
            for(int j=0;i+j<piles.length;j++){
                int left = piles[j] + dp[j+1][j+i][1];
                int right = piles[j+i] + dp[j][j+i-1][1];
                // 套用状态转移方程
                // 先手肯定会选择更大的结果，后手的选择随之改变
                if (left > right) {
                    dp[j][j+i][0] = left;
                    dp[j][j+i][1] = dp[j+1][j+i][0];
                } else {
                    dp[j][j+i][0] = right;
                    dp[j][j+i][1] = dp[j][j+i-1][0];
                }
            }
        }
        return dp[0][piles.length-1][0]>dp[0][piles.length-1][1];
    }

    public static void main(String[] args) {
        _877 test=new _877();
        System.out.println(test.stoneGame(new int[]{1,3,1}));
    }
}
