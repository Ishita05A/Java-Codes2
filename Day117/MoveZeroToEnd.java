package Day117;

import java.util.Scanner;

public class MoveZeroToEnd {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void move_zero_to_end(int[] arr){
        int k = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != 0) arr[k++] = arr[i];
        }
        for(int i = k;i<arr.length;i++) arr[i++] = 0;
    }
    static void move_zero_to_end2(int[] arr){
        int j = -1;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0) {
                j = i;
                break;
            }
        }
        if(j == -1) return;
        for(int i = j+1;i<arr.length;i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
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
        move_zero_to_end2(arr);
        display(arr);
        sc.close();
        
    }
    
}
