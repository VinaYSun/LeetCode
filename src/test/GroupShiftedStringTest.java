package test;

import main.GroupShiftedString;

/**
 *
 */
public class GroupShiftedStringTest {

    public static void main(String[] args) {

        GroupShiftedString gss = new GroupShiftedString();
        String[] str = {"abc", "bcd", "cde", "ab" , "bc", "cd", "abcd", "bcde"};
        System.out.println(gss.groupStrings(str));

    }
}
