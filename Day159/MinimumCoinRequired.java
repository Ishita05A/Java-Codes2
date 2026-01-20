package Day159;

import java.util.Scanner;

public class MinimumCoinRequired {
    static int countCoinRequired(int[] arr,int v){
        int i = arr.length-1;
        int count = 0;
        while(i>=0){
            while(arr[i] <= v){
                v-=arr[i];
                count++;
            }
            i--;
        }
        return count;
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
        System.out.println("Enter coin value");
        int coinValue = sc.nextInt();
        System.out.println(countCoinRequired(arr, coinValue));
        sc.close();

    }
    
}
