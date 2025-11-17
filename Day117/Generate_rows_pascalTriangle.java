package Day117;


import java.util.ArrayList;
import java.util.Scanner;

public class Generate_rows_pascalTriangle {
    static ArrayList<Integer> generateRows(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int res = 1;
        ans.add(1);
        for (int col = 1; col < n; col++) {
            res*=(n-col);
            res/=col;
            ans.add(res);
        }
        return ans;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row");
        int n = sc.nextInt();
        ArrayList<Integer> ans = generateRows(n);
        System.out.println(ans);
        sc.close();
    }

}
