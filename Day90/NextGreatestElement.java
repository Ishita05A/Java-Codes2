package Day90;

import java.util.Scanner;

// Input: N = 11, A[] = {3,10,4,2,1,2,6,1,7,2,9}

// Output: 10,-1,6,6,2,6,7,7,9,9,-1

public class NextGreatestElement {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int[] next_greatest(int[] arr){
        
        for(int i = 0;i<arr.length;i++){
            boolean flag = true;
            for(int j = i;j<arr.length;j++){
                if(arr[j]>arr[i]){
                    arr[i] = arr[j];
                    flag = false;
                    break;
                }
            }
            if(flag) arr[i] = -1;
        }
        return arr;


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
        next_greatest(arr);
        display(arr);
        sc.close();
    }
    
}
