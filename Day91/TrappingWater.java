package Day91;

import java.util.Scanner;

// Input: height= [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
// Output: 6

public class TrappingWater {
    static int trapping_water(int[] arr) {
        int n = arr.length;
        int total = 0;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(arr[i], prefixMax[i-1]);
        }

        suffixMax[n-1] = arr[n-1];
        for(int i = n-2;i>=0;i--){
            suffixMax[i] = Math.max(arr[i], suffixMax[i+1]);
        }

        for(int i = 0; i<n;i++){
            int leftMax = prefixMax[i] , rightMax = suffixMax[i];
            if(arr[i] < leftMax && arr[i] < rightMax)
            total += Math.min(leftMax, rightMax) -arr[i];
        }
        return total;

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
        System.out.println(trapping_water(arr));
        sc.close();
    }

}
