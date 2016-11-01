package company.JDmockExam.Test1;

import java.util.Scanner;

/**
 * Created by ssthouse on 16/9/2.
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = m; i < n; i++) {
                int fistNum = i%10;
                int secNum = i/10%10;
                int thirNum = i/100%10;
                if (i == Math.pow(fistNum, 3) + Math.pow(secNum, 3) + Math.pow(thirNum, 3)) {
                    sb.append(i+" ");
                }
            }
            //拼接输出string
            String result = "";
            if (sb.toString().length() > 0) {
                result = sb.toString().substring(0, sb.toString().length() - 1);
            }else {
                result = "no";
            }
            System.out.println(result);
        }
    }
}
