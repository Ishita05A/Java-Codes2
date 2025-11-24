package Day123;

import java.util.Scanner;
import java.util.*;

public class AggresiveCow {
   
    static boolean canWePlace(int[] arr,int dist,int cows){
        int cow_palced = 1;
        int last = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(arr[i]-last >=dist) {
                cow_palced++;
                last = arr[i];
                if(cow_palced>=cows) return true;
            }
        }
        return false;
    }
     
    static int findMinimumDistance(int[] arr,int cows){
        Arrays.sort(arr);
        int st = 1;
        int end = arr[arr.length-1]-arr[0];
        int ans = 0;
        while(st<=end){
            int mid =(end-st)/2+st;
            if(canWePlace(arr, mid, cows)==true) {
                ans = mid;
                st = mid+1;
            }
            else end = mid -1;
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
        System.out.println("Enter  cows to be placed");
        int k = sc.nextInt();
        System.out.println(findMinimumDistance(arr, k));
        sc.close();

    }
    
}
