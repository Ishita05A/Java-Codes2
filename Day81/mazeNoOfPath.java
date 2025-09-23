import java.util.Scanner;

public class mazeNoOfPath {
    static int maze(int sr,int sc,int er,int ec){
        if(sr>er || sc > ec) return 0;
        if(sr == er && er == sc) return 1; 
        int rightWays = maze( sr+1, sc, er, ec);
        int downWays = maze( sr, sc+1, er, ec);
        return rightWays + downWays;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       System.out.println("Enter rows");
       int r = sc.nextInt();
       System.out.println("Enter columns");
       int c = sc.nextInt();
        System.out.println(maze( 1, 1  , r, c));
        sc.close();
    }
    
}
