package company.WAP.Try;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ssthouse on 21/10/2016.
 */
public class FindKinN {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> resultList = new FindKinN().getResult(nums, 2);
        for (List<Integer> beanList : resultList) {
            System.out.println(Arrays.toString(beanList.toArray()));
        }
    }

    private int k;

    public List<List<Integer>> getResult(int[] nums, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        this.k = k;
        dfs(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    public void dfs(List<List<Integer>> resultList, List<Integer> curList, int[] nums, int index) {
        if (curList.size() == k) {
            resultList.add(curList);
            return;
        }
        if (index == nums.length - 1)
            return;
        List<Integer> tempList = new ArrayList<>(curList);
        tempList.add(nums[index]);
        dfs(resultList, tempList, nums, index + 1);
        dfs(resultList, curList, nums, index + 1);
    }
}
