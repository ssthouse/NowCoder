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
     * @param node
     * @return
     */
    public Node reverseRecursive(Node node) {
        if (node.nextNode == null) {
            return node;
        }
        Node nextNode = node.nextNode;
        Node resultNode = reverseRecursive(node.nextNode);


        return resultNode;
    }

    
    public static void main(String[] args) {
        Main main = new Main();
        //result One
        Node headNode = Utils.generateTenNode();
        Node newHead = main.reverse(headNode);
        Utils.printNodeList(newHead);
        Utils.printLine("*");
        //result Two
        headNode = Utils.generateTenNode();
        Node reverseIterateHead = main.reverseIterate(headNode);
        Utils.printNodeList(reverseIterateHead);
        Utils.printLine("*");
        //result Three
        headNode = Utils.generateTenNode();
        Node reverseRecursiveHead = main.reverseRecursive(headNode);
        Utils.printNodeList(reverseRecursiveHead);
        Utils.printLine("*");
    }
}
