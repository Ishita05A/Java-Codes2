package Day184;

import java.util.Scanner;

public class SearchInRoatedSorted {
    static int sqrtOfNumber(int n){
        if(n == 0 || n == 1) return n;
        int st = 0;
        int end = n;
        int ans = 0;
        while(st<=end){
            int mid = (end-st)/2 + st;
            long sq = mid*mid;
            if(sq == n) return mid;
            if(sq< n){
                ans = mid;
                st = mid+1;
            } 
            else end = mid - 1;
        }
        return ans;
        
    }
    static int findPeak(int[] arr){
        int st = 1;
        int n = arr.length;
        int end = arr.length-2;
        if(n == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid-1] < arr[mid] && arr[mid] >arr[mid+1]) return mid;
            if(arr[mid] < arr[mid+1]) st = mid + 1;
            else end = mid - 1;  
        }
        return -1;
    }
    static int findElementInRotated(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] == target) return mid;
            if(arr[st] < arr[mid]){
                if(arr[mid] >= target && arr[st]<=target){
                    end = mid-1;
                }
                else st = mid+1;
            }else{
                if(arr[mid] <=target && target <= arr[end]){
                    st = mid + 1;
                }
                else end = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter no. of elements");
        // int n = sc.nextInt();
        // System.out.println("Enter elements ");
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        //     arr[i] = sc.nextInt();
        // }
        // System.out.println(findElementInRotated(arr, 0));
        // System.out.println(findPeak(arr));
        System.out.println(sqrtOfNumber(4353));
        sc.close();
    }
    
}
