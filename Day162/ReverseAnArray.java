package Day162;

import java.util.Scanner;

public class ReverseAnArray {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void reverseArray(int[] arr,int i,int j){
        if(i>=j) return;
        swap(arr,i,j);
        reverseArray(arr, i+1, j-1);
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
        reverseArray(arr, 0, n-1);
        display(arr);
        sc.close();

    }
    
}
