import java.util.*;
public class ARiptide {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int[] a = new int[3];
            for(int i = 0;i<3;i++){
                a[i] = sc.nextInt();
            }
            if(a[0]== a[1] || a[1] == a[2] || a[2] == a[0]){
                System.out.println(0);
                continue;
            }
            Arrays.sort(a);
            System.out.println(Math.min(a[1]-a[0], a[2]-a[1]));
        }
    }
}