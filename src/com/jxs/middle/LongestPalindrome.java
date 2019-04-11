package com.jxs.middle;

/**
 * Created by jiangxs on 2019/4/11.
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {

        int length = s.length();
        if (length == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            int len1 = isPalindrome(s, i, i);
            int len2 = isPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int isPalindrome(String s, int left, int right) {

        char[] strArray = s.toCharArray();
        int length = strArray.length;
        int l = left;
        int r = right;
        while (l >= 0 && r < length && strArray[l] == strArray[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {

        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome(""));
    }
}
