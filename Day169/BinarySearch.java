package Day169;

import java.util.Scanner;

public class BinarySearch {
    static int lowerBound(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        int ans =-1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] == target){
                ans = mid;
                end = mid-1;
            }
            else if(arr[mid]>target){
                end = mid-1;
            }
            else st = mid+1;
        }
        return ans;
    }
    static int upperBound(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        int ans = -1;
        while (st<=end) {
            int mid = (end-st)/2+st;
            if(arr[mid] == target){
                ans = mid;
                st = mid+1;
            }
             else if(arr[mid]>target){
                end = mid-1;
            }
            else st = mid+1;

        }
        return ans;
    }
    static int findElement(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] == target) return mid;
            else if(arr[mid]<target) st = mid+1;
            else end = mid-1;
        }
        return -1;
    }
    static int insertPosition(int[] arr, int target){
        int st = 0;
        int end = arr.length-1;
        int ans = -1;
        while (st<=end) {
            int mid = (end-st)/2+st;
            if(arr[mid] >= target){
                ans = mid;
                end = mid-1;
            }
            else st= mid+1;
        }
        return ans;
    }
    static int floorInSorted(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        int ans = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] <= target){
                ans = arr[mid];
                st = mid+1;
            }
            else end = mid-1;
        }
        return ans;
    }
    static int ceilInSorted(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        int ans = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] >= target){
                ans = arr[mid];
                end = mid-1;
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
        // System.out.println(findElement(arr, 6));
        // System.out.println(lowerBound(arr, 2));
        // System.out.println(upperBound(arr, 2));
        // System.out.println(insertPosition(arr,2));
        System.out.println(floorInSorted(arr,5 ));
        System.out.println(ceilInSorted(arr, 5));
        sc.close();
    }
}
