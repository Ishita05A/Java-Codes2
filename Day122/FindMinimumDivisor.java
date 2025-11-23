package Day122;

import java.util.Scanner;

public class FindMinimumDivisor {
    static int find_DivisionSum(int[] arr,int n){
        int sum  =0;
        for(int i = 0;i<arr.length;i++){
            sum+=(int)Math.ceil((double)arr[i]/n);
        }
        return sum;
    }
    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    static int Smallest_Divisor(int[] arr,int limit){
        int st = 1;
        int end = findMax(arr);
        int ans = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            int sum = find_DivisionSum(arr, mid);
            if(sum<=limit){
                end = mid - 1;
                ans = mid;
            }
            else st = mid+1;
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
        System.out.println("Enter limit");
        int limit = sc.nextInt();
        System.out.println(Smallest_Divisor(arr, limit));
        sc.close();
    }
    
}
