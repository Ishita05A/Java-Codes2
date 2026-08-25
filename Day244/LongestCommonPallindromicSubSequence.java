package Day244;

import java.util.Arrays;

public class LongestCommonPallindromicSubSequence {
    static int helper(String s1, int idx1, String s2, int idx2, int[][] dp) {
        if (idx1 <= 0 || idx2 <= 0) {
            return 0;
        }
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
            return dp[idx1][idx2] = 1 + helper(s1, idx1 - 1, s2, idx2 - 1, dp);
        } else
            return dp[idx1][idx2] = Math.max(helper(s1, idx1 - 1, s2, idx2, dp), helper(s1, idx1, s2, idx2 - 1, dp));
    }

    static int lcs(String s1) {
        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(s1, n, new StringBuilder(s1).reverse().toString(), n, dp);

    }

    public static void main(String[] args) {
        System.out.println(lcs("eeeme" ));
    }

}
