package Day138;

import java.util.Scanner;

public class BinaryToDecimal {
    static int binary_to_decimal(String str){
        int num = 0;
        int p2=1;
        for(int i = str.length()-1;i>=0;i--){
            char ch = str.charAt(i);
            if(ch == '1') num=num+p2;
            p2 = p2*2;
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1");
        String str1 = sc.nextLine();
        System.out.println(binary_to_decimal(str1));
        sc.close();
    }
    
}
