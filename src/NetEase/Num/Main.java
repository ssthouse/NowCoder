package NetEase.Num;

import java.util.Scanner;

/**
 * Created by ssthouse on 16/9/12.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int revNum1 = rev(num1);
        int revNum2 = rev(num2);
        int result = rev(revNum1 + revNum2);
        System.out.println(result);
    }

    public static int rev(int num) {
        String revNumStr = new StringBuffer(num + "").reverse().toString();
        return Integer.parseInt(revNumStr);
    }
}
