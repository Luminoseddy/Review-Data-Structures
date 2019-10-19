package flipandinvertanimage;

public class FlipAndInvertAnImage {


    public static void main(String[] args) {
        
        /* [rows][columns]*/
        int[][] A = { { 1, 0, 0, 0 }, 
                      { 1, 1, 0, 1 }, 
                      { 0, 1, 0, 0 }, 
                      { 1, 1, 1, 1 } } ; 
        
     
       
    }
    
    public int[][] flipAndInvertImage(int[][] A) {
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }
    
    
}
