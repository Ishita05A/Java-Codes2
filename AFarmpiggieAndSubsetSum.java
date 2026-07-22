import java.util.Scanner;

public class AFarmpiggieAndSubsetSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int fst = 1;
            int sec = 2;
            for(int i = 0;i<n;i++){
                if(i%2 == 0){
                     System.out.print(sec+" ");
                     sec+=2;
                }
                else {
                    System.out.print(fst+" ");
                    fst+=2;
                }
            }
            System.out.println();
        }
        
    }
}