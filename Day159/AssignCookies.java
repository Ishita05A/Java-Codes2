package Day159;

import java.util.Scanner;

public class AssignCookies {
    static int assign_cookies(int[] st, int[] cookies){
        int count = 0;
        int i = 0;
        int j = 0;
        while(i<st.length && j<cookies.length){
            if(st[i]<=cookies[j]){
                i++;
                j++;
                count++;
            }
            else j++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter greed of student");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter no. of cookies");
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
