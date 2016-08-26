package Huawei2016.最高分是多少;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 问题描述:
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 * <p>
 * 对于每一次询问操作，在一行里面输出最高成绩.
 * <p>
 * 输入例子:
 * 5 7
 * 1 2 3 4 5
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 * <p>
 * 输出例子:
 * 5
 * 6
 * 5
 * 9
 * Created by ssthouse on 16/6/26.
 */
public class Main {

    static class Student {
        int id;
        int score;

        public Student(int id, int score) {
            this.id = id;
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        //执行操作
        public void operate(Operation operation) {

        }
    }

    static class Operation {
        //是否为查询操作
        boolean isQuery;

        //操作的两个参数
        int num1, num2;

        public Operation(char operateChar, int num1, int num2) {
            isQuery = operateChar == 'Q';
            if(isQuery) {
                if(num1 < num2) {
                    this.num1 = num1;
                    this.num2 = num2;
                }else{
                    this.num1 = num2;
                    this.num2 = num1;
                }
            }else{
                this.num1 = num1;
                this.num2 = num2;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            //用一个List存储所有成绩  list size 为 第一个数字
            //用一个List存储所有操作  list size 为 第二个数字
            List<Student> studentList = new ArrayList<>();
            List<Operation> operationList = new ArrayList<>();
            int studentNumber = scanner.nextInt();
            int operateNumber = scanner.nextInt();
            for (int i = 0; i < studentNumber; i++) {
                studentList.add(new Student(i + 1, scanner.nextInt()));
            }
            for (int i = 0; i < operateNumber; i++) {
                operationList.add(new Operation(scanner.next().charAt(0), scanner.nextInt(), scanner.nextInt()));
            }
            //执行操作
            for (Operation operation : operationList) {
                //读操作
                int maxScore = 0;
                if (operation.isQuery) {
                    maxScore = 0;
                    for (int i = operation.num1 - 1; i < operation.num2; i++) {
                        if (studentList.get(i).getScore() > maxScore) {
                            maxScore = studentList.get(i).getScore();
                        }
                    }
                    System.out.println(maxScore);
                } else {
                    //写操作
                    studentList.get(operation.num1 - 1).setScore(operation.num2);
                }
            }
        }
    }
}
