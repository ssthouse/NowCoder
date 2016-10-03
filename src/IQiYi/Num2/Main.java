package IQiYi.Num2;

import java.util.Scanner;

/**
 * Created by ssthouse on 2016/9/27.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (num < 1 || num > 30) {
                System.out.println("error");
                continue;
            }
            //calc
            StringBuilder sb = new StringBuilder("1 1 ");
            int fistTwoResult[] = {1, 1};
            if (num <= 2) {
                System.out.println(fistTwoResult[num]);
                continue;
            }
            //calc result
            int fistNum = 1;
            int secNum = 1;
            for (int i = 2; i < num; i++) {
                int tempResult = fistNum + secNum;
                sb.append(tempResult+" ");
                fistNum = secNum;
                secNum = tempResult;
            }
            String result = sb.toString().substring(0, sb.toString().length() - 1);
            System.out.println(result);
        }
    }
}
