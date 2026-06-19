package Day226;

import java.util.Arrays;

public class FrogJump {
    static int helper_tab(int[] ht, int idx,int[] dp){
        dp[0] = 0;
        for(int i = 1;i<=idx;i++){
            int first = dp[i-1] + Math.abs(ht[i] - ht[i-1]);
            int sec = Integer.MAX_VALUE;
            if(i-2 > 0) sec = dp[i-2] + Math.abs(ht[i] - ht[i-2]);
            dp[i] = Math.min(first, sec); 
        }
        return dp[idx];
    }
    static int helper_memo(int[] ht,int idx,int[] dp){
        if(idx == 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int first = helper_memo(ht, idx-1,dp) + Math.abs(ht[idx] - ht[idx-1]);
        int sec = Integer.MAX_VALUE;
        if(idx-2 >= 0) sec = helper_memo(ht, idx-2,dp) + Math.abs(ht[idx] - ht[idx-2]);
        return dp[idx] = Math.min(first, sec);
    }
    static int helper(int[] ht, int idx){
        if(idx == 0) return 0;
        int first = helper(ht, idx-1) + Math.abs(ht[idx] - ht[idx-1]);
        int sec = Integer.MAX_VALUE;
        if(idx-2 >= 0) sec = helper(ht, idx-2) + Math.abs(ht[idx] - ht[idx-2]);
        return Math.min(first, sec);
    }
    static int minDistance(int[] ht){
        int n = ht.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        // return helper(ht, n-1);
        return helper_memo(ht, n-1, dp);
    }
    public static void main(String[] args) {
        int[] heights = {7, 5, 1, 2, 6};
        System.out.println(minDistance(heights));
    }
    
}
