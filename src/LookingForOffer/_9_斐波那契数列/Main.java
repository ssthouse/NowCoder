package LookingForOffer._9_斐波那契数列;

import LookingForOffer.Utils;

/**
 * Created by ssthouse on 16/9/10.
 */
public class Main {


    /***
     * 递归实现
     *
     * @param n
     * @return
     */
    public int recursiveSolution(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return recursiveSolution(n - 1) + recursiveSolution((n - 2));
    }


    /**
     * 类似于动态规划实现
     */
    public int getResult(int n) {
        int tempResult[] = new int[n+1];
        tempResult[0] = 0;
        tempResult[1] = 1;
        for (int i = 2; i <= n; i++) {
            tempResult[i] = tempResult[i - 1] + tempResult[i - 2];
        }
        return tempResult[n];
    }


    public static void main(String[] args) {
        Main main = new Main();
        int result = main.recursiveSolution(10);
        int result1 = main.getResult(10);
        Utils.log(result);
        Utils.log(result1);
    }

}
