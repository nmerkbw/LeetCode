package com.jxs.easy;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/3/27.
 */
public class LongestCommPrefix {

    public String longestCommonPrefix(String[] strs) {

        int length = strs.length;
        int num = 0;
        String commonPrefix = "";
        StringBuilder common = new StringBuilder();
        if (length < 1) {
            return "";
        } else if (length == 1) {
            return strs[0];
        }
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
        if (length == 2) {
            return common.toString();
        }
        for (int i = 2; i < length; i++) {

            char[] chars = strs[i].toCharArray();
            char[] commons = common.toString().toCharArray();
            int cLength = 0;
            if (chars == null) {
                return "";
            }
            if (commons.length <= chars.length) {
                cLength = commons.length;
            } else {
                cLength = chars.length;
            }
            for (int j = 0; j < cLength; j++) {
                if (commons[j] == chars[j]) {
                    num++;
                }
            }
        }
        return common.toString().substring(0, num);
    }

    @Test
    public void test() {

        String[] strs = {"aac","acab","aa","abba","aa"};
        System.out.println(longestCommonPrefix(strs));
    }
}
