package NetEaseCC.Num2;

import java.util.*;

/**
 * Created by ssthouse on 16/9/19.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            strList.add(scanner.next());
        }
        //
        Set<String> resultSet = new HashSet<>();
        int result = 0;
        for (int i = 0; i < strList.size(); i++) {
            for (int j = 0; j < strList.size(); j++) {
                //对每一个i 的单词   对除了i以外的单词都要判断
                if(i==j){
                    continue;
                }
                //juge
                String curStr = strList.get(i)+strList.get(j);
                if (isCircle(curStr)) {
                    result++;
                    resultSet.add(curStr);
                }
            }
        }
        //out
        System.out.println(result);
    }


    public static boolean isCircle(String string) {
        int left = 0;
        int right = string.length()-1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
