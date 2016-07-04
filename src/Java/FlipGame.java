package Java;

import java.util.ArrayList;
import java.util.List;

/**
 * Time : O(n)
 */
public class FlipGame {

    public static void main(String[] args) {
        FlipGame fg = new FlipGame();
        String s = "+---++--+++-+-+--+";
        List<String> result = fg.getFlipResult(s);
        System.out.println(result);
    }

    public List<String> getFlipResult(String s) {
        List<String> res = new ArrayList<String>();
        if (s.length() < 2) return res;
        search(s, res);
        return res;
    }

    public void search(String s, List<String> res) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                res.add(t);
            }
        }
    }
}