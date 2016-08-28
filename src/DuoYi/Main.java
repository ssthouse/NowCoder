package DuoYi;

/**
 * Created by ssthouse on 16/8/27.
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.dfs(0, 0);
        System.out.println(main.result);

    }

    public  int result = 0;

    private void dfs(int left, int right) {
        if (left == 6 && right == 6) {
            result++;
            return;
        }

        if (left > 6 || right > 6) {
            return;
        }

        if (left == 2 && right == 2) {
            return;
        }
        if (left == 4 && right == 4) {
            return;
        }

        if (left <= 6) {
            dfs(left+1, right);
        }

        if (right <= 6) {
            dfs(left, right+1);
        }
    }
}
