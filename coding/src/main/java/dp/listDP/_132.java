package dp.listDP;

import java.util.Arrays;

public class _132 {
    public int minCut(String s) {
        boolean[][] arr = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i][i] = true;
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    arr[i][j] = true;
                }
            }
        }
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[dp.length - 1] - 1;
    }

    public boolean isPalindrome(String str) {
        if (str.isEmpty()) {
            return false;
        }
        int l = 0;
        int h = str.length() - 1;
        while (l < h) {
            if (str.charAt(l++) != str.charAt(h--)) {
                return false;
            }
        }
        return true;
    }
}
