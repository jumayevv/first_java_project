package Dars;

import java.util.Arrays;
import java.util.Scanner;

public class matritsa4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter matrix size: ");
        int s=input.nextInt();
        int[][] matrix = new int[s][s];
        int[][] matrix2 = new int[s][s];
        System.out.println("Enter 1nd matrix numbers ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("Enter %d.%d : ",i,j);
                matrix[i][j] = input.nextInt();
            }
        }
        System.out.println("Enter 2nd matrix numbers ");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                System.out.printf("Enter %d.%d : ",i,j);
                matrix2[i][j] = input.nextInt();
            }
        }
        int[][] result = new int[matrix2.length][matrix2.length * 2];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if(j < 3) {
                    result[i][j] = matrix[i][j];
                }else {
                    result[i][j] = matrix2[i][j-3];
                }
            }
        }
        for (int[] row:result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
