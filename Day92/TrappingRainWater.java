// package Day92;

import java.util.Scanner;

public class TrappingRainWater{
    static int traping_rw(int[] arr){
        int n = arr.length;
        int l = 0,r = n-1, lMax = 0, rMax = 0,total = 0;
        while(l<r){
            if(arr[l] <= arr[r]){
                if( lMax > arr[l]) total +=lMax-arr[l];
                else lMax = arr[l];
                l++;
            }
            else{
                if(rMax > arr[r]) total +=rMax - arr[r];
                else rMax = arr[r];
                r--;
            }
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
        System.out.println(traping_rw(arr));
        sc.close();
    }
}