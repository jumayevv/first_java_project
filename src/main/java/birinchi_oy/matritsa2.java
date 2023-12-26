package Dars;

import java.util.Scanner;

public class matritsa2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter matrix size n m: ");
        int[][] matrix = new int[input.nextInt()][input.nextInt()];
        int targeti=0,targetj=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("Enter " + i + "." + j + ": ");
                matrix[i][j] = input.nextInt();
                if(matrix[i][j] < 0){
                    targeti=i;
                    targeti=j;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i == targeti || j == targetj){
                    continue;
                }else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
}
