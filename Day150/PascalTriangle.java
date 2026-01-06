package Day150;
import java.util.*;
import java.util.Scanner;

public class PascalTriangle {
    static int generate_rows(int r,int c){
        int res = 1;
        for(int i = 0;i<c;i++){
            res*=(r-i);
            res/=(i+1);
        }
        return res;
        
    }
    static List<List<Integer>> pascal_triangle(int r,int c){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1;i<=r;i++){
            List<Integer> a = new ArrayList<>();
            for(int j = 1; j<=i;j++){
                int res = generate_rows(i-1, j-1);
                a.add(res);
            }
            ans.add(a);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter no. of elements");
        // int n = sc.nextInt();
        // System.out.println("Enter elements ");
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        //     arr[i] = sc.nextInt();
        // }
        System.out.println(pascal_triangle(5, 5));
        sc.close();
    }
    
}
