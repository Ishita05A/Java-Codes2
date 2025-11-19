package Day119;

import java.util.Scanner;

public class NextPermutaion {
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
    static void findNextPermutaion(int[] arr){
        int n = arr.length;
        int i = n-2;
        while (i>=0 && arr[i] >= arr[i+1])  i--;
        
        if(i>=0){
            int j = n-1;
        while(arr[j]<=arr[i]) j--;  
        
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        
        }
        reverse(arr, i+1, n-1);      
        

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
        findNextPermutaion(arr);
        display(arr);
        sc.close();
    }
    
}
