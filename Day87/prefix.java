package Day87;
import java.util.Scanner;
import java.util.Stack;

public class prefix {
    // static String evaluate(String str){
    //     Stack<String> st = new Stack<>();
    //     Stack<Character> op = new Stack<>();
    //     for(int i = 0;i<str.length();i++){
    //         char ch = str.charAt(i);
    //         int ascii = (int)ch;
    //         if(ascii >=47 && ascii <= 58){
    //             st.push(ch+"");
    //         }
            
    //     }
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Expression");
        String str = sc.nextLine();
        System.out.println(evaluate(str));
        sc.close();
    }
    
}
