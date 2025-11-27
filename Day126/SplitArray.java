package Day126;

import java.util.Scanner;

public class SplitArray {
    static int  findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num:arr) max = Math.max(max, num);
        return max;
    }
    static int findSum(int[] arr){
        int sum = 0;
        for(int num : arr) sum+=num;
        return sum;
    }
    static int find_splits(int[] arr,int sum){
        int splits = 1;
        int total_sum = 0;
        for(int num:arr){
            if(total_sum+num<=sum) total_sum+=num;
            else{
                total_sum = num;
                splits++;
            }
        }
        return splits;
    }
    static int find_largest_sum(int[] arr,int k){
        int st = findMax(arr);
        int end = findSum(arr);
        int ans = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            int splits = find_splits(arr, mid);
            if(splits > k) st = mid +1;
            else{
                ans = mid;
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
        System.out.println("Enter no of splits");
        int k = sc.nextInt();
        System.out.println(find_largest_sum(arr, k));
        sc.close();
    }
    
}
