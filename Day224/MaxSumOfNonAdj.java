package Day224;

import java.util.Arrays;

public class MaxSumOfNonAdj {

    static int maxSum_tab(int[] arr, int idx,int[] dp){
        dp[0] = arr[0];
        for(int i = 1;i<=idx;i++){
            int pick = Integer.MIN_VALUE;
            if(i-2 >=0) pick = arr[i] + dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[idx];

    }

    static int maxSum_memo(int[] arr,int idx, int[] dp){
        if(idx == 0) return arr[idx];
        if(idx < 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int pick = arr[idx] + maxSum_memo(arr, idx-2,dp);
        int notPick = maxSum_memo(arr, idx-1,dp);
        return dp[idx] =  Math.max(pick, notPick);
    }
    static int maxSum_rec(int[] arr,int idx){
        if(idx == 0) return arr[idx];
        if(idx < 0) return 0;
        int pick = arr[idx] + maxSum_rec(arr, idx-2);
        int notPick = maxSum_rec(arr, idx-1);
        return Math.max(pick, notPick);

    }
    public static void main(String[] args) {
        int[] arr =  {2, 1, 4, 9};
        int[] dp = new int[4];
        Arrays.fill(dp, -1);
        System.out.println(maxSum_rec(arr, 3));
        System.out.println(maxSum_memo(arr, 3, dp));
        System.out.println(maxSum_tab(arr, 3, dp));
    }
    
}
