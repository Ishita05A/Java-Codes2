package Day144;

import java.util.Scanner;

public class MaximumPointsFromCard {
    static int maxCount(int[] arr,int k){
        
        int sum = 0;
        int n =arr.length;
        for(int i = 0;i<k;i++){
            sum+=arr[i];
        }
        int max = sum;
        
        for(int i = 0;i<k;i++){
            sum +=arr[n-i-1];
            sum-= arr[k-i-1]; 
            max = Math.max(max, sum);
        }
        return max;

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
        System.out.println(maxCount(arr, 3));
        sc.close();
    }

    
}
