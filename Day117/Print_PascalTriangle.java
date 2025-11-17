package Day117;

import java.util.*;
import java.util.Scanner;

public class Print_PascalTriangle {
    static List<List<Integer>> print_pascal_triangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int row = 1; row <=n; row++) {
            List<Integer> a = new ArrayList<>();
            int res = 1;
            a.add(1);
            for (int col = 1; col < row; col++) {
                res *= (row - col);
                res /= col;
                a.add(res);

            }
            ans.add(a);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row");
        int n = sc.nextInt();
        List<List<Integer>> ans = print_pascal_triangle(n);
        System.out.println(ans);
        sc.close();

    }

}
