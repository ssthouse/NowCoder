package company._360.Num2;

import java.util.*;

/**
 * Created by ssthouse on 16/9/20.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int curNum = scanner.nextInt();
            Set<Integer> set = new HashSet<>();
            dfs(1, curNum, set);
            System.out.println(set.size());
        }
    }

    public static void dfs(int curNum, int maxNum, Set<Integer> set) {
        if (curNum > maxNum) {
            return;
        }
        set.add(curNum);
        dfs(curNum * 10, maxNum, set);
        dfs(curNum * 10 + 1, maxNum, set);
    }
}
