package Day105;

import java.util.Scanner;


public class reverseArray {
    static void disaply(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void reverse(int[] arr,int idx){
        if(idx == 0) return;
        System.out.print(arr[idx-1]+" ");
        reverse(arr, idx-1);
        
    }
    static void reverseArr(int[] arr,int st,int end){
        if(st>=end) return;
        int temp = arr[st];
        arr[st] = arr[end];
        arr[end] = temp;
        reverseArr(arr, st+1, end-1);
        
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
        reverseArr(arr, 0,n-1);
        disaply(arr);
        sc.close();
    }
    
}
