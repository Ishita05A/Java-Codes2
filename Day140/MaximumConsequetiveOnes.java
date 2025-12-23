package Day140;

import java.util.Scanner;

public class MaximumConsequetiveOnes {
    static int maximumConsequetiveOnes_brute(int[] arr,int k){
        int max = 0;
        int zero = 0;
        for(int i = 0;i<arr.length;i++){
            zero = 0;
            for(int j = i;j<arr.length;j++){
                if(arr[j] == 0) zero++;
                if(zero>k) break;
                max = Math.max(max, j-i+1);
            }
        }
        return max;
    }
    static int maximumConsequetiveOnes_optimized(int[] arr,int k){
        int max = 0;
        int l = 0;
        int c = 0;
        for(int r = 0;r<arr.length;r++){
            if(arr[r] == 0) c++;
            if(c>k){
                while(arr[l]!=0){
                    l++;
                }
                l++;
                c--;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maximumConsequetiveOnes_brute(arr, 2));
        System.out.println(maximumConsequetiveOnes_optimized(arr, 2));
        sc.close();
    }
    
}
