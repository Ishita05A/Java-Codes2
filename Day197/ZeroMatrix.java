package Day197;

public class ZeroMatrix {
     static void display(int[][] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void zeroMatrix(int[][] mat){

        int n = mat.length;
        int m = mat[0].length;
        int col1 = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 0){
                    if(i == 0) col1 = 0;
                    else mat[0][j] = 0;
                    mat[i][0] = 0;
                }
            }
        }
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                if(mat[i][0] == 0 || mat[0][j] == 0) mat[i][j] = 0;
            }
        }
        if(mat[0][0] == 0){
            for(int j = 0;j<m;j++) mat[0][j] = 0;
        }
        if(col1 == 0){
            for(int i = 0;i<n;i++) mat[i][0] = 0;
        } 
    }
    public static void main(String[] args) {
        
        int[][] mat = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        zeroMatrix(mat);
        display(mat);

    }
    
}
