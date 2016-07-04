package Java;

/**
 * Created by ysun on 5/1/16.
 * Solution 1: brute force
 * Solution 2: "KMP"
 */
public class StrStr {

    public static void main(String[] args) {
        String source = "abcdef";
        String target = "bcd";

        StrStr s = new StrStr();
        s.strStr2(source, target);
        System.out.println("Result is : " + s.strStr2(target, source));
    }
    /**
     * O((n-m+1) * m)
     *
     * Brute-force, worst case O(nm)
     */
    public int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)){
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * KMP SubString search
     */

}
