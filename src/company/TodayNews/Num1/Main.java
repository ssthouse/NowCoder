package company.TodayNews.Num1;

import java.util.*;

/**
 * Created by ssthouse on 16/9/21.
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] numList = new int[n];
        for (int i = 0; i < n; i++) {
            numList[i] = (scanner.nextInt());
        }
        //add all possible int

        //get result
        int result = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                numSet.add(numList[i] ^ numList[j]);
            }
        }
        for (int i : numSet) {
            if (i > m) {
                result++;
            }
        }
        System.out.println(result);
    }
}
