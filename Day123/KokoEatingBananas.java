package Day123;

import java.util.Scanner;

public class KokoEatingBananas {
    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++) max = Math.max(max, arr[i]);
        return max;
    }
    static int calulate_hour(int[] arr,int n){
        int hour = 0;
        for(int num : arr){
            hour+=((int)Math.ceil((double)num/n));
        }
        return hour;
    }
    static int minimum_bananas(int[] arr,int hours){
        int st = 1;
        int end = findMax(arr);
        int ans = -1;
        while(st<=end){
            int mid = (end - st)/2+st;
            int calculated_hour = calulate_hour(arr, mid);
            if(calculated_hour <= hours){
                ans  = mid;
                end = mid -1;
            }
            else st = mid + 1;
        }
        return ans;
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
        System.out.println("Enter limit Hours");
        int hour = sc.nextInt();
        System.out.println(minimum_bananas(arr, hour));
        sc.close();
    }
    
}
