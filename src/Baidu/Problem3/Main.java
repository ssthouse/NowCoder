package Baidu.Problem3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ssthouse on 16/8/25.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            //对每一组数据进行处理  输出一行结果(平均等待时间)
            double curResult = 0;
            ArrayList<Bean> beanList = new ArrayList<>();
            int taskNum = scanner.nextInt();
            for (int i = 0; i < taskNum; i++) {
                beanList.add(new Bean(scanner.nextInt(), scanner.nextInt()));
            }
            double curTime = 0;
            //对于index进行排序
            Collections.sort(beanList, new Comparator<Bean>() {
                @Override
                public int compare(Bean o1, Bean o2) {
                    if (o1.startIndex != o2.startIndex) {
                        return o1.startIndex - o2.startIndex;
                    }else{
                        return o1.length - o2.length;
                    }

                }

            });
            //遍历直到整个List处理结束
            for (int i = 0; i < beanList.size(); i++) {
                if (i == 0) {
                    curTime += beanList.get(0).startIndex + beanList.get(0).length;
                    continue;
                }
                //之后每一个需要判断等待时间
                double offsetTime = curTime - beanList.get(i).startIndex;
                if (offsetTime > 0) {
                    curResult += offsetTime;
                    curTime += (beanList.get(i).length);
                }else {
                    curTime = beanList.get(i).startIndex + beanList.get(i).length;
                }
            }
            System.out.println(String.format("%.4f", curResult/taskNum));
        }
        scanner.close();
    }
}

class Bean {
    public int startIndex;
    public int length;

    public Bean(int startIndex, int length) {
        this.startIndex = startIndex;
        this.length = length;
    }
}
