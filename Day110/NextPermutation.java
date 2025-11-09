package Day110;

import java.util.Scanner;

public class NextPermutation {
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
    static void reverse(int[] arr,int i,int j){
        while(i<j){
            int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
        }
    }
    static void next_pmt(int[] arr){
        int n = arr.length;
        int i = n-2;
        while(i>=0 && arr[i]>=arr[i+1]) i--;
        int j = n-1;
        while(j >=0 && arr[j]<arr[i]) j--;
        if(i>=0) swap(arr,i,j); 
        reverse(arr,i+1,n-1);

        

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
        next_pmt(arr);
        display(arr);
        sc.close();
    }
    
}
