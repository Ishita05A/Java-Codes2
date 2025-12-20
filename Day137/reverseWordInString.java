package Day137;

import java.util.Scanner;

public class reverseWordInString {
    static String reverseWord(String str){
        StringBuilder ans = new StringBuilder("");
        StringBuilder s = new StringBuilder("");
        for(int i = str.length()-1;i>=0;i--){
            s = new StringBuilder("");
            while (i>=0 && str.charAt(i) != ' ') {
                s.append(str.charAt(i));
                i--;
            }
            if(i != 0) ans.append(s.reverse()+" ");
        }
        ans.append(s.reverse());

        
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String str = sc.nextLine();
        System.out.println(reverseWord(str));
        sc.close();
    }
    
}
