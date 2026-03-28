package Day205;

import java.util.Arrays;

public class FrogJumpWithKdist {
    static int frog_tabular(int idx,int[] height,int k,int[] dp){
        dp[0] = 0;
        for(int i = 1;i<=idx;i++){
            int minStep = Integer.MAX_VALUE;
            for(int j = 1;j<=k;j++){
                int jump = 0;
                if(i-j>=0) jump = frog_tabular(i-j, height, k, dp)+Math.abs(height[i]-height[i-j]);
                minStep = Math.min(minStep, jump);
            }
            dp[i] = minStep;
        }
        return dp[idx];
    }
    static int frog_memo(int idx,int[] height,int k,int[] dp){
        if(idx == 0){
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];
        int min_step = Integer.MAX_VALUE;
        for(int i = 1;i<=k;i++){
            int jump = 0;
            if(idx-i>=0) jump = frog_memo(idx-i, height, k, dp)+Math.abs(height[idx]-height[idx-i]);
            min_step = Math.min(min_step, jump);
            dp[idx] = min_step;
        }
        
        return min_step;
    }
    static int frog_rec(int idx, int[] height, int k) {
        if (idx == 0) return 0;
        int min_step = Integer.MAX_VALUE;
        for(int i = 1;i<=k;i++){
            int jump = 0;
            if(idx-i>=0) jump = frog_rec(idx-i, height, k)+Math.abs(height[idx]-height[idx-i]);
            min_step = Math.min(min_step, jump);

        }
        return min_step;
    }

    public static void main(String[] args) {
        int[] heights = {10, 5, 20, 0, 15};
        System.out.println(frog_rec(4, heights, 2));
        int[] dp = new int[5];
        Arrays.fill(dp, -1);
        System.out.println(frog_memo(4, heights, 2,dp));
        System.out.println(frog_tabular(4, heights, 2, dp));

    }
}
