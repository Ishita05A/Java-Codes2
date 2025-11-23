package Day122;

import java.util.Scanner;

public class CapacityToShip {
    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++) max = Math.max(max, arr[i]);
        return max;
    }
    static int find_sum(int[] arr){
        int sum = 0;
        for(int num : arr) sum+=num;
        return sum;
    }
    static int days_req(int[] arr,int cap){
        int day = 1;
        int load = 0;
        for(int i = 0;i<arr.length;i++){
            if(load+arr[i]>cap){
                day++;
                load = arr[i];
            }
            else load+=arr[i];
        }
        return day;
    }
    static int minimum_days_to_ship(int[] arr,int days){
        int st = findMax(arr);
        int end = find_sum(arr);
        int ans = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            int totalDays = days_req(arr, mid);
            if(totalDays<=days){
                end = mid -1;
                ans = mid;
            }
            else st = mid+1;
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
        System.out.println("Enter days limit ");
        int day = sc.nextInt();
        System.out.println(minimum_days_to_ship(arr, day));
        sc.close();
    }
    
}
