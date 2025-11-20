package Day120;

import java.util.Scanner;


public class BSinRotatedSortedArray {
    static int findElement(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        while(st<=end){
            int mid = (end - st)/2+st;
            if(arr[mid] == target) return mid;
            // Check if left is sorted
            else if(arr[mid] >= arr[st]){
                if(arr[st] <= target && target<=arr[mid]) end = mid -1;
                else st = mid +1;
            }
            else{
                    if(arr[mid] <= target && target<= arr[end]) st  = mid+1;
                    else end = mid - 1;
            }
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
        System.out.println("Enter target");
        int target = sc.nextInt();
        System.out.println(findElement(arr, target));
        sc.close();
    }
    
}
