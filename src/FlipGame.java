import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysun on 3/26/16.
 */
public class FlipGame {
    @Test
    public void test() {
        String[] testcase = {"+", "-", "++", "--", "+++", "++++", "+--+", "-+-+", "+-+-"};
        for (int i = 0; i < testcase.length; i++) {
            System.out.println(getFlipResult(testcase[i]));
        }
    }

    public List<String> getFlipResult(String s1) {
        List<String> res = new ArrayList<String>();
        if (s1.length() < 2) return res;
        search(s1, res, 0);
        return res;
    }

    public void search(String s1, List<String> res, int len) {
        for (int i = len; i < s1.length() - 1; i++) {
            if (s1.charAt(i) == '+' && s1.charAt(i) == s1.charAt(i + 1)) {
                String t1 = s1.substring(0, i) + "--" + s1.substring(i + 2);
                res.add(t1);
            }
        }
    }
}