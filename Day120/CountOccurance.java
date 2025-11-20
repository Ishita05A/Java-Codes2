package Day120;

import java.util.Scanner;

public class CountOccurance {
    static int findUpperBound(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        int idx = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] == target){
                idx = mid;
                st = mid+1;
            }
            else if(arr[mid] > target) end = mid-1;
            else st = mid+1;
        }
        return idx;
    }
    static int findLowerBound(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        int idx = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] == target){
                idx = mid;
                end = mid-1;
            }
            else if(arr[mid] > target) end = mid-1;
            else st = mid+1;
        }
        return idx;
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
        int target = sc.nextInt();
        int first = findUpperBound(arr, target);
        int last = findLowerBound(arr, target);
        if(first==-1 || last == -1) System.out.println("0");
        else System.out.println(last-first+1);
        sc.close();;
    }
    
}
