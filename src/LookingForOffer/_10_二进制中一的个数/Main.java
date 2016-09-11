package LookingForOffer._10_二进制中一的个数;

import LookingForOffer.Utils;

/**
 * Created by ssthouse on 16/9/11.
 */
public class Main {


    public int getResult(int num) {
        int flag = 1;
        int result = 0;
        while (flag != 0) {
            if ((num & flag) != 0) {
                result++;
            }
            flag <<= 1;
        }
        return result;
    }


    public int getResult2(int num) {
        int result = 0;
        if (num < 0) {
            result++;
            num = -num;
        }
        //循环右移  和1相与
        while (num > 0) {
            if ((num & 1) != 0) {
                result++;
            }
            num >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int result1 = main.getResult(10);
        int result2 = main.getResult2(10);
        Utils.log(result1);
        Utils.log(result2);
    }


}
