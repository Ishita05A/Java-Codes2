package Day108;

import java.util.HashSet;
import java.util.Scanner;

public class twoSum {
    static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] two_sum(int[] arr, int k) {
        int n = arr.length;
        HashSet<Integer> mp = new HashSet<>();
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            if (mp.contains(k - arr[i])) {
                ans[1] = arr[i];
                ans[0] = k - arr[i];
                return ans;
            }

            mp.add(arr[i]);
        }
        return new int[] { -1, -1 };
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
        int[] ans = two_sum(arr, 14);
        display(ans);
        sc.close();
    }

}
