package MonkeyProblemBuck.Num1;

import java.util.List;

/**
 * Created by ssthouse on 16/9/6.
 */


public class Main {


    public static void main(String[] args){
        float a = 12.3f;

        Object obj = new Object();
       boolean bool = obj instanceof Object;

        System.out.println(a);
    }

//    int getLuckyPrice(int price, List<Integer> unluckNumbers) {
//        // TODO
//        unluckNumbers.add(0);
//        while(!isSatisfied(price)){
//            price++;
//        }
//        return price;
//    }
//
//    boolean isSatisfied(int price, List<Integer> numbers){
//        int curNum = 0;
//        while(price>0){
//            curNum = price%10;
//            price /= 10;
//            if(numbers.contains(curNum)){
//                return false;
//            }
//        }
//        return true;
//    }
}
