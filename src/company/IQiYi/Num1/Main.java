package company.IQiYi.Num1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ssthouse on 2016/9/27.
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] array = str.toCharArray();
        //排序
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        //尽可能小的先放进去
        List<Character> charList = new ArrayList<>();
        for (char c : array) {
            charList.add(c);
        }
        //out
        printAll(charList, new StringBuilder());
    }

    public static void printAll(List<Character> charList, StringBuilder sb) {
        if (charList.size() == 0) {
            System.out.println(sb.toString());
            return;
        }
        int size = charList.size();
        for (int i = 0; i < size; i++) {
            List<Character> tempList = new ArrayList<>(charList);
            tempList.remove(i);
            printAll(tempList, new StringBuilder(sb.toString() + charList.get(i)));
        }
    }
}
