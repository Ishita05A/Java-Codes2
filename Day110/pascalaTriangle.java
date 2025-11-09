package Day110;

import java.util.Scanner;

public class pascalaTriangle {
    static long findIndex(int r,int c){
        long ans = 1;
        for(int i = 0;i<c;i++){
            ans = ans *(r-i);
            ans = ans/(i+1);
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows");
        int n = sc.nextInt();
        System.out.println("Enter columns");
        int m = sc.nextInt();
        System.out.println(findIndex(n, m));
        sc.close();
    }
    
}
