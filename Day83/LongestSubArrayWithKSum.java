package Day83;

import java.util.Scanner;

public class LongestSubArrayWithKSum {
    // static int longestSubArray(int[] arr,int target){
    // int max = 0;
    // int count = 0;
    // int sum = 0;
    // for(int i = 0;i<arr.length;i++){
    // sum += arr[i];
    // count++;
    // if(sum == target){
    // max = Math.max(max, count);
    // count = 0;
    // sum = 0;
    // }
    // }
    // return max;

    // }

    static int longestSubArrayBruteForce(int[] arr, int target) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == target) {

                    max = Math.max(max, j - i + 1);

                }
            }

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
        System.out.println("Enter target");
        int x = sc.nextInt();
        // System.out.println(longestSubArray(arr, x));
        System.out.println(longestSubArrayBruteForce(arr, x));
        sc.close();
    }
}
