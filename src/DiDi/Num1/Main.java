package DiDi.Num1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ssthouse on 16/9/18.
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int life = scanner.nextInt();
        //get the matrix
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        //dfs
        List<String> tempList = new ArrayList<>();
        tempList.add("00");
        dfs(tempList, life, matrix, 0, 0);
        //out
        //case: no result
        if (resultList == null) {
            System.out.println("Can not escape!");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String str : resultList) {
            sb.append("[" + str.charAt(0) + "," + str.charAt(1) + "],");
        }
        String result = sb.toString().substring(0, sb.length() - 1);
        System.out.println(result);
    }

    //保存最后的路径list  "00"  "01"  这样
    private static List<String> resultList;
    private static int resultLife = Integer.MIN_VALUE;

    public static void dfs(List<String> curResult, int curLife, int[][] matrix, int curRow, int curCol) {
        //退出条件  到达出口
        if (curRow == 0 && curCol == matrix[0].length - 1 || curLife < resultLife) {
            if (curLife > resultLife) {
                resultLife = curLife;
                resultList = curResult;
            }
            return;
        }

        //右
        if (curCol + 1 <= matrix[0].length - 1 && curLife - 1 >= 0 && matrix[curRow][curCol + 1] == 1) {
            matrix[curRow][curCol + 1] = 0;
            List<String> tempResult = new ArrayList<>(curResult);
            tempResult.add(curRow + "" + (curCol + 1));
            dfs(tempResult, curLife - 1, matrix, curRow, curCol + 1);
        }
        //上  没有超出上面   生命没有小于0
        if (curRow - 1 >= 0 && curLife - 3 >= 0 && matrix[curRow - 1][curCol] == 1) {
            matrix[curRow - 1][curCol] = 0;
            List<String> tempResult = new ArrayList<>(curResult);
            tempResult.add((curRow - 1) + "" + curCol);
            dfs(tempResult, curLife - 3, matrix, curRow - 1, curCol);
        }
        //下
        if (curRow + 1 <= matrix.length - 1 && curLife >= 0 && matrix[curRow + 1][curCol] == 1) {
            matrix[curRow + 1][curCol] = 0;
            List<String> tempResult = new ArrayList<>(curResult);
            tempResult.add((curRow + 1) + "" + curCol);
            dfs(tempResult, curLife, matrix, curRow + 1, curCol);
        }
        //左
        if (curCol - 1 >= 0 && curLife - 1 >= 0 && matrix[curRow][curCol - 1] == 1) {
            matrix[curRow][curCol - 1] = 0;
            List<String> tempResult = new ArrayList<>(curResult);
            tempResult.add(curRow + "" + (curCol - 1));
            dfs(tempResult, curLife - 1, matrix, curRow, curCol - 1);
        }

    }
}
