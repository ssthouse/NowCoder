package LookingForOffer._11_实现数字的整数次方;

import LookingForOffer.Utils;

/**
 * Created by ssthouse on 16/9/11.
 */
public class Main {


    public double getResult1(double num, int exponent) {
        if (exponent == 0 || num == 0) {
            return 1;
        }
        int expose = Math.abs(exponent);
        double result = power(num, expose);
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    public double power(double base, int expose) {
        if (expose == 0) {
            return base;
        }
        if (expose == 1) {
            return base;
        }
        double result = power(base, expose >> 1);
        result *= result;
        if (expose % 2 != 0) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args){
        Main main = new Main();
        double result = main.getResult1(3, 10);
        double result1 = main.getResult1(3, 3);
        Utils.log(result);
        Utils.log(result1);

    }
}
