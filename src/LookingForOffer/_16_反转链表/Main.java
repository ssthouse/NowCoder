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
    
    public static void main(String[] args) {
        Main main = new Main();
        //生成测试数据
        Node headNode = Utils.generateTenNode();
        //得到新的头结点
        Node newHead = main.reverse(headNode);
        //打印结果
        Utils.printNodeList(newHead);
    }
}
