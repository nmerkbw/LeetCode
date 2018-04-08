package com.jxs.easy;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/3/27.
 */
public class LongestCommPrefix {

    public String longestCommonPrefix(String[] strs) {

        int length = strs.length;
        int num = 0;
        StringBuilder common = new StringBuilder();

        if (length == 0) {
            return "";
        } else if (length == 1) {
            return strs[0];
        }

        // 如果字符串数目不少于2，则设置公共串为前两个的
        // 如果后面的与公共的相同的更少，将少的代替公共的
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
                common = common.append(String.valueOf(charStr1[i]));
            } else {
                break;
            }
        }
        // 如果只有两个字符串，之前的公共部分就是最后所求的公共部分
        if (length == 2) {
            return common.toString();
        }
        // 字符串数目大于2时
        for (int i = 2; i < length; i++) {

            num = 0;
            char[] chars = strs[i].toCharArray();
            char[] commons = common.toString().toCharArray();
            int cLength = 0;
            if (chars == null || chars.length == 0) {
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
                    continue;
                }
            }
            // 从不相同的地方开始，后面的字符串全部删除
            common = common.delete(num,commons.length);
        }
        return common.toString();
    }

    @Test
    public void test() {

        String[] strs = {"ac","ac","a","a"};

        System.out.println(longestCommonPrefix(strs));
    }
}
