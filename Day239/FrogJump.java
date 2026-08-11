package Day239;

import java.util.Arrays;

public class FrogJump {

    static int helper1(int[] height, int idx, int[] dp){
        dp[0] = 0;
        for(int i = 1;i<=idx;i++){
            int fst = dp[i-1] + Math.abs(height[i] - height[i-1]);
            int sec = Integer.MAX_VALUE;
            if(i>1){
                sec = dp[i - 2] + Math.abs(height[i] - height[i-2]);
            }
            dp[i] = Math.min(fst, sec);
        }
        return dp[idx];
    }

    static int helper2(int[] height, int idx, int[] dp) {
        if (idx == 0)
            return 0;
        if (idx < 0)
            return Integer.MAX_VALUE;
        if (dp[idx] != -1)
            return dp[idx];
        int fst = helper2(height, idx - 1, dp) + Math.abs(height[idx] - height[idx - 1]);
        int sec = Integer.MAX_VALUE;
        if (idx > 1) {
            sec = helper2(height, idx - 2, dp) + Math.abs(height[idx] - height[idx - 2]);
        }
        return dp[idx] = Math.min(fst, sec);

    }

    static int helper(int[] height, int idx) {
        if (idx == 0)
            return 0;
        if (idx < 0)
            return Integer.MAX_VALUE;
        int fst = helper(height, idx - 1) + Math.abs(height[idx] - height[idx - 1]);
        int sec = Integer.MAX_VALUE;
        if (idx > 1) {
            sec = helper(height, idx - 2) + Math.abs(height[idx] - height[idx - 2]);
        }
        return Math.min(fst, sec);
    }

    static int minEnergy(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(helper2(height, n-1, dp));
        System.out.println(helper1(height, n-1, dp));
        return helper(height, n - 1);


    }

    public static void main(String[] args) {
        int[] heights = { 7, 5, 1, 2, 6 };
        System.out.println(minEnergy(heights));
    }

}
