package Day139;

import java.util.Scanner;

public class MaximumProductSum {
    static int totalSum(int[] arr){
        int sum = 0;
        for(int num : arr) sum+=num;
        return sum;
    }
    static int max_prod_sum(int[] arr){
        int prefix = 1;
        int suffix = 1;
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            if(suffix == 0) suffix = 1;
            if(prefix == 0) prefix = 1;
            suffix*=arr[i];
            prefix*=arr[n-i-1];
            max= Math.max(max, Math.max(suffix, prefix));
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(max_prod_sum(arr));
        sc.close();
    }
    
}
