package Day137;

import java.util.Scanner;

public class largestOddNumber {
    static String find_largest_odd(String str){
        while(str.charAt(0) -'0' == 0 ) str = str.substring(1);
        for(int i = str.length()-1;i>=0;i--){
            char ch = str.charAt(i);
            if((ch-'0')%2 !=0){
                return str.substring(0, i+1);
            }
        }
        return "";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String str = sc.nextLine();
        System.out.println(find_largest_odd(str));
        sc.close();
    }
    
}
