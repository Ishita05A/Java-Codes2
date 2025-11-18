package Day118;

import java.util.Scanner;

public class RearrangeArrayinAltPOS_NEG {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int[] rearrange(int[] arr){
        int odd = 1;
        int even = 0;
        int[] ans = new int[arr.length];
        for(int i =0;i<arr.length;i++){
            if(arr[i] >= 0) {
                ans[even] = arr[i];
                even+=2;
            }
            else {
                ans[odd] = arr[i];
                odd+=2;
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
        int[] ans = rearrange(arr);
        display(ans);
        sc.close();
        
    }
    
}
