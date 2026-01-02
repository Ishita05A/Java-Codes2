package Day146;

import java.util.Scanner;

public class SubStringContainingAll3 {
    static int count_subString_brute(String s){
        int count = 0;
        
        for(int i = 0;i<s.length();i++){
            int[] hash = {-1,-1,-1};
            for(int j = i;j<s.length();j++){
                char ch = s.charAt(j);
                hash[ch-'a'] =1;
                if(hash[0] != -1 && hash[1] != -1 && hash[2] != -1) count++;
            }
        }
        return count;
    }
    static int count_substring_optimized(String s){
        int count = 0;
        
        int[] hash = {-1,-1,-1};
        for(int r = 0;r<s.length();r++){
            char ch = s.charAt(r);
            hash[ch-'a'] = r;
            if(hash[0] != -1 && hash[1] != -1 && hash[2] != -1){
                count+= (1+Math.min(hash[1],Math.min(hash[0], hash[2])));
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String s = sc.nextLine();
        System.out.println(count_subString_brute(s));
        System.out.println(count_substring_optimized(s));
        sc.close();
    }

    
}
