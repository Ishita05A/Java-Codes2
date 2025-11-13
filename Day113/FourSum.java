package Day113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class FourSum {
    static List<List<Integer>>
    static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                HashSet<Integer> mp = new HashSet<>();
                sum = arr[i] + arr[j];
                sum += arr[k];
                int temp = target - sum;
                if (mp.contains(temp)) {
                    List<Integer> a = Arrays.asList(arr[i], arr[j], arr[k], temp);
                    a
                    ans.add(a);

                }
                mp.add(arr[k]);
                j++;
                k--;
            }

        }
        return ans;

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
        System.out.println("Enter target");
        int target = sc.nextInt();
        List<List<Integer>> ans = fourSum(arr, target);
        System.out.println(ans);
        sc.close();
    }

}
