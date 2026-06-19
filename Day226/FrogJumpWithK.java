package Day226;

public class FrogJumpWithK {

    static int helper_tab(int[] ht, int idx, int k, int[] dp) {
        dp[0] = 0;
        for (int i = 1; i <= idx; i++) {
            int jump = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    jump = dp[i - j] + Math.abs(ht[i] - ht[i - j]);
                    min = Math.min(min, jump);
                }
            }
            dp[i] = min;
        }
        return dp[idx];
    }

    static int helper(int[] ht, int idx, int k) {
        if (idx == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int jump = Integer.MAX_VALUE;
            if (idx - i >= 0) {
                jump = helper(ht, idx - i, k) + Math.abs(ht[idx] - ht[idx - i]);
            }
            min = Math.min(min, jump);
        }
        return min;
    }

    static int frogjump(int[] ht, int k) {
        int n = ht.length;
        // return helper(ht, n-1, k);
        int[] dp = new int[n];
        return helper_tab(ht, n - 1, k, dp);
    }

    public static void main(String[] args) {
        int[] heights = { 10, 5, 20, 0, 15 };
        System.out.println(frogjump(heights, 2));
    }

}
