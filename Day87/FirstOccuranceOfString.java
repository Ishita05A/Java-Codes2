package Day87;

import java.util.Scanner;

public class FirstOccuranceOfString {
    static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(m == 0) return -1;
        for(int i = 0; i<=n-m;i++){
            int j;
            for(j = 0;j<m;j++){
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
            }
            if(j == m) return i;
        }
        return -1;

        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st string");
        String str = sc.nextLine();
        System.out.println("Enter 2nd String");
        String gtr = sc.nextLine();
        System.out.println(strStr(str,gtr));
        sc.close();
    }
    
}
