package dp.dlistDP;

public class _97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        dp[0][0]=true;
        for(int j=1;j<dp[0].length;j++){
            if(dp[0][j-1]&&s2.charAt(j-1)==s3.charAt(j-1)){
                dp[0][j]=true;
            }else{
                break;
            }
        }
        for(int i=1;i<dp.length;i++){
            if(dp[i-1][0]&&s1.charAt(i-1)==s3.charAt(i-1)){
                dp[i][0]=true;
            }else{
                break;
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1)){
                    dp[i][j]=true;
                    continue;
                }
                if(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1)){
                    dp[i][j]=true;
                }
            }
        }
        for(int i=0;i<dp.length;i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        _97 test=new _97();
        test.isInterleave("","a","a");
    }
}
