package Day124;

import java.util.Scanner;

public class AggressiveCow {
    static int findMinimum(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++) min = Math.min(min, arr[i]);
        return min;
    }
    static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);
        return max;
    }
    static int place_cow(int[] arr,int dist,int k){
        int cow = 1;
        int min_dist = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(arr[i]-min_dist<=dist){
                cow++;
                min_dist = arr[i];
                if(cow >=k) return cow;
            }
        }
        return cow;
    }
    static int minimum_possible_distance(int[] arr,int k){
        int st = 1;
        int ans = -1;
        int end = findMax(arr) - findMinimum(arr);
        while(st<=end){
            int mid = (end-st)/2+st;
            int cow_placed = place_cow(arr, mid, k);
            if(cow_placed >= k){
                ans = mid;
                end = mid-1; 
            }
            else st = mid +1;
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
        System.out.println("Enter no of cows");
        int k = sc.nextInt();
        System.out.println(minimum_possible_distance(arr, k));
        sc.close();
    }
    
}
