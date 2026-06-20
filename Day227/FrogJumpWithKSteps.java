package Day227;

import java.util.Arrays;

public class FrogJumpWithKSteps {

    static int helper_tab(int[] arr,int k,int idx, int[] dp){
        dp[0] = 0;
        for(int i = 1;i<=idx;i++){
            int min = Integer.MAX_VALUE;
            int jump = Integer.MAX_VALUE;
            for(int j = 1;j <= k;j++){
                if(i-j >= 0) jump = dp[i-j] + Math.abs(arr[i-j] - arr[i]);
                min = Math.min(min,jump);
            }
            dp[i] = min;
        }
        return dp[idx];
    }

    static int helper(int[] arr,int k, int idx,int[] dp){
        if(idx == 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<=k;i++){
            int jump = Integer.MAX_VALUE;
            if(idx-i >= 0) jump = helper(arr, k, idx-i, dp)+Math.abs(arr[idx] - arr[idx -i]);  
            min = Math.min(min, jump);
        }
        return min;
    }
    static int min(int[] arr,int k){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // return helper(arr, k, n-1, dp);
        return helper_tab(arr, k, n-1, dp);
    }
    public static void main(String[] args) {
        int[]  heights = {10, 5, 20, 0, 15};
        System.out.println(min(heights, 2));

    }
    
}
