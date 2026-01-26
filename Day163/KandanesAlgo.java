package Day163;

import java.util.Scanner;

public class KandanesAlgo {
    static int maxSubArraySum(int[] arr){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            
            max = Math.max(max, sum);
            if(sum<0) sum = 0;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements for value");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSubArraySum(arr));
        sc.close();
    }
    
}
