package LookingForOffer._17_合并两个有序的链表;

import LookingForOffer.Node;

/**
 * Created by ssthouse on 16/9/18.
 */
public class Main {


    public Node mergeSortedTwoList(Node fistHead, Node secHead) {
        Node headNode = new Node(0, null);
        Node tempNode = headNode;
        while (fistHead != null && secHead != null) {
            if (fistHead.value <= secHead.value) {
                tempNode.nextNode = fistHead;
            }else{
                tempNode.nextNode = secHead;
            }
            tempNode = tempNode.nextNode;
        }
        if (fistHead != null) {
            tempNode.nextNode = fistHead;
        }
        if (secHead != null) {
            tempNode.nextNode = secHead;
        }
        return headNode;
    }


//    public static void main(String[] args) {
//        Main main = new Main();
//        Node fistNode = Utils
//    }
}
