package Day107;

import java.util.Scanner;

public class SortedArray {
    static boolean is_sorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) return false;
            }
        }
        return true;

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
        System.out.println(is_sorted(arr));
        sc.close();
    }

}
