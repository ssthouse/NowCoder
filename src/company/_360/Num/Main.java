package company._360.Num;

import java.util.Scanner;

/**
 * Created by ssthouse on 16/9/20.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //input
            boolean matrix[][] = new boolean[3][3];
            for (int i = 0; i < 3; i++) {
                String str = scanner.nextLine();
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = str.charAt(j) == 'X';
                }
            }
            //juge 1~5
            boolean result = true;
            if (matrix[0][0] != matrix[2][2])
                result = false;
            if(matrix[0][1] != matrix[2][1])
                result = false;
            if(matrix[0][2] != matrix[2][0])
                result = false;
            if(matrix[1][0] != matrix[1][2])
                result = false;
            System.out.println(result? "YES" : "NO");
        }
    }
}
