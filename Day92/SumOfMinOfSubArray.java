import java.util.Scanner;

public class SumOfMinOfSubArray {
    static int min_Of_SubArray_sum(int[] arr){
        int sum = 0;
        int mod = (int)(1e9)+7;
        for(int i = 0 ;i<arr.length;i++){
            int min  = Integer.MAX_VALUE;
            for(int j = i;j<=arr.length-1;j++){
                min = Math.min(min,arr[j]);
                sum = (sum +min)%mod;
            }
            
        }
        return sum;
    }
    static int sumSubarrayMins(int[] arr) {
    int n = arr.length;
    long mod = (long)1e9 + 7;
    long sum = 0;
    for (int i = 0; i < n; i++) {
        int min = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            min = Math.min(min, arr[j]);
            sum = (sum + min) % mod;
        }
    }
    return (int)sum;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // System.out.println(min_Of_SubArray_sum(arr));
        System.out.println(sumSubarrayMins(arr));
        sc.close();
    }

    
}
