package Baidu.Problem1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by ssthouse on 16/8/24.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            isSuccess = false;

            //对每一组数据进行处理
            int wordNum = scanner.nextInt();
            ArrayList<String> wordList = new ArrayList<>();
            while (wordNum-- > 0) {
                wordList.add(scanner.next());
            }
            //进行深度遍历
            dfs(null, wordList);
            System.out.println(isSuccess ? "YES" : "NO");
        }
    }

    private static boolean isSuccess = false;

    /**
     * 深度优先搜索  找到set为空为止
     */
    private static void dfs(String curStr, ArrayList<String> wordSet) {
        if (wordSet.size() == 0) {
            isSuccess = true;
            return;
        }

        //判断是否为第一个单词
        if (curStr == null) {
            for(String str : wordSet) {
                ArrayList<String> tempList = new ArrayList<>(wordSet);
                tempList.remove(str);
                dfs(str, tempList);
            }
            return;
        }

        char curEndChar = curStr.charAt(curStr.length() - 1);
        for(String str : wordSet) {
            if (str.indexOf(curEndChar) == 0) {
                ArrayList<String> tempList = new ArrayList<>(wordSet);
                tempList.remove(str);
                dfs(str, tempList);
            }
        }
    }
}
