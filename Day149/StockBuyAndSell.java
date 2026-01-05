package Day149;

import java.util.Scanner;

public class StockBuyAndSell {
    static int findMaxProfit_optimized(int[] arr){
        int mini = arr[0];
        int maxProfit = 0;
        for(int i = 1;i<arr.length;i++){
            int cost = arr[i]-mini;
            if(cost>maxProfit){
                maxProfit = cost;
                
            }
            mini = Math.min(mini, arr[i]);
        }
        return maxProfit;
    }
    static int findMaxProfit_brute(int[] arr){
        int maxProfit = 0;
        int profit = 0;
        int n = arr.length;
        for(int buy = 0;buy<n-1;buy++){
            for(int sell = buy+1;sell<n;sell++){
                profit = arr[sell]-arr[buy];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findMaxProfit_brute(arr));
        System.out.println(findMaxProfit_optimized(arr));
        sc.close();
    }
    
}
