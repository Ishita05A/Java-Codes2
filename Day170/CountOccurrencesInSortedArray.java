package Day170;

import java.util.Scanner;

public class CountOccurrencesInSortedArray {
    static int count(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target && arr[st] > target) st = mid+1;
            else end = mid -1;
        }
        return -1;
    
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
        System.out.println(count(arr, 0));
        sc.close();
    }
    
}
