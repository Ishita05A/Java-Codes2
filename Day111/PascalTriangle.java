package Day111;

import java.util.Scanner;

public class PascalTriangle {
    static void printRow(int r,int c){
        int res = 1;
        for(int i =0;i<c;i++){
            res= res*(r-i);
            res = res/(i+1);
        }
        System.out.print(res+" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows");
        int n = sc.nextInt();
        for(int i = 1;i<=n;i++){
            printRow(n-1, i-1);
        }
        
        sc.close();
    }
}
