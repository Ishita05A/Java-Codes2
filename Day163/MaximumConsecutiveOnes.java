package Day163;

import java.util.Scanner;

public class MaximumConsecutiveOnes {
    static int noThatAppearsOnce(int[] arr){
        int xor = 0;
        for(int i = 0;i<arr.length;i++){
            xor^=arr[i];
        }
        return xor;
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
        System.out.println(noThatAppearsOnce(arr));
        sc.close();
    }
    
}
