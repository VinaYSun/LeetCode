package main;

/**
 * Created by ysun on 5/1/16.
 */
public class StrStr {

    public static void main(String[] args) {
        String source = "abcdef";
        String target = "bcd";

        StrStr s = new StrStr();
        s.strStr2(source, target);
        System.out.println("Result is : " + s.strStr2(source, target));
    }
    /**
     * This code was newly wrote on May 1st, 2016
     *
     * O((n-m+1) * m)
     *
     */
    public int strStr2(String source, String target) {
        if (target == null || source == null) {
            return -1;
        }
        for (int i = 0; i < source.length() - target.length() + 1; i++ ) {
            int j;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
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
     * This code was copied from the very first submission in Nov, 2015
     * For comparison purpose
     *
     * @param source
     * @param target
     * @return
     */
    public int strStr(String source, String target) {
        //write your code here
        if (target == null) {
            return -1;
        }
        if (source == null) {
            return -1;
        }
        if (target.isEmpty()){
            return 0;
        }
        if (source.isEmpty()){
            return -1;
        }
        if (source.length() < target.length()){
            return -1;
        }
        int sourcepointer;
        int targetpointer;
        for (int i = 0; i < source.length(); i++){
            sourcepointer = i;
            if (source.length() - i < target.length()){
                return -1;
            }
            for (int j = 0; j < target.length(); j++) {
                if (target.charAt(j) != source.charAt(sourcepointer)){
                    break;
                }
                sourcepointer++;
                if (j == target.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

}
