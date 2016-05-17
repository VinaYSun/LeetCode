package main;

import java.util.HashMap;

/**
 * Created by ysun on 5/9/16.
 */
public class StrobogrammaticNumber {
    /**
     * 0. 数字为空的判断
     * 1. Map <key, value> Type, Character * 2
     * 2. putting values into map, syntax e.g. '1'
     * 3. 判断条件，不存在在Map里，或者左右不是互为键值对儿
     *
     * Time : O(1)
     * Space : O(n)
     */

    public boolean isStrobogrammaticNumber(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);

            if ( !map.containsKey(cLeft) || map.get(cLeft) != cRight) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
