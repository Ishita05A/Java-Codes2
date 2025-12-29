package Day144;

import java.util.Scanner;

public class SubStringContainingAll3Character {
    static int countSubstring(String s){
        int[] hash = {-1,-1,-1};
        int cnt = 0;
        for(int i = 0;i<s.length();i++){
            hash[s.charAt(i)-'A'] = i;
            if(hash[0] != -1 && hash[1] != -1 && hash[2] != -1){
                cnt+=Math.min(hash[0], Math.min(hash[2], hash[1]))+1;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String s = sc.nextLine();
        System.out.println(countSubstring(s));
        sc.close();
    }
    
}
