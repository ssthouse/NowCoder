package company.QuNar.Num3;

import java.util.*;

/**
 * Created by ssthouse on 2016/9/27.
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> priceList = new ArrayList<>();
        while (scanner.hasNext()) {
            priceList.add(scanner.nextInt());
        }
        //
        int money = priceList.remove(priceList.size() - 1);
        //删除不必要的数据
        int size = priceList.size();
        for (int i = 0; i < size; i++) {
            if(priceList.get(i) > money){
                priceList.remove(i);
                size--;
                i--;
            }
        }
        //排序
        for (int i = 0; i < priceList.size(); i++) {
            for (int j = i; j < priceList.size(); j++) {
                if(priceList.get(i) > priceList.get(j)) {
                    int temp = priceList.get(i);
                    priceList.set(i, priceList.get(j));
                    priceList.set(j, temp);
                }
            }
        }

        //
        result = Integer.MAX_VALUE;
        dfs(money, 0, priceList);
        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }

    private static int result = Integer.MAX_VALUE;

    public static void dfs(int leftMoney, int curCount, List<Integer> priceList) {
        if (leftMoney == 0) {
            if (result > curCount) {
                result = curCount;
            }
            return;
        }
        if(curCount > result)
            return;
        //遍历剩下的可能
        for (int i : priceList) {
            if (i <= leftMoney) {
                dfs(leftMoney - i, curCount+1, priceList);
            }
        }
    }
}
