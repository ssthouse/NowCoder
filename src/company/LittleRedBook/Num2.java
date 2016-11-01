package company.LittleRedBook;

import java.util.Scanner;

/**
 * Created by ssthouse on 30/10/2016.
 */
public class Num2 {

    private static final String abc = "abc";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        while (str.contains(abc)) {
            str = str.replace(abc, "");
        }
        System.out.println(str);
    }

}
