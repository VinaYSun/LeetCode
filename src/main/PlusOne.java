package main;

/**
 * Created by ysun on 5/10/16.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carries = 1;
        for (int i = digits.length - 1; i >= 0 && carries > 0; i--) {
            int newvalue = digits[i] + carries;
            digits[i] = newvalue % 10; // for cases 9 (+1)
            carries = newvalue / 10;
        }
        if (carries == 0) {
            return digits;
        }
        int[] result = new int[digits.length + 1]; // 最高位进位情况
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
             result[i] = digits[i - 1];
        }
        return result;
    }
}
