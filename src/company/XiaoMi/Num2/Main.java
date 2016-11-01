package company.XiaoMi.Num2;

import java.util.Scanner;

/**
 * Created by ssthouse on 2016/9/23.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            //反转整个字符串
            str = reverse(str, 0, str.length() - 1);
            int lastSpaceIndex = -1;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    str = reverse(str, lastSpaceIndex + 1, i - 1);
                    //update
                    lastSpaceIndex = i;
                }
            }
            str = reverse(str, lastSpaceIndex + 1, str.length() - 1);
            System.out.println(str);
        }
    }

    public static String reverse(String str, int leftInde, int rightIndex) {
        char[] array = str.toCharArray();
        while (leftInde < rightIndex) {
            char tempChar = array[leftInde];
            array[leftInde] = array[rightIndex];
            array[rightIndex] = tempChar;
            //add
            leftInde++;
            rightIndex--;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(c);
        }
        return sb.toString();
    }
}
