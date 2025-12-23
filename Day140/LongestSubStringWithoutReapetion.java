package Day140;
import java.util.*;
import java.util.Scanner;

public class LongestSubStringWithoutReapetion {
    static int longestSubArray_optimized(String s){
        int n = s.length();
        HashMap<Character,Integer> mp = new HashMap<>();
        int l = 0;
        int maxLen = 0;
        for(int r = 0;r<n;r++){
            if(!mp.containsKey(s.charAt(r))){
                mp.put(s.charAt(r), r);
            }
            else{
                if(mp.get(s.charAt(r))>l) l = mp.get(s.charAt(r))+1;
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
    static int longestSubArray(String str){
        int n = str.length();
        int maxLen=0;
        for(int i = 0;i<str.length();i++){
            int[] hash = new int[256];
            Arrays.fill(hash,0);
            for(int j = i;j<n;j++){
                if(hash[str.charAt(j)] == 1) break;
                hash[str.charAt(j)] = 1;
                maxLen = Math.max(maxLen, j-i+1);
            }
            
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String str = sc.nextLine();
        System.out.println(longestSubArray(str));
        System.out.println(longestSubArray_optimized(str));
        sc.close();
    }
    
}
