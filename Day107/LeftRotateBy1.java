package Day107;

import java.util.Scanner;

public class LeftRotateBy1 {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void reverse(int[] arr,int i,int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    static void rotate_in_Place(int[] arr,int k){
        int n = arr.length;
        k = k%n;
        reverse(arr, 0, k);
        reverse(arr, k+1, n-1);
        reverse(arr, 0, n-1);

    }
    static int[] rotate(int[] arr,int k){
        int n = arr.length;
         k = k%n;
         int[] ans = new int[n];
         int j =0;
         for(int i = n-k;i<n;i++){
            ans[j++] = arr[i];
         }
         for(int i = 0;i<n-k;i++){
            ans[j++] = arr[i];
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
        int[] ans = rotate(arr, 2);
        display(ans);
        rotate_in_Place(arr, 2);
        display(arr);
        sc.close();

    }
    
}
