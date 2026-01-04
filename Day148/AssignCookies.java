package Day148;

import java.util.*;
import java.util.Scanner;

public class AssignCookies {
    static int assign_cookies(int[] g,int[] s){
        int m = g.length;
        int n = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0,r= 0;
        while(l<m && r<n){
            if(g[l] <= s[r]){
                l++;
            }
            r++;
        }
        return l;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements for greed");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter no. of elements for students");
        int m = sc.nextInt();
        System.out.println("Enter elements");
        int[] s = new int[m];
        for (int i = 0; i < m; i++) {
            s[i] = sc.nextInt();
        }
        System.out.println(assign_cookies(arr, s));
        sc.close();
    }
    
}
