package LookingForOffer._6_重建二叉树;

import LookingForOffer.BinaryNode;
import LookingForOffer.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by ssthouse on 16/8/30.
 */

public class Solution {


    private List<BinaryNode> preOrderList, inOrderList;

    public Solution(List<BinaryNode> preOrderList, List<BinaryNode> inOrderList) {
        this.preOrderList = preOrderList;
        this.inOrderList = inOrderList;
    }

    /**
     * 从前序遍历和中序遍历  获取原来的二叉树
     *
     * @return
     */
    public BinaryNode restoreBinaryTree() {
        if (preOrderList == null || inOrderList == null || preOrderList.size() != inOrderList.size()) {
            return null;
        }
        //构造二叉树
        return helper(0, preOrderList.size() - 1, 0, inOrderList.size() - 1);
    }

    /**
     * 每一次返回子二叉树的根节点
     *
     * @param preOrderLeft
     * @param preOrderRight
     * @param inOrderLeft
     * @param inOrderRight
     * @return
     */
    public BinaryNode helper(int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        BinaryNode rootNode = new BinaryNode(preOrderList.get(preOrderLeft).value, null, null);
        //弹出条件
        if (preOrderLeft >= preOrderRight || inOrderLeft >= inOrderRight) {
            return rootNode;
        }
        //构造root左右节点  进行递归操作.
        //1.找到root在中序遍历中的位置
        int rootInoderIndex = 0;
        for (int i = inOrderLeft; i <= inOrderRight; i++) {
            if (inOrderList.get(i).value == rootNode.value) {
                rootInoderIndex = i;
            }
        }
        //2将前序遍历拆分开
        Set<Integer> leftInOrderSet = new HashSet<>();
        for (int i = inOrderLeft; i < rootInoderIndex; i++) {
            leftInOrderSet.add(inOrderList.get(i).value);
        }
        int preorderDivideIndex = preOrderLeft+1;
        for (int i = preOrderLeft + 1; i <= preOrderRight; i++) {
            if (leftInOrderSet.contains(preOrderList.get(i).value)) {
                preorderDivideIndex++;
            }
        }
        //构造左右节点
        System.out.println(preOrderLeft + 1 + "   " + (preorderDivideIndex - 1));
        System.out.println(inOrderLeft + "   " + (rootInoderIndex - 1));
        //
        System.out.println(preorderDivideIndex + "   " + preOrderRight);
        System.out.println((rootInoderIndex + 1) + "   " + inOrderRight);
        if (preOrderLeft + 1 <= preorderDivideIndex - 1) {
            rootNode.leftNode = helper(preOrderLeft + 1, preorderDivideIndex - 1, inOrderLeft, rootInoderIndex - 1);
        }
        if (preorderDivideIndex <= preOrderRight) {
            rootNode.rightNode = helper(preorderDivideIndex, preOrderRight, rootInoderIndex + 1, inOrderRight);
        }
        return rootNode;
    }

    public static void main(String[] args) {
        //生成测试数据
        List<BinaryNode> preOrderList = new ArrayList<>();
        List<BinaryNode> inOrderList = new ArrayList<>();
        int[] preOrderArray = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrderArray = {4, 7, 2, 1, 5, 3, 8, 6};
        for (int i : preOrderArray) {
            preOrderList.add(new BinaryNode(i, null, null));
        }
        for (int i : inOrderArray) {
            inOrderList.add(new BinaryNode(i, null, null));
        }
        //重建二叉树
        BinaryNode head = new Solution(preOrderList, inOrderList).restoreBinaryTree();
        Utils.printBinaryTreeByRow(head);
    }
}
