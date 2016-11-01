package company.QuNar.Num2;

import java.util.Scanner;

/**
 * Created by ssthouse on 2016/9/27.
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int curNum = scanner.nextInt();
            System.out.println(isSatisfied(curNum));
        }
    }

    public static boolean isSatisfied(int curNum) {
        while (curNum != 1) {
            if (curNum % 2 != 0 && curNum!= 2) {
                return false;
            } else {
                curNum /= 2;
            }
        }
        return true;
    }

}
