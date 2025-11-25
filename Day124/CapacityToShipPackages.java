package Day124;

import java.util.Scanner;

public class CapacityToShipPackages {
    static int findMinimum(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++) min = Math.min(min, arr[i]);
        return min;
    }
    static int find_sum(int[] arr){
        int sum = 0;
        for(int num : arr) sum+=num;
        return sum;
    }
    static int find_days(int[] arr,int cap){
        int days = 1;
        int load = 0;
        for(int num : arr){
            if(num+load<=cap){
                load+=num;
            }
            else{
                days++;
                load = num;
            }
        }
        return days;
    }
    static int mimimum_weight(int[] arr,int days){
        int st = findMinimum(arr);
        int end = find_sum(arr);
        int ans = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            int day_require = find_days(arr,mid);
            if(day_require<=days){
                ans = mid;
                end = mid -1;
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
        System.out.println("Enter days");
        int m = sc.nextInt();
        System.out.println(mimimum_weight(arr, m));
        sc.close();
    }
    
}
