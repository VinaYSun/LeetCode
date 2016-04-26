package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Time : O(n) calculate code , search and insert in map O(1)
 *        Sorting in array O(n)
 *        Total O(n)
 */
public class GroupShiftedString {

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for (String s : strings) {
            String code = getCode(s);
            List<String> val = new ArrayList<String>();
            if(!map.containsKey(code)) {
                val = new ArrayList<String>();
            } else {
                val = map.get(code);
            }
            val.add(s);
            map.put(code, val);
        }

        for (String key : map.keySet()) {
            List<String> val = map.get(key);
            Collections.sort(val);
            result.add(val);
        }

        return result;
    }

    private String getCode(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() - 1; i++) {
            int temp = (s.charAt(i+1) - s.charAt(i) + 26) % 26;
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        GroupShiftedString gss = new GroupShiftedString();
        String[] str = {"abc", "bcd", "cde", "ab" , "bc", "cd", "abcd", "bcde"};
        System.out.println(gss.groupStrings(str));

    }
}
