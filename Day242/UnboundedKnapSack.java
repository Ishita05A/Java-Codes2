package Day242;

import java.util.Arrays;

public class UnboundedKnapSack {
    static int helper2(int[] wt, int[] val, int W,int[][] dp){
        int n = wt.length;
        for(int i  = 0;i<=W;i++){
            dp[0][i] = (i/wt[0]) * val[0];
        }

        for(int i = 1;i<n;i++){
            for(int j = 1;j<=W;j++){
                int notPick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(wt[i] <=j) pick = val[i] + dp[i][j-wt[i]];
                dp[i][j] = Math.max(notPick, pick);
            }
        }
        return dp[n-1][W];
    }
    static int helper(int[] wt, int[] val,int idx, int W,int[][] dp){
        if(idx == 0){
            return (W/wt[idx] * val[0]);
        }

        if(dp[idx][W] != -1) return dp[idx][W]; 
        int notPick = helper(wt,val,idx-1,W,dp);
        int pick = Integer.MIN_VALUE;
        if(wt[idx] <= W) pick = val[idx] +  helper(wt, val, idx, W-wt[idx], dp);
        return dp[idx][W] = Math.max(notPick, pick);
    }
    static int knapSack(int[] wt, int[] val, int n,int W){

        int[][] dp = new int[n][W+1];
        
        return helper2(wt,val,W,dp);
    }
    public static void main(String[] args) {
        int n = 3;
        int W = 8;
        int[] wt = {2, 4, 6};
        int[] val = {5, 11, 13};
        System.out.println();
        System.out.println(knapSack(wt, val, n, W));

    }
    
}
