package com.jxs.middle;

/**
 * Created by jiangxs on 2018/5/16.
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        int maxnum = 0;
        int index = 0;
        char[] strArray = s.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            for (int j = index; j < i; j++) {
                if (strArray[j] == strArray[i]) {
                    index = j + 1;
                    break;
                }
            }
            maxnum = Math.max(maxnum, i - index + 1);
        }
        return maxnum;
    }

    public int lengthOfLongestSubstring1(String s) {

        int endindex = 0;
        int temp = 0;
        char[] strArray = s.toCharArray();
        if (s.length() == 1) {
            return 1;
        }
        for (int i = 0; i < strArray.length; i++) {
            for (int j = i + 1; j < strArray.length; j++) {
                String substring = s.substring(i, j);
                String str = new String(String.valueOf(strArray[j]));
                if (substring.contains(str)) {
                    temp = j - i;
                    if (endindex < temp) {
                        endindex = temp;
                    }
                    break;
                } else if (!substring.contains(str) && j == strArray.length - 1) {
                    temp = j - i + 1;
                    if (endindex < temp) {
                        endindex = temp;
                    }
                    break;
                }
            }
        }
        return endindex;
    }

    public static void main(String[] args) {

        LongestSubstring l = new LongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
        //System.out.println(l.lengthOfLongestSubstring1("a"));
    }
}
