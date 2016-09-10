package LookingForOffer._7_1_用两个队列实现一个栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ssthouse on 16/9/10.
 */
public class Solution {

    private Queue<Integer> queueOne = new LinkedList<Integer>();
    private Queue<Integer> queueTwo = new LinkedList<Integer>();

    public int pop() {
        int result = 0;
        if (!queueOne.isEmpty()) {
            int queueSize = queueOne.size();
            while (queueSize-- > 1) {
                queueTwo.add(queueOne.poll());
            }
            result = queueOne.poll();
        }else if (!queueTwo.isEmpty()) {
            int queueSize = queueTwo.size();
            while (queueSize-- > 1) {
                queueOne.add(queueTwo.poll());
            }
            result = queueTwo.poll();
        }
        return result;
    }

    public Solution push(int num) {
        Queue queue = queueOne.isEmpty() ? queueTwo : queueOne;
        queue.add(num);
        return this;
    }


    public boolean isEmpty() {
        if (queueOne.isEmpty() && queueTwo.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1)
                .push(2)
                .push(3)
                .push(4);
        while (!solution.isEmpty()) {
            System.out.println(solution.pop());
        }

    }
}
