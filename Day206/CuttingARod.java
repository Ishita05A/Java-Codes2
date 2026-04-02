package Day206;
public class CuttingARod {
    static int cutRod_memo(int[] val, int n, int[] dp) {
    if (n == 0) return 0;

    if (dp[n] != -1) return dp[n];

    int maxValue = Integer.MIN_VALUE;

    for (int i = 1; i <= n; i++) {
        int current = val[i] + cutRod_memo(val, n - i, dp);
        maxValue = Math.max(maxValue, current);
    }

    return dp[n] = maxValue;
}
    static int cutRod(int val,int n){
        if(n<0) return 0;
        int max_Value = Integer.MIN_VALUE;
        for(int i = 1;i<=n;i++){
            max_Value = Math.max(max_Value, cutRod(val, n-1));
        }
        return max_Value;
    }
    public static void main(String[] args) {
        

    }
}
