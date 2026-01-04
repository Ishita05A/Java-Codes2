package Day148;

import java.util.Scanner;

public class ValidParenthesis {
    static boolean isValidParenthesis(String s,int idx,int cnt){
        if(cnt<0) return false;
        if(idx == s.length()){
            if(cnt == 0)return true;
            else return false;
        }
        if(s.charAt(idx) == '(') return isValidParenthesis(s, idx+1, cnt+1);
        else if(s.charAt(idx) == ')') return isValidParenthesis(s, idx+1, cnt-1);
        else return isValidParenthesis(s, idx+1, cnt+1) || isValidParenthesis(s, idx+1, cnt-1) || isValidParenthesis(s, idx+1, cnt);
    }
    static boolean isValidParenthesis_optimized(String s){
        int min = 0;
        int max = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                min++;
                max++;
            }
            else if(ch == ')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(min<0) min = 0;
            if(max<0) return false;
        }
        return min==0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1");
        String s = sc.nextLine();
        System.out.println(isValidParenthesis(s,0, 0));
        System.out.println(isValidParenthesis_optimized(s));
        sc.close();
    }
    
}
