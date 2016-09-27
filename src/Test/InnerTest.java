package Test;

/**
 * Created by ssthouse on 2016/9/23.
 */
public class InnerTest {


    private int count;

    public void addCount(AbsClass absClass) {

    }

    public void test(int param){
        addCount(new AbsClass() {
            @Override
            public void func() {
//                param++;
                count++;
            }
        });
    }
}
