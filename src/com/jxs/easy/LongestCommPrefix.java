package com.jxs.easy;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/3/27.
 */
public class LongestCommPrefix {

    public String longestCommonPrefix(String[] strs) {

        System.out.println();
        int length = strs.length;
        boolean flag = false;
        String commonPrefix = null;
        StringBuilder common = new StringBuilder();
        char[] charStr1 = strs[0].toCharArray();
        char[] charStr2 = strs[1].toCharArray();
        int currLength = 0;
        if (charStr1.length >= charStr2.length) {
            currLength = charStr2.length;
        } else if (charStr1.length < charStr2.length) {
            currLength = charStr1.length;
        }
        for (int i = 0; i < currLength; i++) {
            if (charStr1[i] == charStr2[i]) {
                char c = charStr1[i];
                String s = String.valueOf(c);
                common = common.append(s);
            } else {
                break;
            }
        }
        for (int i = 2; i < length; i++) {

            char[] chars = strs[i].toCharArray();
            char[] commons = common.toString().toCharArray();
            for (int j = 0; j < commons.length; j++) {
                if (commons[j] != chars[j]) {
                    commonPrefix = common.toString().substring(0, j);

                }
            }
        }
        return commonPrefix;
    }

    @Test
    public void test() {

        String[] strs = {"abcdefg", "abc", "abdc"};
        System.out.println(longestCommonPrefix(strs));
    }
}
