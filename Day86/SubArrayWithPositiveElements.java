package Day86;

import java.util.Scanner;

public class SubArrayWithPositiveElements {
    static int longestSubArray(int[] arr, int target) {
        int max = 0;
        int st = 0;
        int sum = 0;
        for(int end = 0;end<arr.length;end++){
            sum+=arr[end];
            while(sum > target && st<=end){
                sum-=arr[st];
                st++;
            }
            if(sum == target) max = Math.max(max, end-st+1);
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
        System.out.println(longestSubArray(arr, x));
        sc.close();
    }

}
