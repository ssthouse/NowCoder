package company.WAP.Num2;

import java.util.*;

/**
 * present one room
 */
class Bean {
    int index;
    int value;
    boolean isUsed;

    public Bean(int index, int value, boolean isUsed) {
        this.index = index;
        this.value = value;
        this.isUsed = isUsed;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //get value input
        Map<Integer, Bean> beanMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            beanMap.put(i, new Bean(i, scanner.nextInt(), false));
        }
        //get connection state
        Map<Bean, List<Bean>> connectMap = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            Bean fist = beanMap.get(scanner.nextInt());
            Bean sec = beanMap.get(scanner.nextInt());
            if (connectMap.get(fist) == null) {
                List<Bean> tempList = new ArrayList<>();
                tempList.add(sec);
                connectMap.put(fist, tempList);
            } else {
                connectMap.get(fist).add(sec);
            }
            if (connectMap.get(sec) == null) {
                List<Bean> tempList = new ArrayList<>();
                tempList.add(fist);
                connectMap.put(sec, tempList);
            } else {
                connectMap.get(sec).add(fist);
            }
        }
        //find max m value room
        int result = 0;
        for (int i = 0; i < m; i++) {
            //find max bean
            Bean maxBean = beanMap.get(1);
            for (int index : beanMap.keySet()) {
                Bean tempBean = beanMap.get(index);
                if (getValue(tempBean, connectMap) > getValue(maxBean, connectMap)) {
                    maxBean = beanMap.get(index);
                }
            }
            //add the max value
            result += getValue(maxBean, connectMap);
            //delete max room -> clear surround room
            beanMap.remove(maxBean.index);
            maxBean.isUsed = true;
            for (Bean tempBean : connectMap.get(maxBean)) {
                tempBean.value = 0;
                tempBean.isUsed = true;
            }
        }
        System.out.println(result);
    }

    private static int getValue(Bean bean, Map<Bean, List<Bean>> connectMap) {
        int result = 0;
        if (!bean.isUsed) {
            result += bean.value;
        }
        for (Bean tempBean : connectMap.get(bean)) {
            if (!tempBean.isUsed)
                result += tempBean.value;
        }
        return result;
    }
}
