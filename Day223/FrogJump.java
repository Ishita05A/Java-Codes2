package Day223;

import java.util.Arrays;

public class FrogJump {

    static int minDist_tab(int idx,int[] arr,int[] dp){
        dp[0] = 0;
        for(int i = 1;i<=idx;i++){
            int fs = dp[i-1] + Math.abs(arr[i]-arr[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1){
                ss = dp[i-2] + Math.abs(arr[i]-arr[i-2]);
            }
            dp[i] = Math.min(fs, ss);
        }
        return dp[idx];
    }

    static int minDist_memo(int idx, int[] arr,int[] dp){
        if(idx == 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int left = minDist_memo(idx-1, arr,dp) + Math.abs(arr[idx]-arr[idx-1]);
        int right = Integer.MAX_VALUE;
        if(idx>1) right = minDist_memo(idx-2, arr,dp) + Math.abs(arr[idx] - arr[idx-2]);
        return dp[idx] =  Math.min(left, right);
    }

    static int minDist_rec(int idx,int[] arr){
        if(idx == 0) return 0;
        int left = minDist_rec(idx-1, arr) + Math.abs(arr[idx]-arr[idx-1]);
        int right = Integer.MAX_VALUE;
        if(idx>1) right = minDist_rec(idx-2, arr) + Math.abs(arr[idx] - arr[idx-2]);
        return Math.min(left, right);
    }
    public static void main(String[] args) {
        int[] heights = {2, 1, 3, 5, 4};
        System.out.println(minDist_rec(4, heights));
        int[] dp = new int[5+1];
        Arrays.fill(dp, -1);
        System.out.println(minDist_memo(4, heights, dp));
        System.out.println(minDist_tab(4, heights, dp));

    
    }
    
}
