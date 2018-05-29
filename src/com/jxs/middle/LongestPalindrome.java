package com.jxs.middle;

/**
 * Created by jiangxs on 2018/5/21.
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {

        int length = s.length();
        String substr;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                substr = s.substring(i, j);
                boolean flag = isPalindrome(substr);
                if (flag) {
                    str.append(substr);
                    str.append(",");
                }
            }
        }
        String[] strs = str.toString().split(",");
        String maxStr = "";
        for (int i = 0; i < strs.length; i++) {
            if (maxStr.length() <= strs[i].length()) {
                maxStr = strs[i];
            }
        }
        return maxStr;
    }

    public boolean isPalindrome(String s) {

        int length = s.length();
        int remainder = length % 2;
        char[] sArray = s.toCharArray();
        int index = length - 1;

        if (remainder == 0) {
            for (int i = 0; i <= length / 2; i++) {
                if (index > (length / 2 - 1) && index > 0 && sArray[i] == sArray[index]) {
                    index--;
                    continue;
                } else {
                    if (index > (length / 2 - 1) && index > 0) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            for (int i = 0; i <= (length - 1) / 2; i++) {
                if (index > (length - 1) / 2 && index > 0 && sArray[i] == sArray[index]) {
                    index--;
                    continue;
                } else {
                    if (index > (length - 1) / 2 && index > 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {

        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("sss"));
    }
}
