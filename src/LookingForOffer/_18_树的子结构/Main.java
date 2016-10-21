package LookingForOffer._18_树的子结构;

import LookingForOffer.BinaryNode;
import LookingForOffer.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ssthouse on 16/9/18.
 */
public class Main {


    private BinaryNode rootNode;
    private BinaryNode tryNode;

    public Main(BinaryNode rootNode, BinaryNode tryNode) {
        this.rootNode = rootNode;
        this.tryNode = tryNode;
    }

    public static void main(String[] args) {
        //创建一个rootTree  共三层
        BinaryNode rootNode = new BinaryNode(1, null, null);
        buildTree(rootNode, 3);
        //创建一个测试tree
        BinaryNode tryNOde = new BinaryNode(2, null, null);
        buildTree(tryNOde, 2);
//        Utils.printBinaryTreeByRow(rootNode);
//        Utils.printBinaryTreeByRow(tryNOde);

        Main main = new Main(rootNode, tryNOde);
        boolean result = main.getResult();
        Utils.log(result + "*********");
    }

    public boolean getResult() {
        //先找到rootTree所有和tryTree相同的节点
        int tryValue = tryNode.value;
        Queue<BinaryNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(rootNode);
        while (!nodeQueue.isEmpty()) {
            BinaryNode tempNode = nodeQueue.poll();
            if (tempNode.value == tryValue) {
                if (isSameTree(tempNode, tryNode)) {
                    return true;
                }
            }
            if (tempNode.leftNode != null) {
                nodeQueue.add(tempNode.leftNode);
            }
            if (tempNode.rightNode != null) {
                nodeQueue.add(tempNode.rightNode);
            }
        }
        return false;
    }

    /**
     * 判断两棵树是否全等
     *
     * @param fistNode
     * @param secNode
     * @return
     */
    public boolean isSameTree(BinaryNode fistNode, BinaryNode secNode) {
        //弹出条件
        if (fistNode == null && secNode == null) {
            return true;
        }
        if (fistNode == null && secNode != null) {
            return false;
        }
        if (fistNode != null && secNode == null) {
            return false;
        }
        if (fistNode.value != secNode.value) {
            return false;
        }
        return isSameTree(fistNode.leftNode, secNode.leftNode) && isSameTree(fistNode.rightNode, secNode.rightNode);
    }

    /**
     * 创建一棵树
     *
     * @param rootNode
     * @param level
     */
    private static void buildTree(BinaryNode rootNode, int level) {
        int nodeNum = (int) (Math.pow(2, level - 1) - 1);
        Queue<BinaryNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(rootNode);
        for (int i = 0; i < nodeNum; i++) {
            BinaryNode tempNode = nodeQueue.poll();
            tempNode.leftNode = new BinaryNode(tempNode.value * 2, null, null);
            tempNode.rightNode = new BinaryNode(tempNode.value * 2 + 1, null, null);
            nodeQueue.add(tempNode.leftNode);
            nodeQueue.add(tempNode.rightNode);
        }
    }
}
