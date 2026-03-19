package Day198;

import java.util.Arrays;

public class LargestCommonPrefix {
    static String largestCommon(String[] str){
        Arrays.sort(str);
        String first = str[0];
        String last = str[str.length-1];
        int i = 0;
        StringBuilder ans = new StringBuilder();
        while(i<first.length() && i<last.length()){
            if(first.charAt(i) == last.charAt(i)){
                ans.append(first.charAt(i));
                i++;
            }
            else break;
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        System.out.println(largestCommon(str));
    }
    
}
