package dp.intervalDP;

public class _87 {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        int len=s1.length();
        boolean[][][] dp=new boolean[len][len][len+1];
        for(int i=0;i<len;i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j][0] = true;
            }
        }
        for(int k=1;k<len+1;k++){
            for(int i=0;i<len+1-k;i++){
                for(int j=0;j<len+1-k;j++){
                    if(s1.substring(i,i+k).equals(s2.substring(j,j+k))){
                        dp[i][j][k]=true;
                    }else{
                        for(int l=1;l<k;l++){
                            if(dp[i][j+k-l][l]&&dp[i+l][j][k-l]||dp[i][j][l]&&dp[i+l][j+l][k-l]){
                                dp[i][j][k]=true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][len];
    }

    public static void main(String[] args) {
        _87 test=new _87();
        System.out.println(test.isScramble("great","rgeat"));
    }
}
