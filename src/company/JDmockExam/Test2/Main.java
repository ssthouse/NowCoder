package company.JDmockExam.Test2;

import java.util.Scanner;

/**
 * Created by ssthouse on 16/9/2.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            double tempResult = n;
            double result = 0.0;
            for (int i = 0; i < m; i++) {
                result += tempResult;
                tempResult = Math.sqrt(tempResult);
            }
            System.out.println(String.format("%.2f",result));
        }
    }
}
