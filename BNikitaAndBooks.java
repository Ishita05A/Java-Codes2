import java.util.Scanner;

public class BNikitaAndBooks{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            long[] a = new long[n];
            for(int i =0;i<n;i++){
                a[i] = sc.nextLong();
            }
            long left = 0;
            boolean flag = true;
            for(int i = 0;i<n;i++){
                if(a[i] > i+1){
                    left+=(a[i]-(i+1));
                }
                else if(a[i] < i+1){
                    left-=((i+1)-a[i]);
                }
                if(left < 0){
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}