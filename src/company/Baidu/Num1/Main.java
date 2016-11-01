package company.Baidu.Num1;

import java.util.Scanner;

/**
 * Created by ssthouse on 16/9/13.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            String strArray[] = new String[7];
            scanner.nextLine();
            for (int j = 0; j < 7; j++) {
                strArray[j] = scanner.nextLine();
            }
            for (String str : strArray) {
               System.out.println(str);
            }
            func(i + 1, strArray);

        }
    }

    public static void func(int callNum, String[] strArray) {
        int index = 0;
//        System.out.println(strArray[1].length()+"*****************");
        for (int i = 0; i < strArray[0].length(); i++) {
            if (strArray[0].charAt(i) == ' '
                    && strArray[1].charAt(i) == ' '
                    && strArray[2].charAt(i) == '*'
                    && strArray[3].charAt(i) == ' '
                    && strArray[4].charAt(i) == '*') {
                index = i;
                break;
            }
        }
//        System.out.println(index+"*****************");
        int fistNum = getNum(strArray, index - 7, index - 2);
        int secNum = getNum(strArray, index - 14, index - 9);
        int thirdNum = getNum(strArray, index + 2, index + 7);
        int forthNum = getNum(strArray, index + 9, index + 14);

        System.out.println("Case #" + callNum + ": " + fistNum + secNum + ":" + thirdNum + forthNum);
    }

    public static int getNum(String[] strArray, int leftIndex, int rightIndex) {
        int count = 0;
        for (int i = leftIndex; i <= rightIndex; i++) {
            for (int j = 0; j < 7; j++) {
                if (strArray[j].charAt(i) == '*') {
                    count++;
                }
            }
        }
        switch (count) {
            case 7:
//                System.out.println(7+"*********"+leftIndex+":"+rightIndex);
                return 1;
            case 18:
                return 4;
            case 12:
                return 7;
            case 26:
                return 8;
            case 22: {
                if (strArray[3].charAt(leftIndex + 1) == ' ') {
                    return 0;
                }
                if (strArray[1].charAt(leftIndex) == ' ' && strArray[2].charAt(leftIndex) == ' ') {
                    if (strArray[4].charAt(leftIndex) == '*') {
                        return 3;
                    } else {
                        return 2;
                    }
                } else {
                    if (strArray[5].charAt(leftIndex) == ' ') {
                        return 5;
                    } else {
                        return 6;
                    }
                }
            }
            case 24: {
                if (strArray[1].charAt(rightIndex) == ' ') {
                    return 6;
                } else {
                    return 9;
                }
            }
        }
        return 0;
    }
}




















