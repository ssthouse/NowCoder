package LookingForOffer._16_反转链表;

import LookingForOffer.Node;
import LookingForOffer.Utils;

import java.util.Stack;

/**
 * Created by ssthouse on 16/9/16.
 */
public class Main {

    /**
     * 使用栈实现
     *
     * @param node
     * @return
     */
    public Node reverse(Node node) {
        if (node == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.nextNode;
        }
        //重新连接
        Node headNode = stack.pop();
        Node tempNode = headNode;
        while (!stack.isEmpty()) {
            tempNode.nextNode = stack.pop();
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = null;
        return headNode;
    }

    /**
     * 迭代实现
     *
     * @param node
     * @return
     */
    public Node reverseIterate(Node node) {
        Node preNode = null;
        Node nextNode = null;
        while (node != null) {
//            Utils.log(node.value+"   ");
            nextNode = node.nextNode;
            node.nextNode = preNode;
            //迭代下一个节点
            preNode = node;
            node = nextNode;
        }
        return preNode;
    }

    /**
     * TODO
     * 递归  传递一个参数的实现
     *
     * @param node
     * @return
     */
    public Node reverseRecursive(Node node) {
        if (node == null) {
            return null;
        }
        if (node.nextNode == null) {
            return node;
        }
        Node resultNode = reverseRecursive(node.nextNode);
        node.nextNode.nextNode = node;
        node.nextNode = null;
        return resultNode;
    }


    public static void main(String[] args) {
        Main main = new Main();
        //result One
        Utils.log("用栈实现反转");
        Node headNode = Utils.generateTenNode();
        Node newHead = main.reverse(headNode);
        Utils.printNodeList(newHead);
        Utils.printLine("*");
        //result Two
        Utils.log("迭代实现");
        headNode = Utils.generateTenNode();
        Node reverseIterateHead = main.reverseIterate(headNode);
        Utils.printNodeList(reverseIterateHead);
        Utils.printLine("*");
        //result Three
        Utils.log("递归实现: 只传递一个参数");
        headNode = Utils.generateTenNode();
        Node reverseRecursiveHead = main.reverseRecursive(headNode);
        Utils.printNodeList(reverseRecursiveHead);
        Utils.printLine("*");
    }
}
