package Day89;

import java.util.Scanner;
import java.util.Stack;
//*+ab-cd  -> ((a+b)*(c-d))
public class prefixToInfix {
    static String convert(String str){
        Stack<String> st = new Stack<>();
        for(int i = str.length()-1;i>=0;i--){
                char ch = str.charAt(i);
                int ascii = (int)ch;
                if(ascii >=48 && ascii <=57){
                    st.push(ch+"");
                }
                else{
                    String v1 = st.pop();
                    String v2 = st.pop();
                    st.push("("+v1+ch+v2+")");
                }
        }
        return st.peek();

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Expression");
        String str = sc.nextLine();
        System.out.println(convert(str));
        sc.close();
    }
    
}
