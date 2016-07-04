package Java;

/**
 * Implement the square root of an integer.
 *
 * Start: 1; End: x [long]
 * start + 1 < end : mid * mid <=, >
 * end * end ; start * start
 *
 * @Return integer
 */
public class SquareRoot {

    public int sqrt(int x) {
        long start, end;
        start = 1;
        end = x;
        while(start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(end * end <=x ) {
            return (int) end;
        }
        return (int) start;
    }
}
