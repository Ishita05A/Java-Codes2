package Day127;

import java.util.Scanner;

public class median {
    static double find_median(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2;
        int i = 0, j = 0;
        int ele1 = -1, ele2 = -1;
        int idx2 = n / 2;
        int idx1 = idx2 - 1;
        int cnt = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (cnt == idx2)
                    ele2 = arr1[i];
                if (cnt == idx1)
                    ele1 = arr1[i];
                cnt++;
                i++;
            } else {
                if (cnt == idx2)
                    ele2 = arr2[j];
                if (cnt == idx1)
                    ele1 = arr2[j];
                cnt++;
                j++;
            }
            if (cnt > idx2)
                break;
        }
        while (i < n1 && cnt <= idx2) {
            if (cnt == idx2)
                ele2 = arr1[i];
            if (cnt == idx1)
                ele1 = arr1[i];
            cnt++;
            i++;
        }
        while (j < n2 && cnt <= idx2) {
            if (cnt == idx2)
                ele2 = arr2[j];
            if (cnt == idx1)
                ele1 = arr2[j];
            cnt++;
            j++;
        }
        if(n%2 == 1) return ele2;
        double sum = (double)(ele1+ele2)/2;
        return sum;
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
        System.out.println("Enter no. of elements");
        int m = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr1 = new int[m];
        for (int j = 0; j < m; j++) {
            arr1[j] = sc.nextInt();
        }
        System.out.println(find_median(arr, arr1));
        sc.close();
    }

}
