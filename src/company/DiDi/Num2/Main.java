package company.DiDi.Num2;

import java.util.Scanner;

/**
 * Created by ssthouse on 16/9/18.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int result = 0;
        int maxNum = 1000000000;
        int tempNum = num;
        while (tempNum != 0) {
            maxNum /= 10;
            tempNum /= 10;
        }
        int finalNum = 1;
        for (int i = 2; i <= num; i++) {
            int count = 0;
            int tempResult = finalNum * i;
            while ((tempResult % 10) == 0) {
                tempResult /= 10;
                count++;
            }
            //in case out of numbr size
            if (tempResult > maxNum)
                tempResult = tempResult % maxNum;
            finalNum = tempResult;
            result += count;
        }
        System.out.println(result);
    }
}
