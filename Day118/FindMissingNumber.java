package Day118;

import java.util.Scanner;

public class FindMissingNumber {
    static int find_missing(int[] arr){
        int n = arr.length+1;
        int target = ((n)*(n+1))/2;
        int actual_sum = 0;
        for(int i = 0;i<arr.length;i++){
            actual_sum+=arr[i];
        }
        return target-actual_sum;
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
        System.out.println(find_missing(arr));
        sc.close();
    }
    
}
