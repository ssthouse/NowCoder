package LookingForOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ssthouse on 16/9/5.
 */
public class Utils {

    public static void printLine(String string) {
        for (int i = 0; i < 100; i++) {
            System.out.print(string);
        }
        System.out.println();
    }

//    public static void getOddNoede() {
//        Node headNode = new Node(0, null);
//        Node tempNode = headNode;
//        for (int i = 0; i < 5; i++) {
//            tempNode.nextNode = new Node(i * 2 + 1, null);
//            tempNode.
//        }
//    }

    public static void printBinaryTreeByRow(BinaryNode head) {
        if (head == null) {
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(head);
        queue.add(null);
        while (!queue.isEmpty()) {
            BinaryNode tempNode = queue.poll();
            if (tempNode == null) {
                System.out.print("\n");
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                    continue;
                }
            }
            if (tempNode.leftNode != null)
                queue.add(tempNode.leftNode);
            if (tempNode.rightNode != null)
                queue.add(tempNode.rightNode);
            System.out.print(tempNode.value + " ");
        }
    }

    public static void printNodeList(Node headNode) {
        while (headNode != null) {
            System.out.println(headNode.value);
            headNode = headNode.nextNode;
        }
    }

    public static Node generateTenNode() {
        Node headNode = new Node(1, null);
        Node tempNode = headNode;
        for (int i = 2; i <= 10; i++) {
            tempNode.nextNode = new Node(i, null);
            tempNode = tempNode.nextNode;
        }
        return headNode;
    }

    public static void log(Object msg) {
        System.out.println(msg);
    }

}
