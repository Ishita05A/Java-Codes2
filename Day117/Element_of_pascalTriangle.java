package Day117;

import java.util.Scanner;

public class Element_of_pascalTriangle {
    static int findElement(int r, int c){
        int res = 1;
        for(int i =0;i<c;i++){
            res*=(r-i);
            res/=(i+1);
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row");
        int r = sc.nextInt();
        System.out.println("Enter columns");
        int c = sc.nextInt();
        System.out.println(findElement(r-1 , c-1));
        sc.close();
    }
    
}
