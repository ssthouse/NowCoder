package company.NetEaseCC.Num3;

import java.util.*;

/**
 * Created by ssthouse on 16/9/19.
 */
public class Main {
    public static void main(String[] args) {
        //get data
        Scanner scanner = new Scanner(System.in);
//        BufferedReader br = new BufferedReader()
        int num = scanner.nextInt();
        List<Set<Integer>> groupList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int curNum = scanner.nextInt();
            Set<Integer> curGroup = new HashSet<>();
            for (int j = 0; j < curNum; j++) {
                curGroup.add(scanner.nextInt());
            }
            groupList.add(curGroup);
        }

        Set<Integer> resultSet = new HashSet<>();
        //judge 1  add all contains 1
        for (int i = 0; i < groupList.size(); i++) {
            Set<Integer> set = groupList.get(i);
            if (set.contains(1)) {
                resultSet.addAll(set);
                groupList.remove(set);
            }
        }
        //judge current
        Set<Integer> newAddSet = new HashSet<>(resultSet);
        while (true) {
            if (newAddSet.size() == 0) {
                break;
            }
            //update size
            Set<Integer> addSet = new HashSet<>();
            for (int i : newAddSet) {
                for (int j = 0; j < groupList.size(); j++) {
                    Set<Integer> set = groupList.get(j);
                    if (set.contains(i)) {
                        addSet.addAll(set);
                        groupList.remove(set);
                    }
                }
            }
            newAddSet = addSet;
            resultSet.addAll(addSet);
        }
        //out
//        for (int i : resultSet) {
//            System.out.println(i+"***");
//        }
        if (resultSet.contains(1)) {
            resultSet.remove(1);
        }
        System.out.println(resultSet.size());
    }
}
