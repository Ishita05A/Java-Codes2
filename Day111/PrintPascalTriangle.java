package Day111;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintPascalTriangle {
    static ArrayList<Integer> generateRow(int row){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        int res = 1;
        for(int col = 1;col<row;col++){
            res = res*(row-col);
            res = res / (col);
            a.add(res);
        }
        return a;
    }
    static void  printPascalTriangle(int row){
       
        for(int i = 1;i<=row;i++){
            ArrayList<Integer> a = generateRow(i);
            System.out.println(a);
        }
       
       
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows");
        int row = sc.nextInt();
         printPascalTriangle(row);
         
         sc.close();

    }
    
}
