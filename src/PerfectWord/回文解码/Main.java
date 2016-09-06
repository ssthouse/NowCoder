package PerfectWord.回文解码;

import java.util.Scanner;

/**
 * Created by ssthouse on 16/9/4.
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String iniStr = scanner.next();
        int executeTime = scanner.nextInt();
        int executeBean[][] = new int[executeTime][2];
        for (int i = 0; i < executeTime; i++) {
            executeBean[i][0] = scanner.nextInt();
            executeBean[i][1] = scanner.nextInt();
        }

        //对每一个bean进行字符串操作
        for (int[] bean : executeBean) {
            iniStr = executeBean(iniStr, bean);
        }
        System.out.println(iniStr);
    }

    public static String executeBean(String srcStr, int[] bean){
        String tempStr = srcStr.substring(bean[0], bean[0]+bean[1]);
        tempStr = new StringBuilder(tempStr).reverse().toString();
        srcStr = srcStr.substring(0, bean[0]+bean[1])+tempStr+srcStr.substring(bean[0]+bean[1], srcStr.length());
        return srcStr;
    }

}
