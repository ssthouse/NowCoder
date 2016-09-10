package LookingForOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ssthouse on 16/9/5.
 */
public class Utils {

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
            if(tempNode.leftNode != null)
                queue.add(tempNode.leftNode);
            if(tempNode.rightNode != null)
                queue.add(tempNode.rightNode);
            System.out.print(tempNode.value+" ");
        }
    }

    public static void log(Object msg) {
        System.out.println(msg);
    }
}
