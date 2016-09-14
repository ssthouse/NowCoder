package LookingForOffer._14_调整数组顺序使奇数位于偶数之前;

import java.util.Arrays;

/**
 * Created by ssthouse on 16/9/14.
 */
public class Main {

    /**
     * 基本思路:
     * 左右指针移动, 当左边为奇数, 右边为偶数  交换, 继续移动
     * @param srcArray
     * @return
     */
    public int[] getResult(int[] srcArray) {
        int leftIndex = 0;
        int rightIndex = srcArray.length-1;
        while (leftIndex < rightIndex) {
            while (srcArray[leftIndex] % 2 == 1) {
                leftIndex++;
            }
            while(srcArray[rightIndex] %2 == 0){
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                swap(srcArray, leftIndex, rightIndex);
            }
        }
        return srcArray;
    }

    public void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }


    public static void main(String[] args) {
        Main main = new Main();
        int[] srcArray = new int[]{2, 4, 6, 8, 10, 1, 3, 5, 7, 9};
        int[] resultArray = main.getResult(srcArray);
        System.out.println(Arrays.toString(resultArray));
    }
}
