package Day117;

import java.util.Scanner;

public class SortedArray {
    static int remove_duplicates(int[] arr){
        int k = 1;
        for(int i = 1;i<arr.length;i++){
            if(arr[i] != arr[i-1]){
                arr[k++] = arr[i];
            }
        }
        return k;
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
       int len = remove_duplicates(arr);
       for(int i = 0;i<len;i++){
        System.out.print(arr[i]+" ");
       }
        sc.close();
    }
    
}
