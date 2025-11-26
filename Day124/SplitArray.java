package Day124;

import java.util.Scanner;

public class SplitArray {
    static int findMinimum(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++){
            min = Math.min(min, arr[i]);
        }
        return min;
    }
    static int findMaximum(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            max = Math.max(max, arr[i]);
        }
        return max; 
    }
    static int no_of_split(int[] arr,int sum){
        int splits = 1;
        int total_sum = 0;
        for(int num:arr){
            if(total_sum+num<=sum)
                total_sum+=num;
            else{
                splits++;
                total_sum = num;
            }
        }
        return splits;
    }
    static int maximum_sum_onSplitting(int[] arr,int k){
        int st = findMaximum(arr);
        int end = find_sum(arr);
        while(st<=end){
            int mid = (end-st)/2+st;
            int splits = no_of_split(arr, mid);
            if(splits>k) st = mid+1;
            else{
                end = mid -1;
            }
        }
        return st;
    }
     static int find_sum(int[] arr){
        int sum = 0;
        for(int num : arr) sum+=num;
        return sum;
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
        System.out.println("Enter no of splits");
        int splits = sc.nextInt();
        System.out.println(maximum_sum_onSplitting(arr, splits));
        sc.close();
    }
    
}
