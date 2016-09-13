package Baidu.Num2;

import java.util.*;

/**
 * Created by ssthouse on 16/9/13.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            set.clear();
            int peopleNum = scanner.nextInt();
            for (int j = 0; j < peopleNum; j++) {
                set.add(scanner.nextInt());
            }
            //remove
            for (int k = 0; k < peopleNum - 1; k++) {
                set.remove(scanner.nextInt());
            }
            for (Integer number : set) {
                System.out.println(number);
            }
        }
    }
}
