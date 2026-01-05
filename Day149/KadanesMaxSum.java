package Day149;

import java.util.Scanner;

public class KadanesMaxSum {
    static int findMaxSum(int[] arr){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            if(sum<0) sum = 0;
            sum+=arr[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findMaxSum(arr));
        sc.close();
    }
    
}
