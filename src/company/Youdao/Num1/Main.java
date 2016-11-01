package company.Youdao.Num1;

import java.util.*;

/**
 * Created by ssthouse on 16/9/22.
 */
public class Main {


    private int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupNum = scanner.nextInt();
        int conNum = scanner.nextInt();
        //init data
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < groupNum; i++) {
            list.add(null);
        }
        for (int i = 0; i < conNum; i++) {
            int fistNum = scanner.nextInt();
            int secNum = scanner.nextInt();
            List<Integer> conList = list.get(fistNum-1);
            if (conList == null) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(secNum);
                list.set(fistNum, tempList);
            }else {
                conList.add(secNum);
            }
        }
        //

    }

    public void dfs(List<List<Integer>> list, int removeCount, int index) {
        //弹出条件
        if (index == list.size() - 1 || removeCount >= result) {
            return;
        }
        //什么时候算  断开连接了
        for (int i = 0; i < list.size(); i++) {
            List<Integer> curList = list.get(i);
            if (curList == null) {
                continue;
            }
            //
        }
    }
}
