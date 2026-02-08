package Day170;

import java.util.Scanner;

public class BinarySearch {
    static int lowerBound(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        int idx = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] == target){
                idx = mid;
                end= mid-1;
            }
            else if(arr[mid] > target) end = mid-1;
            else st = mid + 1;
        }
        return idx;
    }
    static int upperBound(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        int idx = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] == target){
                idx = mid;
                st= mid+1;
            }
            else if(arr[mid] > target) end = mid-1;
            else st = mid + 1;
        }
        return idx;
    }
    static int[] findRange(int[] arr,int target){
        int low = lowerBound(arr, target);
        int high = upperBound(arr, target);
        return new int[] {low,high};
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
        int[] ans = findRange(arr, 8);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
        sc.close();
    }
    
}
