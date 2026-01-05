package Day149;

import java.util.Scanner;

public class RearrangeAltposAndNeg {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static int[] rearange(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
       int pos = 0,neg = 1;
       for(int num : arr){
            if(num >=0){
                ans[pos] = num;
                pos+=2;
            }
            else{
                ans[neg] = num;
                neg+=2;
            }
       } 
       return ans;
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
        int[] ans = rearange(arr);
        display(ans);
        sc.close();
    }
    
}
