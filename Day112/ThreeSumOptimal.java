package Day112;

import java.util.*;

public class ThreeSumOptimal {
    static List<List<Integer>> findSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0)
                    j++;
                else if (sum > 0)
                    k--;
                else {
                    List<Integer> a = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(a);
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1])
                        j++;
                    while (j < k && arr[k] == arr[k + 1])
                        k--;
                }

            }

        }
        return new ArrayList<>(ans);

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
        List<List<Integer>> ans = findSum(arr);
        System.out.println(ans);
        sc.close();
    }

}
