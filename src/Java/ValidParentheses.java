package Java;

import java.util.Stack;

/**
 * 1. 遇到左括号([{ 压入栈
 *    注意语法 "([{".contains(); char->String, String.valueOf(char)
 * 2. 遇到对应的右括号，将括号从弹出stack；其他情况，返回非
 * 3. 左右括号匹配的helper function
 * 4. 左右括号相等的条件，stack非空 且(!) helper返回true
 * 5. 最后，若stack为空，则是valid
 *
 */
public class ValidParentheses {
    private boolean isValidParenthese(char c1, char c2) {
        return (c1 == '(' && c2 == ')') ||
                (c1 == '[' && c2 == ']') ||
                (c1 == '{' && c2 == '}');
    }

    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c: s.toCharArray()) {
            if ("([{".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && isValidParenthese(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
