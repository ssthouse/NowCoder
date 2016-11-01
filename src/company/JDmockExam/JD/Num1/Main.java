package company.JDmockExam.JD.Num1;

import java.util.Scanner;

/**
 * Created by ssthouse on 16/9/5.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int curNum = scanner.nextInt();
            //对从0到curNum-1的进制数进行累加
            int sum = 0;
            for (int bean = 2; bean <= curNum - 1; bean++) {
                int tempSum = 0;
                int tempNum = curNum;
                while (tempNum > 0) {
                    tempSum += tempNum % bean;
                    tempNum = tempNum / bean;
                }
                tempSum += tempNum % bean;
                sum += tempSum;
            }
            int dividerNum = curNum - 2;
            //约分
            int maxDivider = 1;
            for (int i = 1; i < curNum && i < dividerNum; i++) {
                if (dividerNum % i == 0 && sum % i == 0) {
                    maxDivider = i;
                }
            }
            String result = (sum/maxDivider) + "/"+ (dividerNum/maxDivider);
            System.out.println(result);
        }
    }
}
