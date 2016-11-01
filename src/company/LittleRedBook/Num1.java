package company.LittleRedBook;

import java.util.*;

/**
 * Created by ssthouse on 30/10/2016.
 */
public class Num1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.next().toCharArray();
        Stack<Character> charStack = new Stack<>();
        for (char c : chars) {
            if (c == '(' ) {
                charStack.push(c);
                continue;
            }
            if (charStack.isEmpty()) {
                continue;
            }
            if (charStack.peek() == '(' && c == ')') {
                charStack.pop();
            }
        }
        //check is has same ( and )
        int leftNum = 0, rightNum = 0;
        for (char c : chars) {
            if(c == '(')
                leftNum++;
            if(c == ')')
                rightNum++;
        }

        //output
        if (charStack.isEmpty() && leftNum == rightNum) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
