package may;

/**
 * Created by ysun on 5/12/16.
 */
public class ClimbingStairs {
    // saving space
    public int climb(int n) {
        if (n <= 1) {
            return 1;
        }
        // start, 最后一阶，和倒数第二阶
        int last = 1, lastlast = 1;
        int now = 0;
        // top down
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }

}
