package Day227;

public class FrogJump {
    static int helper_tab(int[] arr,int idx, int[] dp){
        dp[0] = 0;
        for(int i = 1;i<=idx;i++){
            int fst = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
            int sec = Integer.MAX_VALUE;
            if(i-2 >=0) sec = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            dp[i] = Math.min(fst, sec);
        }
        return dp[idx];
    }
    static int helper(int[] arr, int idx,int[] dp){
        if(idx == 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int fst = helper(arr, idx-1, dp) + Math.abs(arr[idx] - arr[idx-1]);
        int sec = Integer.MAX_VALUE;
        if(idx-2 >= 0) sec = helper(arr, idx-2, dp) + Math.abs(arr[idx] -arr[idx-2]); 
        return dp[idx] = Math.min(fst, sec);
    }
    static int minEnergy(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        return helper_tab(arr,n-1,dp);
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4};
        System.out.println(minEnergy(arr));
        
    }
    
}
