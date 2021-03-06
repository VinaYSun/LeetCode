package Java;

/**
 * 1. bit manipulation, O(1)
 * 2. e.g. 1000 ^ 0111 -> 0000 == 0 (^ ->且)
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n){
        if (n <= 0) {
            return false;
        }
        boolean result = (n & (n - 1)) == 0 ? true : false;
        return result;
    }
}
