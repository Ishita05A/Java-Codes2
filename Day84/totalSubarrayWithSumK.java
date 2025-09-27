package Day84;

import java.util.Scanner;

public class totalSubarrayWithSumK {
    static int totalPair(int[] arr,int target){
        
        int count = 0;
        for(int i = 0; i<arr.length;i++){
            int sum = 0;
            for(int j = i;j<arr.length;j++){
                sum+=arr[j];
                if(sum == target) count++;
            }
        }
        return count;
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
        System.out.println("Enter target");
        int x = sc.nextInt();
        System.out.println(totalPair(arr, x));
        sc.close();
    }
}
