package main;

/**
 * 1. 核心语句，加入Character.toLowerCase, 排除大小写不同情况
 * 2. 非字母、数字判断，Character.isLetter .isDigit
 * 3. 非字母、数字，移位直至边界
 * 4. 排除全部字符非字母、数字情况
 * 5. 返回值条件，头指针必须等于或者大于尾指针
 *
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < s.length() && !isValid(s.charAt(start))) {
                start++;
            }
            if (start == s.length()) { // invalid string "***^^%"
                return true;
            }
            while (end >= 0 && !isValid(s.charAt(end))) {
                end--;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){ //"aAAA"
                break;
            } else {
                start++;
                end--;
            }
        }
        if (start >= end) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
