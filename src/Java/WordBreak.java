package Java;

import java.util.Set;

/**
 * Created by ysun on 5/12/16.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int maxLength = 0;
        for (String str : dict) {
            maxLength =  Math.max(maxLength, str.length());
        }
        // state = isBreakable[i] : string from 0 to ith, can be segmented.
        boolean[] isBreakable = new boolean[s.length() + 1];
        // initial = isBreakable[0]
        isBreakable[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            // isBreakable[i] : {isBreakable[j] && dict.contains(s.subString(j + 1, i)); j < i}
            isBreakable[i] = false;
            for (int j = 1; j <= maxLength && j <= i; j++ ) {
                if (!isBreakable[i - j]) {
                    continue;
                }
                String word = s.substring(i - j, i);
                if (dict.contains(word)) {
                    isBreakable[i] = true;
                    break;
                }
            }
        }

        return isBreakable[s.length()];
    }
}
