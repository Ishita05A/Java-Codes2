
import java.util.Arrays;
import java.util.Scanner;

public class AAnotherPuzzleFromPapyrus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i = 0;i<n;i++){
                a[i] = sc.nextInt();
            }
            for(int i = 0;i<n;i++){
                b[i] = sc.nextInt();
            }
            boolean flag = true;
            int sum = 0;
            for(int i = 0;i<n;i++){
                if(b[i] > a[i]){
                    flag = false;
                    break;
                }
                else{
                    sum+=(a[i] - b[i]);
                }
            }
            Arrays.sort(a);
            Arrays.sort(b);
            boolean ok = true;
            int sum2 = c;
            for(int i = 0;i<n;i++){
                if(b[i] > a[i]){
                    ok = false;
                    break;
                }
                else{
                    sum2+=(a[i] - b[i]);
                }
            }
            if(ok == false && flag == false) System.out.println(-1);
            else if(ok && flag) System.out.println(Math.min(sum2, sum));
            else if(ok) System.out.println(sum2);
            else System.out.println(sum);

        }
    }
}