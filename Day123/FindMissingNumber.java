package Day123;

import java.util.Scanner;

public class FindMissingNumber {
    static int findMissing(int[] arr,int k){
        int st = 0;
        int end = arr.length-1;
        while(st<=end){
            int mid = (end-st)/2+st;
            int missing = arr[mid]-(mid+1);
            if(missing<k) st = mid+1;
            else end = mid - 1;
        }
        return st+k;
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
        System.out.println("Enter  missing position");
        int k = sc.nextInt();
        System.out.println(findMissing(arr, k));
        sc.close();

    }
    
}
