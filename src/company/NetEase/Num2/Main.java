package company.NetEase.Num2;

import java.util.*;

/**
 * Created by ssthouse on 16/9/12.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            //min than 2
            if (num <= 2) {
                System.out.println((int) Math.pow(3, num));
                continue;
            }


            int pureNum = getAllResult(num);
            //System.out.println(allNum);
            System.out.println(pureNum);
            //System.out.println(result + "");
        }
    }

    public static int getAllResult(int n) {
        //System.out.println(n);
        int result = 0;
        Set<Character> charSet = new HashSet<>();
        if ((n / 2) >= 3) {
            if (n % 2 == 0) {
                List<String> listOne = getResult(n / 2);
                List<String> listTwo = getResult(n / 2);
                for (String strOne : listOne) {
                    for (String strTwo : listTwo) {
                        charSet.clear();
                        charSet.add(strOne.charAt(strOne.length() - 1));
                        charSet.add(strTwo.charAt(strTwo.length() - 1));
                        charSet.add(strTwo.charAt(0));
                        boolean fistOne = charSet.size() <= 2;
                        charSet.clear();
                        charSet.add(strOne.charAt(strOne.length() - 1));
                        charSet.add(strOne.charAt(strOne.length() - 2));
                        charSet.add(strTwo.charAt(0));
                        boolean fistTwo = charSet.size() <= 2;
                        if (fistOne && fistTwo) {
                            result++;
                        }
                    }
                }
                return result;
            } else {
                return getAllResult(n / 2) * getAllResult(n / 2 + 1);
            }
        }
        return getResult(n).size();
    }

    public static List<String> getResult(int n) {
        List<String> pureList = new ArrayList<>();
        dfs("", n, pureList);
        return pureList;
    }

    public static void dfs(String curStr, int length, List<String> pureList) {
        if (curStr.length() == length) {
            pureList.add(curStr);
            // System.out.println(curStr);
            return;
        }
        //
        Set<String> charSet = new HashSet<>();
        if (curStr.length() == 0 || curStr.length() == 1) {
            charSet.add("A");
            charSet.add("B");
            charSet.add("C");
        }
        for (int i = curStr.length() - 2; i >= 0 && i < curStr.length(); i++) {
            charSet.add(curStr.charAt(i) + "");
        }
        if (charSet.size() == 1) {
            charSet.add("A");
            charSet.add("B");
            charSet.add("C");
        }
//        将剩下的字符串继续拼接
        for (String str : charSet) {
            dfs(curStr + str, length, pureList);
        }
    }
}
