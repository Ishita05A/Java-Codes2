package Day88;

import java.util.HashMap;
import java.util.Scanner;

public class countSubArraywithTargetSum {
    static int countSubArray(int[] arr, int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == target)
                    count++;
            }
        }
        return count;
    }

    static int countSubArray2(int[] arr, int target) {
        int prefixSum = 0;

        int count = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
             if (mp.containsKey(prefixSum - target))
                count += mp.get(prefixSum - target);
            if (!mp.containsKey(prefixSum))
                mp.put(prefixSum, 1);

            else
                mp.put(prefixSum, mp.get(prefixSum) + 1);
           
        }
        return count;
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
        System.out.println("Enter Target");
        int x = sc.nextInt();
        System.out.println(countSubArray(arr, x));
        sc.close();
    }

}
