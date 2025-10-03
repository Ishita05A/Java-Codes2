package Day90;

import java.util.Scanner;

public class ReverseWord {
    static String reverse_word(String str) {
        StringBuilder s = new StringBuilder(str);
        StringBuilder ans = new StringBuilder("");
        s = s.reverse();
       
        for (int i = 0;i < s.length();i++) {
             StringBuilder st = new StringBuilder("");
            while (i < s.length() && s.charAt(i) != ' ') {
                st.append(s.charAt(i));
                i++;
            }
            
            st.reverse();
            ans.append(st + " ");
            
        }
        return ans.toString();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Expression");
        String str = sc.nextLine();
        System.out.println(reverse_word(str));
        sc.close();
    }

}
