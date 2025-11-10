package Day111;

import java.util.Scanner;

public class PrintRowOfPascalTriangle {
    static void printRow(int r) {
        int res = 1;
        if(res == 1) System.out.print(1+" ");
        for (int i = 1; i < r; i++) {
            res = res * (r - i);
            res = res / i;
            System.out.print(res+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows");
        int n = sc.nextInt();
        
            printRow(n);
        
        sc.close();
    }
}
