package company.MeiTuan.Num1;

import java.util.Arrays;

/**
 * Created by ssthouse on 16/9/9.
 */
public class Main {


    public static void main(String[] args) {
        System.out.println("hahaha");
        String a = "";
        int b = 012;

        String[] array = {"c", "b", "a"};
        Arrays.sort(array);
        String[] newArray = Arrays.copyOf(array, array.length);
        for (String str : newArray) {
            System.out.println(str);
        }
    }

}
