package NetEaseCC.Num1;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by ssthouse on 16/9/19.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fistNum = scanner.nextInt();
        int secNum = scanner.nextInt();
        int maxSub = getMaxSub(fistNum, secNum);
        String minPlus = getMinPlus(maxSub, fistNum, secNum);
        System.out.println(maxSub + " " + minPlus);
//        getMinPlus(521212412, 1241014242);
    }

    public static int getMaxSub(int fistNum, int secNum) {
        int minNum = Math.min(fistNum, secNum);
        for (; minNum > 0; minNum--) {
            if (fistNum % minNum == 0 && secNum % minNum == 0) {
                return minNum;
            }
        }
        return 1;
    }

    public static String getMinPlus(int maxSub, int fistNum, int secNum) {

        if (fistNum + "".length() > 4 || secNum + "".length() > 4) {
            //big decimal
            BigDecimal num1 = new BigDecimal(fistNum/maxSub);
            BigDecimal num2 = new BigDecimal(secNum/maxSub);
            String result = num1.multiply(num2).toString();
            return result;
        }

        int maxNum = Math.max(fistNum, secNum);
        for (; ; maxNum++) {
            if (maxNum % fistNum == 0 && maxNum % secNum == 0) {
                return maxNum + "";
            }
        }
    }
}
