package LookingForJob._5.从尾到头打印链表;

import java.util.Stack;

/**
 * Created by ssthouse on 16/8/28.
 */

class Node{
    int value;
    Node nextNode;

    public Node(int value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }
}


public class Solution {

    
    private Node headNode;

    public Solution(Node headNode) {
        this.headNode = headNode;
    }

    public void getResult() {
        Stack<Node> nodeStack = new Stack<>();
        Node tempNode = headNode;
        while (tempNode != null) {
            nodeStack.push(tempNode);
            tempNode = tempNode.nextNode;
        }
        while ((!nodeStack.isEmpty())) {
            System.out.println(nodeStack.pop().value);
        }
    }

    public void getResultByRecursive(){
        recursiveHelper(headNode);
    }

    public void recursiveHelper(Node node) {
        if (node == null) {
            return;
        }
        recursiveHelper(node.nextNode);
        System.out.println(node.value);
    }

    public static void main(String[] args) {
        //构造一个链表
        Node head = new Node(-1, null);
        Node tempNode = head;
        for (int i = 0; i < 10; i++) {
            tempNode.nextNode = new Node(i, null);
            tempNode = tempNode.nextNode;
        }
        
        Solution solution = new Solution(head);
        //用栈实现
        solution.getResult();
        //用递归实现
        System.out.println("*************************");
        solution.getResultByRecursive();
    }



}
