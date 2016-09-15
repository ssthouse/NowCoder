package LookingForOffer._15_链表中倒数第k个节点;

import LookingForOffer.Node;
import LookingForOffer.Utils;

/**
 * Created by ssthouse on 16/9/15.
 */
public class Main {

    public void getResult(Node headNode, int k) {
        if (headNode == null || k < 0) {
            return;
        }
        Node fastNode = headNode;
        Node slowNode = headNode;
        for (int i = 0; i < k - 1; i++) {
            if (fastNode == null) {
                return;
            }
            fastNode = fastNode.nextNode;
        }
        while (fastNode.nextNode != null) {
            fastNode = fastNode.nextNode;
            slowNode = slowNode.nextNode;
        }
        System.out.println("result:\t" + slowNode.value);
    }


    public static void main(String[] args) {
        Main main = new Main();
        Node headNode = Utils.generateTenNode();
        //删除节点
        main.getResult(headNode, 3);
    }

}
