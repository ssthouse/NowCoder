package company.Baidu.Problem2;

import java.util.*;

/**
 * Created by ssthouse on 16/8/24.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //对每一组数据进行处理
            int  curResult = 0;
            int size = scanner.nextInt();
            int nums = scanner.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < nums; i++) {
                int curNum = scanner.nextInt();
                if (!queue.contains(curNum)) {
                    queue.add(curNum);
                    if (queue.size() > size) {
                        queue.poll();
                    }
                    curResult++;
                }
            }
            System.out.println(curResult);
        }
    }

}
