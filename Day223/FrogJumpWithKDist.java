package Day223;
import java.util.Arrays;

public class FrogJumpWithKDist {

    static int minDist_tab(int idx, int k, int[] arr,int[] dp){
        dp[0] = 0;

        for(int i = 1;i<=idx;i++){
            int minStep = Integer.MAX_VALUE;
            int jump = Integer.MAX_VALUE;
            for(int j = 1;j<=k; j++){
                if (i-j>=0) {
                    jump = dp[i-j]+ Math.abs(arr[i]-arr[i-j]);
                    minStep = Math.min(jump, minStep);
                }
            }
            dp[i] = minStep;
        }
        return dp[idx];
    }

    static int minDist_memo(int idx,int k, int[] arr, int[] dp){
        if(idx == 0) return 0;
        int min_step = Integer.MAX_VALUE;
        if(dp[idx] != -1) return dp[idx];
        for(int i = 1;i<=k;i++){
            int jump = Integer.MAX_VALUE;
            if(idx - i >= 0) jump = minDist_memo(idx-i, k, arr,dp)+Math.abs(arr[idx] - arr[idx-i]);
            min_step = Math.min(min_step, jump);
        }
        return dp[idx] = min_step;
    }

    static int minDist_rec(int idx,int k, int[] arr){
        if(idx == 0) return 0;
        int min_step = Integer.MAX_VALUE;
        for(int i = 1;i<=k;i++){
            int jump = Integer.MAX_VALUE;
            if(idx - i >= 0) jump = minDist_rec(idx-i, k, arr)+Math.abs(arr[idx] - arr[idx-i]);
            min_step = Math.min(min_step, jump);
        }
        return min_step;
        
    }
    public static void main(String[] args) {
        int[] arr = {10,5,20,0,15};
        System.out.println(minDist_rec(4, 2, arr));
        int[] dp = new int[5];
        Arrays.fill(dp, -1);
        System.out.println(minDist_memo(4, 2, arr, dp));
        System.out.println(minDist_tab(4, 2, arr, dp));

    }
    
}
