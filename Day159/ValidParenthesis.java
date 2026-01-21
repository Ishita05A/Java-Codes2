package Day159;
import java.util.Scanner;

public class ValidParenthesis {
    static boolean isValidParenthesis_optimized(String str){
        int min = 0;
        int max = 0;
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
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
            if(max<min) return false;
        }
        return min == 0;
    }
    static boolean helper(String str,int count, int idx){
        if(count<0) return false;
        if(idx == str.length()){
            if(count == 0) return true;
            else return false;
        }
        if(str.charAt(idx) == ')'){
            return helper(str, count-1, idx+1);
        }
        else if(str.charAt(idx) == '('){
            return helper(str, count+1, idx+1);
        }
        else return  helper(str, count+1, idx+1) || helper(str, count-1, idx+1) || helper(str, count, idx+1);
    }
    static boolean isValidParenthesis(String str){
        int count = 0;
        return helper(str, count, 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Parenthesis");
        String str = sc.nextLine();
        System.out.println(isValidParenthesis(str));
        System.out.println(isValidParenthesis_optimized(str));
        sc.close();

    }
    
}
