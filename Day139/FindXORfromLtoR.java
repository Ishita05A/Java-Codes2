package Day139;

public class FindXORfromLtoR {
    static int findXOR(int l,int r){
        int xor = 0;
        for(int i = l;i<=r;i++) xor^=i;
        return xor;
    }
    public static void main(String[] args) {
        
        System.out.println(findXOR(3, 5));
    }
    
}
