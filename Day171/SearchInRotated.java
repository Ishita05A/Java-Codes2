package Day171;

import java.util.Scanner;

public class SearchInRotated {
    static boolean findElement(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] == target) return true;
            if(arr[st] == arr[mid] && arr[mid]== arr[end]){
                st++;
                end--;
                continue;
            }
            if(arr[mid] >= arr[st]){
                if(arr[st]<= target && arr[mid]>=target) end = mid-1;
                else st = mid + 1;
            }
            else{
                if(arr[mid]<=target && arr[end] >= target)   st= mid+1;
                else end = mid - 1;
            }

        }
        return false;
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
        System.out.println(findElement(arr, 1));
        sc.close();
    }
}
