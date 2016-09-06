package PerfectWord.出专辑;

import java.util.Scanner;

/**
 * Created by ssthouse on 16/9/4.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int songNum = scanner.nextInt();
        int songLength = scanner.nextInt();
        int cdLength = scanner.nextInt();


        //计算每一个cd 可以装的歌的数量
        int songInCdNum = cdLength / (songLength + 1);
        if (cdLength % (songLength + 1) == songLength) {
            songInCdNum++;
        }
        if (songInCdNum % 13 == 0) {
            songInCdNum--;
        }

        //尽可能的装满每一个CD
        int cdNum = songNum/songInCdNum;
        int leftSongNum = songNum%songInCdNum;
        if (leftSongNum != 0) {
            cdNum++;
        }

        //如果放在一个cd里面  是13的倍数
        if (cdNum == 1 && songNum % 13 == 0) {
            cdNum++;
        }

        //如果最后一个是13  填上一个又有一个变成13
        if (leftSongNum % 13 == 0 && songInCdNum == 14) {
            cdNum++;
        }

        System.out.println(cdNum);
    }

}
