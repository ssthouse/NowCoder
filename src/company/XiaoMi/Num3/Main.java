package company.XiaoMi.Num3;

import java.util.*;

/**
 * Created by ssthouse on 2016/9/23.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        //num set
        List<Set<Character>> numSetList = new ArrayList<>();
        String[] numStr = {"ZERO", "ONE", "TWO", "THREE", "FOUR",
                "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
        for (String str : numStr) {
            Set<Character> set = new HashSet<>();
            for (char c : str.toCharArray()) {
                set.add(c);
            }
            numSetList.add(set);
        }

        for (int i = 0; i < num; i++) {
            String str = scanner.next();
            List<Character> charList = new ArrayList<>();
            for (char c : str.toCharArray()) {
                charList.add(c);
            }

            //
            List<Integer> resultList = new ArrayList<>();
            dfs(numSetList, charList, resultList);
            StringBuilder sb = new StringBuilder();
            for (int number : resultList) {
                sb.append(number);
            }
            String result = sb.toString();
            result = getMinStr(result);
            System.out.println(result);
        }
    }

    public static String getMinStr(String string) {
        char[] array = string.toCharArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    char tempChar = array[i];
                    array[i] = array[j];
                    array[j] = tempChar;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void dfs(List<Set<Character>> numSetList, List<Character> charList, List<Integer> resultList) {
        if (charList.size() == 0) {
            return;
        }
        for (int i = 0; i < numSetList.size(); i++) {
            Set<Character> set = numSetList.get(i);
            boolean flag = true;
            for (char c : set) {
                if (!charList.contains(c))
                    flag = false;
            }
            if (flag == false)
                continue;
            //remove all
            for (char c : set) {
                charList.remove(new Character(c));
            }
            //add result
            resultList.add((i-8+10)%10);
        }
    }
}
