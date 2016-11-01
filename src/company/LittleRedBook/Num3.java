package company.LittleRedBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ssthouse on 30/10/2016.
 */
public class Num3 {

    public static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int midSize = scanner.nextInt();
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Node newNode = new Node(scanner.nextInt());
            nodeList.add(newNode);
        }
        //rotate
        new Num3().rotateList(nodeList.get(0), midSize);
        String result = "";
        for (Node node : nodeList) {
            result += node.val + " ";
        }
        System.out.println(result.substring(0, result.length() - 1));
    }

    public Node rotateList(Node head, int n) {
        List<Node> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        //
        int size = nodeList.size();
        if (size % 2 == 0 && n % 2 == 0) {
            int left = size / 2 - 1 - n / 2;
            int right = size / 2 + n / 2;
            //rotate
            while (left >= 0 && right < size) {
                left--;
                right++;
                swap(nodeList, left, right);
            }
        } else if (size % 2 == 0 && n % 2 != 0) {
            int left = size / 2 + 1;
            int right = left;
            right += n / 2 ;
            left += n / 2 - (n > 1 ? 1 : 0);

        }
        return null;
    }

    private void swap(List<Node> nodeList, int leftIndex, int rightIndex) {
        int temp = nodeList.get(leftIndex).val;
        nodeList.get(leftIndex).val = nodeList.get(rightIndex).val;
        nodeList.get(rightIndex).val = temp;
    }
}
