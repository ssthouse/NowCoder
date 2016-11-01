package company.XiaoMi.Num1;

import java.util.*;

/**
 * Created by ssthouse on 2016/9/23.
 */
public class Main {


    private static int result = Integer.MIN_VALUE;

    static class Node {
        int value;
        List<Node> childList;

        public Node(int value) {
            this.value = value;
            this.childList = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodeNum = scanner.nextInt();
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < nodeNum; i++) {
            nodeList.add(new Node(0));
        }
        result = 0;
        //构建二叉树
        for (int i = 0; i < nodeNum - 1; i++) {
            int fatherIndex = scanner.nextInt();
            int childIndex = scanner.nextInt();
            nodeList.get(fatherIndex).childList.add(nodeList.get(childIndex));
        }
        //从头结点  深度遍历
        for(Node node : nodeList) {
            dfs(node, 1);
        }
        //out
        System.out.println(result);
    }

    public static void dfs(Node curNode, int curResult) {
        if (curNode.childList.size() == 0) {
            if (curResult > result) {
                result = curResult;
            }
            return;
        }
        for (Node node : curNode.childList) {
            dfs(node, curResult + 1);
        }
    }
}
