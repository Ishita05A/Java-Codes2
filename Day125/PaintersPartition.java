package Day125;

import java.util.Scanner;

public class PaintersPartition {
    static int findMaximum(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num : arr) max = Math.max(max,num);
        return max;
    }
    static int find_sum(int[] arr){
        int sum = 0;
        for(int num : arr) sum += num;
        return sum;

    }
    static int find_painters(int[] arr,int sum){
        int painters = 1;
        int units = 0;
        for(int num: arr){
            if(num+units <= sum) units+=num;
            else{
                painters++;
                units = num;
            }
        }
        return painters;

    }
    static int minimum_Time(int[] arr,int k){
        int st = findMaximum(arr);
        int end = find_sum(arr);
        int ans = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            int painters = find_painters(arr, mid);
            if(painters>k){
                
                st = mid + 1;
            }
            else {
                ans = mid;
                end = mid -1;
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
        System.out.println("Enter no of painters");
        int painters = sc.nextInt();
        System.out.println(minimum_Time(arr, painters));
        sc.close();

    }
    
}
