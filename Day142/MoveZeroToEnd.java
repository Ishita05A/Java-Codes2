package Day142;

import java.util.Scanner;

public class MoveZeroToEnd {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void moveZeroTOEnd(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            if(arr[i] == 0 && arr[j] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            else if(arr[i] != 0) i++;
            else if(arr[j] == 0) j--;
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
        moveZeroTOEnd(arr);
        display(arr);
        sc.close();
    }
    
}
