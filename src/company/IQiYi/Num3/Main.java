package company.IQiYi.Num3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int fist = 1;
        int sec = 2;
        int third = 4;

        if (num == 1) {
            System.out.println(fist);
            return;
        } else if (num == 2) {
            System.out.println(sec);
            return;
        } else if (num == 3) {
            System.out.println(third);
            return;
        }

        //calc
        int result = 0;
        for (int i = 3; i < num; i++) {
            result = fist + sec + third;
            fist = sec;
            sec = third;
            third = result;
        }
        System.out.println(result);
    }
}
