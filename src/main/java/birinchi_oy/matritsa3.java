package Dars;

import java.util.Arrays;
import java.util.Scanner;

public class matritsa3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("enter arrays size: ");
        int[] arr = new int[input.nextInt()];
        for (int i=0;i<arr.length;i++) {
            System.out.printf("enter %d numb: ",i);
            arr[i] = input.nextInt();
        }
        System.out.printf("Enter n m: ");
        int n=input.nextInt(),m=input.nextInt();
        int[][] matrix = new int[n][m];
        int c=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                try {
                    matrix[i][j] = arr[c];
                    c++;
                }catch (Exception ex){
                    matrix[i][j] = 0;
                }

            }
        }
        for (int[] row:matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
