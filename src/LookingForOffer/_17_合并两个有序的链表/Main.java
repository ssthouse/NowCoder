package LookingForOffer._17_合并两个有序的链表;

import LookingForOffer.Node;
import LookingForOffer.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssthouse on 16/9/18.
 */
public class Main {


    /**
     * 指针实现
     *
     * @param fistHead
     * @param secHead
     * @return
     */
    public Node mergeSortedTwoList(Node fistHead, Node secHead) {
        Node headNode = new Node(0, null);
        Node tempNode = headNode;
        while (fistHead != null && secHead != null) {
            if (fistHead.value <= secHead.value) {
                tempNode.nextNode = fistHead;
                fistHead = fistHead.nextNode;
            } else {
                tempNode.nextNode = secHead;
                secHead = secHead.nextNode;
            }
            tempNode = tempNode.nextNode;
        }
        if (fistHead != null) {
            tempNode.nextNode = fistHead;
        }
        if (secHead != null) {
            tempNode.nextNode = secHead;
        }
        return headNode.nextNode;
    }

    public Node mergeSortedListByList(Node fistHead, Node secHead) {
        Node tempNode = null;
        List<Node> nodeList = new ArrayList<>();
        while (fistHead != null && secHead != null) {
            if (fistHead.value > secHead.value) {
                tempNode = secHead;
                secHead = secHead.nextNode;
            } else {
                tempNode = fistHead;
                fistHead = fistHead.nextNode;
            }
            nodeList.add(tempNode);
            tempNode = tempNode.nextNode;
        }
        //加入剩下的Node
        while (fistHead != null) {
            nodeList.add(fistHead);
            fistHead = fistHead.nextNode;
        }
        while (secHead != null) {
            nodeList.add(secHead);
            secHead = secHead.nextNode;
        }
        //重组Node List
        Node head = new Node(0, null);
        Node curNode = head;
        for (Node node : nodeList) {
            curNode.nextNode = node;
            curNode = curNode.nextNode;
        }
        //
        return head.nextNode;
    }


    public static void main(String[] args) {
        Node fistHead = Utils.generateOddNode();
        Node secHead = Utils.generateEvenNode();
        Main main = new Main();
        Node mergedHead = main.mergeSortedTwoList(fistHead, secHead);
        //out node list
        Utils.printNodeList(mergedHead);

        //使用List重组实现
        Utils.printLine("*");
        Node headOne = Utils.generateOddNode();
        Node headTwo = Utils.generateEvenNode();
        Node newHead = main.mergeSortedListByList(headOne, headTwo);
        Utils.printNodeList(newHead);
    }
}
