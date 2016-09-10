package LookingForOffer._8_旋转数组的最小数字;

import LookingForOffer.Utils;

/**
 * Created by ssthouse on 16/9/10.
 */
public class Main {

    public int getMinNum(int[] array) {
        if (array == null) {
            return 0;
        }
        //类似于二分查找
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right) >> 1;


        //对于特殊条件的判断
        if (array[left] < array[right]) {
            return array[left];
        }

        //如果没法使用二分查找..
        if (array[left] == array[mid] && array[right] == array[mid]) {
            int result = array[0];
            for (int i = 0; i < right; i++) {
                if(array[i] < result)
                    result = array[i];
            }
            return result;
        }

        while (right - left > 1) {
            mid = (left + right) >> 1;
            if (array[mid] <= array[right]) {
                right = mid;
            } else if (array[mid] >= array[left]) {
                left = mid;
            }
        }
        return array[right];
    }


    public static void main(String[] args) {
        Main main = new Main();
        int result = main.getMinNum(new int[]{3, 4, 5, 6, 7, 1, 2});
        int result1 = main.getMinNum(new int[]{1, 0, 1, 1, 1});
        int result2 = main.getMinNum(new int[]{1, 1, 1, 0, 1});
        Utils.log(result);
        Utils.log(result1);
        Utils.log(result2);
    }
}
