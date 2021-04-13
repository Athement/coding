package dp.gambleDP;

public class _1510 {
    public boolean winnerSquareGame(int n) {
        boolean[][] dp=new boolean[n+1][2];
        dp[0][1]=true;
        for(int i=1;i<n+1;i++){
            for(int j=1;j*j<=i;j++){
                dp[i][1]=true;
                if(dp[i-j*j][1]){
                    dp[i][0]=true;
                    dp[i][1]=false;
                    break;
                }
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        _1510 test=new _1510();
        System.out.println(test.winnerSquareGame(6));
    }
}
