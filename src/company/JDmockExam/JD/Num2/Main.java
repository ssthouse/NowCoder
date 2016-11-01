package company.JDmockExam.JD.Num2;

import java.util.*;

/**
 * Created by ssthouse on 16/9/5.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int runNum = scanner.nextInt();
        for (int i = 0; i < runNum; i++) {
            int curNum = scanner.nextInt();
            int result = 0;
            for (int number = 1; number <= curNum; number++) {
                int tenNum = 0;
                int num = +number;
                while (num > 0) {
                    tenNum += num % 10;
                    num = num / 10;
                }
                tenNum += num % 10;

                int twoNum = 0;
                num = number;
                while (num > 0) {
                    twoNum += num % 2;
                    num = num / 2;
                }
                twoNum += num % 2;
                if (tenNum == twoNum) {
                    result++;
                }
            }

        }
    }
}
