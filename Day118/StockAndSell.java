package Day118;

import java.util.Scanner;

public class StockAndSell {
    static int find_profit2(int[] arr){
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++){
            buy = Math.min(buy, arr[i]);
            profit = Math.max(profit, arr[i]-buy);
        }
        return profit;
    }
    static int findProfit(int[] arr){
        int profit = 0;
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]-arr[i]>profit) profit = arr[j]-arr[i];
            }
        }
        return profit;
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
        System.out.println(find_profit2(arr));
        System.out.println(findProfit(arr));
        sc.close();
    }
}
