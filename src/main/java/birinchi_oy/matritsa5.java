package Dars.birinchi_oy;
import java.util.Scanner;
import java.util.Vector;

public class matritsa5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter array size: ");
        int[][] matrix = new int[input.nextInt()][input.nextInt()];
        Vector vct = new Vector<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("Enter %d.%d numb: ",i,j);
                matrix[i][j] = input.nextInt();
            }
            
        }
    }
}
