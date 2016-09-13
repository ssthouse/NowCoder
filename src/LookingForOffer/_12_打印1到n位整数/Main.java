package LookingForOffer._12_打印1到n位整数;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ssthouse on 16/9/11.
 */
public class Main {


    public void getResult(int n) {
        if (n <= 0) {
            return;
        }
        List<String> resultList = new ArrayList<>();
        //使用字符串拼接
        for (int i = 0; i < 10; i++) {
            char nextChar = (char) ('0' + i);
            dfs("" + nextChar, n, resultList);
        }
        System.out.println(resultList.size());
        for (String str : resultList) {
            printNum(str);
        }
    }


    private void dfs(String curStr, int length, List<String> resultList) {
        if (curStr.length() == length) {
            resultList.add(curStr);
            return;
        }
        for (int i = 0; i < 10; i++) {
            char nextChar = (char) ('0' + i);
            dfs(curStr + nextChar, length, resultList);
        }
    }

    private void printNum(String num) {
        int index = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                index = i;
                break;
            }
        }
        if (index == num.length()-1) {
            System.out.println(0);
        } else {
            System.out.println(num.substring(index));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Main main = new Main();
        main.getResult(num);
    }


}
