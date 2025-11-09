package Day109;

import java.util.Scanner;

public class AltPostiveAndNegative {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int[] alternateArr(int[] arr){
        int[] ans = new int[arr.length];
        int odd_idx=1;
        int even_idx=0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]< 0){
                ans[odd_idx] = arr[i];
                odd_idx+=2;
            }
            else{
                ans[even_idx]= arr[i];
                even_idx+=2;
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
        int[] ans = alternateArr(arr);
        display(ans);
        sc.close();
    }
    
}
