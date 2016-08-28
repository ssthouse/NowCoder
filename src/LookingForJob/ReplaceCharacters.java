package LookingForJob;

import java.util.Arrays;

/**
 * Created by ssthouse on 16/8/28.
 */
public class ReplaceCharacters {

    private char[] srcStr;
    private String replaceStr;

    public ReplaceCharacters(char[] scrStr, String replaceStr) {
        this.srcStr = scrStr;
        this.replaceStr = replaceStr;
    }

    public String getResult() {
        //遍历一遍找到需要多大的数组
        int origiLength = 0;
        while(srcStr[origiLength] != 0)
            origiLength++;
        int spaceNum = 0;
        for (int i = 0; i < srcStr.length; i++) {
            if (srcStr[i] == ' ')
                spaceNum++;
        }
        //从str.length-1 + spaceNum*(3-1)位置开始  从后往前移动数据
        int srcStrIndex = origiLength - 1;
        int newIndex = origiLength - 1 + spaceNum * 2;
        for (int i = srcStrIndex; i >= 0; i--) {
            //如果是空格 添加三个字符
            if (srcStr[srcStrIndex] == ' ') {
                srcStrIndex--;
                srcStr[newIndex--] = '0';
                srcStr[newIndex--] = '1';
                srcStr[newIndex--] = '%';
            } else {
                srcStr[newIndex--] = srcStr[srcStrIndex--];
            }
        }
        return Arrays.toString(srcStr);
    }

    public static void main(String[] args) {
        //直接打出来会是   怎么个效果
        char[] charArray = new char[50];
        String srcStr = "I am a good student";
        for (int i = 0; i < srcStr.length(); i++) {
            charArray[i] = srcStr.charAt(i);
        }
        System.out.println(charArray);
        System.out.println(charArray[30]);


        String replaceStr = "%10";
        ReplaceCharacters test = new ReplaceCharacters(charArray, replaceStr);
        String result = test.getResult();
        System.out.println(result);
    }


}
