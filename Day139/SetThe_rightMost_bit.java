package Day139;

import java.util.Scanner;

public class SetThe_rightMost_bit {
    static int set_rightMostBit(int n){
        return n | (1<<0);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println(set_rightMostBit(n));
        sc.close();
    }
    
}
