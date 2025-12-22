package Day139;

import java.util.Scanner;

public class NumberAppearedOddTimes {
    static int numberAppearedOddTimes(int[] arr){
        int xor = 0;
        for(int num : arr) xor ^= num;
        return xor;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(numberAppearedOddTimes(arr));
        sc.close();
    }
    
}
