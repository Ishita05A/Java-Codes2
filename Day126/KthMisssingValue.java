package Day126;

import java.util.Scanner;

public class KthMisssingValue {
    
    static int find_missing_number(int[] arr,int k){
        int n = arr.length;
        int st = 1;
        int end = n-1;
        while(st <= end){
            int mid = (end-st)/2+st;
            int missing = arr[mid]-(mid+1);
            if(missing > k) end = mid-1;
            else
                st = mid+1;
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
        System.out.println("Enter target");
        int target = sc.nextInt();
        System.out.println(find_missing_number(arr, target));
        sc.close();
    }
    
}
