package Day167;

import java.util.Scanner;

public class StockBuyAndSell {
    static int findProfit(int[] arr){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price: arr){
            if(price < minPrice){
                minPrice = price;
            }
            maxProfit = Math.max(maxProfit,price-minPrice);
        }
        return maxProfit;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements for value");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findProfit(arr));
        sc.close();
    }
    
}
