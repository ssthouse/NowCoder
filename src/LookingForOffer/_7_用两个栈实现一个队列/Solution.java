package LookingForOffer._7_用两个栈实现一个队列;

import java.util.Stack;

/**
 * Created by ssthouse on 16/9/6.
 */
public class Solution {


    private Stack<Integer> stackOne = new Stack<>();
    private Stack<Integer> stackTwo = new Stack<>();


    //用两个栈实现
    public Solution push(int num) {
        //将stack2中数据还原到stack1中
        while (!stackTwo.isEmpty()) {
            stackOne.add(stackTwo.pop());
        }
        //
        stackOne.add(num);
        return this;
    }

    public int pop() {
        while (!stackOne.isEmpty()) {
            stackTwo.add(stackOne.pop());
        }
        if (stackTwo.isEmpty()) {
            try {
                throw new Exception("empty ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stackTwo.pop();
    }

    public boolean isEmpty() {
        if (stackOne.isEmpty() && stackTwo.isEmpty()) {
            return true;
        }
        return false;
    }


    /****************************
     * test
     ******************************/

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
