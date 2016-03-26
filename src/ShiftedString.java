import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ysun on 3/20/16.
 */
public class ShiftedString {

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> m = new HashMap<String, List<String>>();
        for (int i = 0; i < strings.length; i ++ ) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < strings[i].length(); j++) {
                sb.append(Integer.toString(((strings[i].charAt(j+1) - strings[i].charAt(0)) + 26 )% 26 ));
                sb.append(" ");
            }
            String shift = sb.toString();
            if ( m.containsKey(shift)) {
                m.get(shift).add(strings[i]);
            } else {
                List<String> l = new ArrayList<String>();
                l.add(strings[i]);
                m.put(shift, l);
            }
        }
        for (String s : m.keySet()) {
            Collections.sort(m.get(s));
            result.add(m.get(s));
        }
        return result;
    }
}
