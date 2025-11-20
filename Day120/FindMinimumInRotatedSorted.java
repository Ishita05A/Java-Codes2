package Day120;

import java.util.Scanner;

public class FindMinimumInRotatedSorted {
    static int findMinimum(int[] arr){
        int st = 0;
        int end = arr.length-1;
        int ans =Integer.MAX_VALUE;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] >= arr[st]){
                ans = Math.min(ans, arr[st]);
                st = mid+1;
            }
            else{
                ans = Math.min(ans, arr[mid]);
                end = mid - 1;
            }
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
        System.out.println(findMinimum(arr));
        sc.close();
    }
    
}
