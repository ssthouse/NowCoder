package PerfectWord.魔法权值;

import java.util.*;

/**
 * TODO:
 * not done yet
 * Created by ssthouse on 16/9/4.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int k = scanner.nextInt();

        List<String> strList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            strList.add(scanner.next());
        }
        List<String> allPermutationStr = new ArrayList<>();
        fullPermutation(allPermutationStr, strList, new StringBuilder());
        for (String str : allPermutationStr) {
            System.out.println(str);
        }
    }

    public static void fullPermutation(List<String> resultList, List<String> strList, StringBuilder curSb) {
        //弹出条件
        if (strList.size() == 0) {
            resultList.add(curSb.toString());
            return;
        }
        //将list中所有str  依次加入  进行递归
        for (int i = 0; i < strList.size(); i++) {
            String str = strList.get(i);
            curSb.append(str);
            strList.remove(i);
            fullPermutation(resultList, strList, curSb);
            //还原数据  节省内存
            strList.add(i, str);
            curSb.delete(curSb.length() - str.length(), curSb.length());
        }
    }

    public static int getWeight(String string) {
        int weight;
        String tempStr;
        for (int i = 0; i < string.length(); i++) {
//            tempStr = tempStCr.substring(1, tempStr.length());
        }

        List list = new ArrayList<>();
        Set set = new HashSet<>();
        return 1;
    }

}
