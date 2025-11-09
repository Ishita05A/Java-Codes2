package Day109;

import java.util.Scanner;

public class BuyAndSellStock {
    static int maxProfit(int[] arr){
        int mini=arr[0];
        int profit = 0;
        int cost = 0;
        for(int i =1;i<arr.length;i++){
            cost = arr[i]-mini;
            profit = Math.max(cost, profit);
            mini = Math.min(mini,arr[i]);
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
        System.out.println(maxProfit(arr));
        sc.close();
    }
    
}
