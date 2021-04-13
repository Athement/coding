package dp.dlistDP;

import java.util.Arrays;

public class _115 {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[t.length()+1][s.length()+1];
        Arrays.fill(dp[0],0,s.length()+1,1);
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
                }else {
                    dp[i][j]=dp[i][j-1];
                }
                System.out.print(dp[i][j]+",");
            }
            System.out.println("");
        }

        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        _115 test=new _115();
        test.numDistinct("bbbb","bb");
    }
}
