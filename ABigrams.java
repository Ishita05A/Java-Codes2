import java.util.Scanner;

public class ABigrams {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int k = sc.nextInt();
            int twos = 0;
            boolean flag = false;
            while(k-->0){
                int c = sc.nextInt();
                if(c > 2) flag = true;
                if(c == 2) twos++;
            }
            if(flag == true || twos>1) System.out.println("YES");
            else System.out.println("NO");
            
        }
        
    }
}