package dp.intervalDP;

public class _1563 {
    public int stoneGameV(int[] stoneValue) {
        int len=stoneValue.length;
        int[][] dp=new int[len][len];
        int[] sum=new int[len+1];
        for(int i=1;i<=len;i++){
            sum[i]=stoneValue[i-1]+sum[i-1];
        }
        for(int i=1;i<len;i++){
            for(int j=0;j+i<len;j++){
                int max=Integer.MIN_VALUE;
                int left=0;
                for(int k=0;k<i;k++){
                    if(sum[j+k+1]-sum[j]==sum[j+i+1]-sum[j+k+1]){
                        left=sum[j+k+1]-sum[j]+Math.max(dp[j][j+k],dp[j+k+1][j+i]);
                    }else if(sum[j+k+1]-sum[j]<sum[j+i+1]-sum[j+k+1]){
                        left=sum[j+k+1]-sum[j]+dp[j][j+k];
                    }else{
                        left=sum[j+i+1]-sum[j+k+1]+dp[j+k+1][j+i];
                    }
                    max=Math.max(max,left);
                }
                dp[j][j+i]=max;
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) {
        _1563 test =new _1563();
        System.out.println(test.stoneGameV(new int[]{1}));
    }
}
