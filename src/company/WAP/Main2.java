package company.WAP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * 【输入】：
 * 5 1
 * 1 2 3 4 5
 * 2 1
 * 3 2
 * 4 2
 * 5 3
 * 第一行为N M 接下来有N行；M为路由器的个数
 * 第二行为各个房间含有WiFi的满意度
 * 之后的N-1行表示房间i,j之间存在门
 * 【输出】：
 * 10
 * 输出为最大满意度
 *
 * @author hp
 */
public class Main2 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String[] firstLine = in.nextLine().split(" ");
        String[] twoLine = in.nextLine().split(" ");
        int[] first = new int[firstLine.length];
        int[] two = new int[twoLine.length];
        for (int i = 0; i < firstLine.length; i++) {
            first[i] = Integer.valueOf(firstLine[i]).intValue();
        }
        for (int i = 0; i < twoLine.length; i++) {
            two[i] = Integer.valueOf(twoLine[i]).intValue();
        }
        int N = first[0];
        int M = first[1];

        Map<Integer, HashSet> map = new HashMap<>();

        for (int i = 0; i < N - 1; i++) {
            //HashSet<Integer> allSet = new HashSet<Integer>();
            String s = in.nextLine();
            for (int j = 1; j <= N; j++) {
                HashSet<Integer> allSet = new HashSet<Integer>();
                if (!map.containsKey(j)) {
                    allSet.add(j);
                    map.put(j, allSet);
                }
                if (s.contains(j + "")) {
                    String[] ss = s.split(" ");
                    allSet = map.get(j);
                    allSet.add(Integer.valueOf(ss[0]));
                    allSet.add(Integer.valueOf(ss[1]));
                    map.put(j, allSet);
                }

            }
        }

        //此时map中存有所有房间的门数据
        //two数组存有各个房间的满意值
        int[] result = new int[N];
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < result.length; i++) {
            set = map.get(i + 1);
            int temp = 0;
            for (Integer integer : set) {
                temp += two[integer - 1];
            }
            result[i] = temp;
        }

        //对result排序，求和前M个数据即为所求

        result = selectSort(result);

        int max = 0;
        for (int i = 0; i < M; i++) {
            max += result[N - 1 - i];
        }

        System.out.println(max);

    }

    public static int[] selectSort(int[] a) {
        int position = 0, temp = 0;

        for (int i = 0; i < a.length; i++) {
            temp = a[i];
            position = i;//当前最小元素下标
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < temp) {
                    temp = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = temp;
        }

        return a;
    }

}
