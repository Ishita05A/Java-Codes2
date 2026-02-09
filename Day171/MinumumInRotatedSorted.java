package Day171;

import java.util.Scanner;

public class MinumumInRotatedSorted {
    static int findPeak(int[] arr){
        int n = arr.length;
        if(arr.length==1) return arr[0];
        if(arr[0]>arr[1]) return arr[0];
        if(arr[n-1] > arr[n-2]) return arr[n-1];
        int st = 1;
        int end = n-2;
        while(st<=end){
            int mid = (st+end)/2;
            if(arr[mid-1] < arr[mid] && arr[mid]>arr[mid+1]) return arr[mid];
            else if(arr[mid] > arr[mid-1]) st = mid+1;
            else end = mid-1;
        }
        return -1;
    }
    static int singleElement(int[] arr){
        int n = arr.length;
        if(arr[0] != arr[1]) return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-1];
        int st = 1;
        int end = n-2;
        while(st<=end){
            int mid = (st+end)/2;
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) return arr[mid];
            else if((mid % 2 == 1 && arr[mid] == arr[mid-1]) || (mid%2 == 0 && arr[mid] == arr[mid+1])) st = mid+1;
            else end = mid -1;
        }
        return -1;

    }
    static int noOfTimeRotated(int[] arr){
        int st = 0;
        int end = arr.length-1;
        int idx = 0;
        while(st<=end){
            int mid = (st+end)/2;
            idx = mid;
            if(arr[mid]>arr[end]){
                
                st = mid + 1;
            }
            else end = mid-1;
        }
        return idx;
    }
    static int findMin(int[] arr){
        int st = 0;
        int end = arr.length-1;
        int min = 0;
        while(st<=end){
            int mid = (st+end)/2;
            if(arr[st]<=arr[mid]){
                min = arr[mid];
                if(mid+1 < arr.length && arr[mid]<arr[mid+1]) end = mid-1;
                else st = mid+1;
            }
            else{
                min = arr[mid];
                if(mid+1 >= 0 && arr[mid] > arr[mid-1]) end = mid-1;
                else st = mid+1;
            }
        }
        return min;
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
        // System.out.println(findMin(arr));
        // System.out.println(noOfTimeRotated(arr));
        // System.out.println(singleElement(arr));
        System.out.println(findPeak(arr));
        sc.close();
    }
    
}
