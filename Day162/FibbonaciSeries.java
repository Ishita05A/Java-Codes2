package Day162;

import java.util.Scanner;

public class FibbonaciSeries {
    static int  printFibonaciSeries(int n){
        if(n == 0 || n == 1) return n;
        return printFibonaciSeries(n-1) + printFibonaciSeries(n-2);

    }
    public static void main(String[] args) {
        System.out.println("Enter no. of elements");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            System.out.println(printFibonaciSeries(i));
        }
        sc.close();
    }
    
}
