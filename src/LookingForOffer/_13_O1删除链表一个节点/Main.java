package LookingForOffer._13_O1删除链表一个节点;

import LookingForOffer.Node;
import LookingForOffer.Utils;

/**
 * Created by ssthouse on 16/9/13.
 */
public class Main {

    public Node removeNode(Node headNode, Node removeNode) {
        if (headNode.nextNode == null) {
            headNode = null;
            return null;
        }
        //case: last node should be removes
        if (removeNode.nextNode == null) {
            removeNode = null;
            return headNode;
        }
        //移动后一个节点的value 到前一个节点
        removeNode.value = removeNode.nextNode.value;
        removeNode.nextNode = removeNode.nextNode.nextNode;
        return headNode;
    }


    public static void main(String[] args) {
        Node headNode = new Node(0, null);
        Node tempNode = headNode;
        Node removeNode = null;
        for (int i = 1; i < 10; i++) {
            tempNode.nextNode = new Node(i, null);
            if (i == 3) {
                removeNode = tempNode.nextNode;
            }
            tempNode = tempNode.nextNode;
        }
        //test
        Main main = new Main();
        main.removeNode(headNode, removeNode);
        Utils.printNodeList(headNode);
    }
}
