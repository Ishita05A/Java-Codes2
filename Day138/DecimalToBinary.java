package Day138;

import java.util.Scanner;

public class DecimalToBinary {
    static String convertToBase2(int n){
        StringBuilder s = new StringBuilder("");
        while(n != 0){
            if(n%2 == 0) s.append("0");
            else s.append("1");
            n/=2;
        }
        s.reverse();
        return s.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println(convertToBase2(n));
        sc.close();
    }
    
}
