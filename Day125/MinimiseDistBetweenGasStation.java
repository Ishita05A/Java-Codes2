package Day125;

import java.util.Scanner;

public class MinimiseDistBetweenGasStation {
    static double minimize_distance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n];
        for (int gasStation = 1; gasStation <= k; gasStation++) {
            double maxSection = -1;
            int maxInd = -1;
            for (int i = 0; i < n - 1; i++) {
                double diff = (arr[i + 1] - arr[i]);
                double sectionLength = diff / (double) (howMany[i] + 1);
                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            howMany[maxInd]++;
        }
        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = (arr[i + 1] - arr[i]);
            double sectionLength = diff / (double) (howMany[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
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
        System.out.println("Enter no. of gas Stations");
        int k = sc.nextInt();
        System.out.println(minimize_distance(arr, k));
        sc.close();
    }

}
